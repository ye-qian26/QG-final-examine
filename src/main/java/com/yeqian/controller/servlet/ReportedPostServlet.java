package com.yeqian.controller.servlet;

import com.alibaba.fastjson.JSON;
import com.yeqian.pojo.FavoritePost;
import com.yeqian.pojo.ReportedPost;
import com.yeqian.service.FavoritePostService;
import com.yeqian.service.ReportedPostService;
import com.yeqian.service.impl.FavoritePostServiceImpl;
import com.yeqian.service.impl.ReportedPostServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/reportedPostServlet/*")
public class ReportedPostServlet extends BaseServlet {
    ReportedPostService reportedPostService = new ReportedPostServiceImpl();

    /**
     * 增加举报帖子
     * @param req
     * @param resp
     * @throws Exception
     */
    public void addReportedPost(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        ReportedPost reportedPost = JSON.parseObject(jsonString, ReportedPost.class);
        //4.执行service方法
        reportedPostService.addReportPost(reportedPost);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 根据用户id查询帖子举报信息
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectByUserId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _userId = req.getParameter("userId");
        //3.转换数据
        Integer userId = JSON.parseObject(_userId, Integer.class);
        //4.执行service方法
        List<ReportedPost> reportedPosts = reportedPostService.selectByUserId(userId);
        //5.响应数据
        if (reportedPosts != null && !reportedPosts.isEmpty()) {
            //有数据
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(reportedPosts));
        } else {
            //无数据
            resp.getWriter().write("fail");
        }
    }

    /**
     * 根据id删除举报信息
     * @param req
     * @param resp
     * @throws Exception
     */
    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _reportedPostId = req.getParameter("reportedPostId");
        Integer reportedPostId = JSON.parseObject(_reportedPostId, Integer.class);
        //3.执行方法
        reportedPostService.deleteById(reportedPostId);
        //4.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 根据 帖子id 删除 举报信息
     * @param req
     * @param resp
     * @throws Exception
     */
    public void deleteReportedPostByPostId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        Integer postId = JSON.parseObject(jsonString, Integer.class);
        //3.执行方法
        reportedPostService.deleteByPostId(postId);
        //4.响应数据
        resp.getWriter().write("success");
    }


}
