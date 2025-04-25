package com.yeqian.controller.servlet;

import com.alibaba.fastjson.JSON;
import com.yeqian.pojo.User;
import com.yeqian.service.UserService;
import com.yeqian.service.impl.UserServiceImpl;
import com.yeqian.util.FileReader.KeyFileReader;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.util.List;

@WebServlet("/userServlet/*")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();
    private static final String UPLOAD_DIR = "uploads";
    private static final String PROJECT_NAME = "Technical-Forum";

    /**
     * 用户注册
     * @param req
     * @param resp
     * @throws Exception
     */
    public void registerUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转为User类
        User user = JSON.parseObject(jsonString, User.class);
        String encryptPassword = user.getPassword();
        System.out.println(encryptPassword);
        //4.解密 密码
        String password = KeyFileReader.readPrivateKeyFromFile(encryptPassword);
        System.out.println(password);
        //4.执行service方法
        userService.insertUser(user);
        //5.响应数据
        resp.getWriter().write("success");
    }


    /**
     * 根据手机号查询用户
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectUserByTele(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String tele = req.getReader().readLine();
        //3.执行service方法
        User user = userService.selectUserByTele(tele);
        if (user == null) {
            //手机号不存在，可以使用改手机号
            resp.getWriter().write("success");
        } else {
            //手机号存在，不可使用该手机号
            resp.getWriter().write("fail");
        }
    }

    /**
     * 用户登录
     * @param req
     * @param resp
     * @throws Exception
     */
    public void loginUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String tele = req.getParameter("tele");
        String encryptedPassword = req.getParameter("password");
        //3.解密 密码
        String password = KeyFileReader.readPrivateKeyFromFile(encryptedPassword);
        String checked = req.getParameter("checked");
        //4.执行service方法
        User user = userService.selectUser(tele, password);
        if (user != null) {


            if ("true".equals(checked)) {
                //用户勾选记住信息
                //创建cookie记住信息
                Cookie c_tele = new Cookie("tele", tele);
                Cookie c_password = new Cookie("password", password);

                //存储一小时，并设置路径
                c_tele.setMaxAge(3600);
                c_tele.setPath("/");
                c_password.setMaxAge(3600);
                c_password.setPath("/");

                resp.addCookie(c_tele);
                resp.addCookie(c_password);
            }
            //5.响应数据
            String jsonString = JSON.toJSONString(user);
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(jsonString);
        } else {
            //5.响应数据
            resp.getWriter().write("fail");
        }
    }

    /**
     * 修改用户昵称
     * @param req
     * @param resp
     * @throws Exception
     */
    public void updateUsername(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _username = req.getParameter("username");
        String _id = req.getParameter("id");
        //3.解决get请求乱码问题
        String username = new String(_username.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        Integer id = JSON.parseObject(_id, Integer.class);
        //4.执行service方法
        userService.updateUsername(username, id);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 处理文件
     * @param req
     * @param resp
     * @throws Exception
     */
    public void uploadAvatar(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");
        //2.获取文件
        Part filePart = req.getPart("file");
        String fileName = null;
        String contentDisposition = filePart.getHeader("content-disposition");
        if (contentDisposition != null) {
            String[] tokens = contentDisposition.split(";");
            for (String token : tokens) {
                if (token.trim().startsWith("filename")) {
                    fileName = token.substring(token.indexOf("=") + 1).trim().replace("\"", "");
                    break;
                }
            }
        }
        String filePath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR + File.separator + fileName;
        //3.保存文件到服务器
        File file = new File(filePath);
        file.getParentFile().mkdirs();
        filePart.write(filePath);
        // 生成相对路径
        String relativePath = UPLOAD_DIR + File.separator + fileName;
        //4.获取用户id
        String _id = req.getParameter("id");
        Integer id = JSON.parseObject(_id, Integer.class);
        //5.执行service方法
        userService.updateUserHeadPortrait(relativePath, id);
        //6.响应数据
        resp.getWriter().write("{\"success\": true, \"data\": {\"headPortraitPath\": \"/"
                + PROJECT_NAME + "/" + UPLOAD_DIR + "/" + fileName + "\"}}");
    }


    /**
     * 修改用户密码
     * @param req
     * @param resp
     * @throws Exception
     */
    public void updateUserPassword(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String encryptedPassword = req.getParameter("password");
        System.out.println(encryptedPassword);
        //3.解密 密码
        String password = KeyFileReader.readPrivateKeyFromFile(encryptedPassword);
        System.out.println(password);
        String _id = req.getParameter("id");
        //3.转换类型
        Integer id = JSON.parseObject(_id, Integer.class);
        //4.执行service方法
        userService.updateUserPassword(password, id);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 通过id查询用户
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectUserById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _id = req.getParameter("id");
        //3.转换类型
        Integer id = JSON.parseObject(_id, Integer.class);
        //4.执行service方法
        User user = userService.selectUserById(id);
        //5.响应数据
        if (user == null) {
            resp.getWriter().write("fail");
        } else {
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(user));
        }
    }

    /**
     * 查询 除了用户 之外的 所有用户
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectUserWithoutId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _id = req.getParameter("id");
        //3.转换类型
        Integer id = JSON.parseObject(_id, Integer.class);
        //4.执行service方法
        List<User> users = userService.selectAllUserWithoutId(id);
        //5.响应数据
        if (users != null && !users.isEmpty()) {
            //不为空
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(users));
        } else {
            //为空
            resp.getWriter().write("fail");
        }
    }

    /**
     * 根据 id 和 用户名 查询用户
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectUserByUsernameAndId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _username = req.getParameter("username");
        String _id = req.getParameter("id");
        //3.转换数据
        String username = new String(_username.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        Integer id = JSON.parseObject(_id, Integer.class);
        //4.执行service方法
        User user = userService.selectUserByUsernameAndId(username, id);
        //5.响应数据
        if (user != null){
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(user));
        } else {
            resp.getWriter().write("fail");
        }
    }

    /**
     * 通过 用户对象 创建 session
     * @param req
     * @param resp
     * @throws Exception
     */
    public void createUserSession(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        User user = JSON.parseObject(jsonString, User.class);
        //4.创建session
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        //5.响应数据
        resp.getWriter().write("success");
    }
}
