package com.yeqian.controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求路径
        String uri = req.getRequestURI();
        //2.得到路径后面的方法名
        int index = uri.lastIndexOf("/");
        String methodName = uri.substring(index + 1);

        //3.执行method方法
        //3.1得到调用者的字节码文件
        Class<? extends BaseServlet> cls = this.getClass();
        //3.2得到方法
        try {
            Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
