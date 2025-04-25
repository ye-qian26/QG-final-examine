package com.yeqian.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

@WebFilter("/user.html")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if (user != null) {
            //用户已登录过
            //放行
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            //用户还未登录
            String loginMsg = "您还未登录!";
            String redirectUrl = "/Technical-Forum/login.html?loginMsg=" + URLEncoder.encode(loginMsg, "UTF-8");
            resp.sendRedirect(redirectUrl);
        }
    }

    @Override
    public void destroy() {

    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
