package com.yeqian.util.mybatis.proxy;

import java.lang.reflect.Proxy;

public class MapperProxyFactory {
    /**
     * 拿到代理类
     */
    public static <T> T  getProxy(Class<T> mapperClass) {

        return (T) Proxy.newProxyInstance(mapperClass.getClassLoader(), new Class[]{mapperClass}, new MapperProxy());

    }
}
