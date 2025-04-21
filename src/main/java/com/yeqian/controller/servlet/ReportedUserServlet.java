package com.yeqian.controller.servlet;

import com.alibaba.fastjson.JSON;
import com.yeqian.pojo.ReportedPost;
import com.yeqian.pojo.ReportedUser;
import com.yeqian.service.ReportedPostService;
import com.yeqian.service.ReportedUserService;
import com.yeqian.service.impl.ReportedPostServiceImpl;
import com.yeqian.service.impl.ReportedUserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/reportedUserServlet/*")
public class ReportedUserServlet extends BaseServlet {
    ReportedUserService reportedUserService = new ReportedUserServiceImpl();

    /**
     * 增加举报用户
     * @param req
     * @param resp
     * @throws Exception
     */
    public void addReportedUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        ReportedUser reportedUser = JSON.parseObject(jsonString, ReportedUser.class);
        //4.执行service方法
        reportedUserService.addReportedUser(reportedUser);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 查询 所有举报用户
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectAllReportedUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.执行service方法
        List<ReportedUser> reportedUsers = reportedUserService.selectAllReportedUser();
        //2.响应数据
        if (reportedUsers != null && !reportedUsers.isEmpty()) {
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(reportedUsers));
        } else {
            resp.getWriter().write("fail");
        }
    }

    /**
     * 删除举报用户
     * @param req
     * @param resp
     * @throws Exception
     */
    public void deleteReportedUserById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _id = req.getReader().readLine();
        //3.转换数据
        Integer id = JSON.parseObject(_id, Integer.class);
        //4.执行service方法
        reportedUserService.deleteById(id);
        //5.响应数据
        resp.getWriter().write("success");
    }
}
