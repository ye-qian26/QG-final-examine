package com.yeqian.controller.servlet;

import com.yeqian.util.CheckCodeUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/checkCode/*")
public class CheckCodeServlet extends BaseServlet{

    public void generateCheckCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();

        //1.得到随机验证码
        ServletOutputStream os = resp.getOutputStream();
        String trueCheckCode = CheckCodeUtils.getRandomCode(os);

        //2.存入session中
        session.setAttribute("trueCheckCode", trueCheckCode);
    }

    public void verifyCheckCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收用户输入的验证码
        String checkCode = req.getParameter("checkCode");
        //3.从session中获取正确的验证码
        HttpSession session = req.getSession();
        String trueCheckCode = (String) session.getAttribute("trueCheckCode");
        //4.判断验证码是否正确
        if (trueCheckCode.equalsIgnoreCase(checkCode)) {
            resp.getWriter().write("success");
        } else {
            resp.getWriter().write("fail");
        }
    }
}
