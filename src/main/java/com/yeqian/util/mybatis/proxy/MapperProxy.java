package com.yeqian.util.mybatis.proxy;

import com.yeqian.util.mybatis.annotations.*;
import com.yeqian.util.mybatis.parse.GenericTokenParser;
import com.yeqian.util.mybatis.parse.ParameterMappingTokenHandler;
import com.yeqian.util.mybatis.type.DoubleTypeHandler;
import com.yeqian.util.mybatis.type.IntegerTypeHandler;
import com.yeqian.util.mybatis.type.StringTypeHandler;
import com.yeqian.util.mybatis.type.TypeHandler;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
    //Map集合用来存放类与其对应的Handler处理器
    private static Map<Class, TypeHandler> typeHandlerMap = new HashMap<>();
    //定义时间格式
    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    //调用无参构造器时添加相关Handler处理器
    static {
        typeHandlerMap.put(Integer.class, new IntegerTypeHandler());
        typeHandlerMap.put(String.class, new StringTypeHandler());
        typeHandlerMap.put(Double.class, new DoubleTypeHandler());

        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.获取Connection
        Connection connection = MapperProxy.getConnection();

        //获取注解
        Annotation[] annotations = method.getAnnotations();
        Annotation annotation = annotations[0];



        if (annotation instanceof Select) {
            //如果注解是Select
            //1.获取注解,原始sql语句
            Select select = method.getAnnotation(Select.class);
            String originalSql = select.value(); //原始sql
            //调用方法获取PreparedStatement对象（已解析sql，并设置参数）
            PreparedStatement ps = getPreparedStatement(method, args, originalSql, connection);

            //2.处理结果，获取ResultSet结果对象
            ResultSet rs = ps.executeQuery();
            //获取返回值类型（如果是list需得到其所指定泛型)
            Class resultType = null;
            Type type = method.getGenericReturnType();
            if (type instanceof Class) {
                //不是泛型
                resultType = (Class) type;
            } else if (type instanceof ParameterizedType) {
                //是泛型
                Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                resultType = (Class) actualTypeArguments[0];
            }

            //得到ResultSet遍历的字段
            ResultSetMetaData metaData = rs.getMetaData();
            List<String> columnNames = new ArrayList<>();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnName(i + 1);
                columnNames.add(columnName);
            }

            //3.Map集合装字段名和对应实体类的set方法
            Map<String, Method> methodMap = new HashMap<>();
            for (Method declaredMethod : resultType.getDeclaredMethods()) {
                String declaredMethodName = declaredMethod.getName();
                if (declaredMethodName.startsWith("set")) {
                    //得到所有set方法名的后部分
                    String methodName = declaredMethodName.substring(3);
                    //将该名字的首字母小写
                    methodName = methodName.substring(0, 1).toLowerCase() + methodName.substring(1);
                    while (getFirstUppercaseIndex(methodName) != -1) {
                        //存在大写字母需要转换为('_'+小写字母)
                        int index = getFirstUppercaseIndex(methodName);
                        methodName = methodName.substring(0, index) + "_" + methodName.substring(index, index + 1).toLowerCase() + methodName.substring(index + 1);
                    }
                    methodMap.put(methodName, declaredMethod);
                }
            }

            //得到实体类
            Object object = null;

            //4.处理结果
            List<Object> lists = new ArrayList<>();
            while (rs.next()) {
                object = resultType.newInstance();
                for (int j = 0; j < columnNames.size(); j++) {
                    String columnName = columnNames.get(j);
                    Method setMethod = methodMap.get(columnName);
                    //得到set方法的参数类型
                    Class<?> clazz = setMethod.getParameterTypes()[0];
                    if ("release_time".equals(columnName) && clazz == String.class) {
                        java.sql.Timestamp timestamp = rs.getTimestamp(columnName);
                        if (timestamp != null) {
                            LocalDateTime ldt = timestamp.toLocalDateTime();
                            String formattedDateTime = ldt.format(FORMATTER);
                            setMethod.invoke(object, formattedDateTime);
                        }
                    } else {
                        //执行set方法
                        setMethod.invoke(object, this.typeHandlerMap.get(clazz).getResult(rs, columnName));
                    }
                }
                lists.add(object);
            }
            Object result = null;
            //判断返回值类型是List还是实体类
            if (method.getReturnType().equals(List.class)) {
                //如果是List集合
                result = lists;
            } else {
                //如果是实体类
                if (!lists.isEmpty()) {
                    result = lists.get(0);
                }
            }

            //5.释放资源
            ps.close();
            rs.close();
            connection.close();
            return result;
        } else if (annotation instanceof Update) {
            //如果是Update
            Update update = method.getAnnotation(Update.class);
            String originalSql = update.value();//得到原始sql

            //1.获取返回类型
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> parameterType = parameterTypes[0];
            if (parameterType.isPrimitive() || parameterType == String.class || parameterType == Integer.class) {
                //2.如果参数类型是基本类型，按原来设置参数方式执行
                PreparedStatement ps = getPreparedStatement(method, args, originalSql, connection);
                ps.executeUpdate();
                ps.close();
                connection.close();
            } else {
                //2.如果参数类型是实体类
                //3.解析sql   #{} -> ?
                ParameterMappingTokenHandler tokenHandler = new ParameterMappingTokenHandler();
                String sql = new GenericTokenParser("#{", "}", tokenHandler).parse(originalSql);
                PreparedStatement ps = connection.prepareStatement(sql);

                //4.获得用户传入的实体类参数
                Object arg = args[0];
                //得到实体类所有字段名
                Field[] fields = parameterType.getDeclaredFields();

                //5.设置参数
                Map<String, Object> paramValueMappings = new HashMap<>();
                for (Field field : fields) {
                    //得到字段
                    String fieldName = field.getName();
                    field.setAccessible(true);
                    //获取字段的值
                    Object value = field.get(arg);
                    //将字段名和对应值存入paramValueMappings集合
                    paramValueMappings.put(fieldName, value);
                }
                //得到所需参数的Map集合（按顺序）
                List<String> parameterMappings = tokenHandler.getParameterMappings();
                for (int i = 0; i < parameterMappings.size(); i++) {
                    //参数名
                    String paramName = parameterMappings.get(i);
                    //参数对应的值
                    Object value = paramValueMappings.get(paramName);
                    //执行方法
                    typeHandlerMap.get(value.getClass()).setParameter(ps, i + 1, value);
                }

                ps.executeUpdate();
                //6.释放资源
                ps.close();
                connection.close();
            }
        } else if (annotation instanceof Insert) {
            //如果是Insert
            Insert insert = method.getAnnotation(Insert.class);
            String originalSql = insert.value();//得到原始sql

            extracted(method, args, originalSql, connection);
        } else if (annotation instanceof Delete) {
            //如果是Delete
            Delete delete = method.getAnnotation(Delete.class);
            String originalSql = delete.value();//得到原始sql

            extracted(method, args, originalSql, connection);
        }
        return null;
    }

    /**
     * Insert 和 Delete 获取originalSql后执行的方法
     * @param method
     * @param args
     * @param originalSql
     * @param connection
     * @throws SQLException
     * @throws IllegalAccessException
     */
    private void extracted(Method method, Object[] args, String originalSql, Connection connection) throws SQLException, IllegalAccessException {
        //1.获取返回类型
        Class<?>[] parameterTypes = method.getParameterTypes();
        Class<?> parameterType = parameterTypes[0];
        if (parameterType.isPrimitive() || parameterType == String.class || parameterType == Integer.class) {
            //2.如果参数类型是基本类型，按原来设置参数方式执行
            PreparedStatement ps = getPreparedStatement(method, args, originalSql, connection);
            ps.executeUpdate();
            ps.close();
            connection.close();
        } else {
            //2.如果参数类型是实体类
            //3.解析sql   #{} -> ?
            ParameterMappingTokenHandler tokenHandler = new ParameterMappingTokenHandler();
            String sql = new GenericTokenParser("#{", "}", tokenHandler).parse(originalSql);
            PreparedStatement ps = connection.prepareStatement(sql);

            //4.获得用户传入的实体类参数
            Object arg = args[0];
            //得到实体类所有字段名
            Field[] fields = parameterType.getDeclaredFields();

            //5.设置参数
            for (int i = 0; i < fields.length; i++) {
                //跳过id字段
                if (i > 0) {
                    //得到字段
                    Field field = fields[i];
                    field.setAccessible(true);
                    //获取字段的值
                    Object value = field.get(arg);
                    //设置参数
                    if (value != null) {
                        if (value.getClass() == String.class && ((String) value).isEmpty()) {
                            this.typeHandlerMap.get(value.getClass()).setParameter(ps, i, null);
                        } else {
                            this.typeHandlerMap.get(value.getClass()).setParameter(ps, i, value);
                        }
                    }
                }
            }
            ps.executeUpdate();
            //6.释放资源
            ps.close();
            connection.close();
        }
    }

    /**
     * 解析sql并设置参数
     * @param method
     * @param args
     * @param originalSql
     * @param connection
     * @return
     * @throws SQLException
     */
    private PreparedStatement getPreparedStatement(Method method, Object[] args, String originalSql, Connection connection) throws SQLException {
        //1.解析sql   #{} -> ?
        ParameterMappingTokenHandler tokenHandler = new ParameterMappingTokenHandler();
        String sql = new GenericTokenParser("#{", "}", tokenHandler).parse(originalSql);

        //2.获取所需参数集合
        List<String> parameterMappings = tokenHandler.getParameterMappings();

        PreparedStatement ps = connection.prepareStatement(sql);

        //3.Map集合用来装参数名和对应的值
        Map<String, Object> paramValuesMap = new HashMap<>();

        //得到方法的所有参数
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            //获取Param注解
            Param param = parameter.getAnnotation(Param.class);
            //得到Param注解的属性来获取参数名
            String paramName = param.value();
            //将参数名和对应值放入paramValuesMap
            paramValuesMap.put(paramName, args[i]);
        }

        //4.为sql设置参数值
        for (int i = 0; i < parameterMappings.size(); i++) {
            //得到所需参数名
            String paramName = parameterMappings.get(i);
            //得到所需参数名的对应值
            Object value = paramValuesMap.get(paramName);
            //通过传入对应参数类型来获取对应字段类型处理器来设置参数
            if (value != null) {
                this.typeHandlerMap.get(value.getClass()).setParameter(ps, i + 1, value);
            } else {
                this.typeHandlerMap.get(String.class).setParameter(ps, i + 1, null);
            }
        }
        return ps;
    }

    //获取连接
    public static Connection getConnection() {
        try {
            //获取连接
            String url = "jdbc:mysql:///qg_test?useSSL=false&characterEncoding=utf-8";
            String username = "root";
            String password = "qnbz7089yq";
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //得到字符串第一个大写字母的索引
    public static int getFirstUppercaseIndex(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                return i;
            }
        }
        return -1;  // 如果没有大写字母，返回 -1
    }
}
