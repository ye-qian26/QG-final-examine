package com.yeqian.controller.servlet;

import com.alibaba.fastjson.JSON;
import com.yeqian.pojo.AccountBan;
import com.yeqian.pojo.ReviewUser;
import com.yeqian.service.AccountBanService;
import com.yeqian.service.ReviewUserService;
import com.yeqian.service.impl.AccountBanServiceImpl;
import com.yeqian.service.impl.ReviewUserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/reviewUserServlet/*")
public class ReviewUserServlet extends BaseServlet {
    ReviewUserService reviewUserService = new ReviewUserServiceImpl();

    /**
     * 增加 @用户 表
     * @param req
     * @param resp
     * @throws Exception
     */
    public void addReviewUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        ReviewUser reviewUser = JSON.parseObject(jsonString, ReviewUser.class);
        //4.执行service方法
        reviewUserService.addReviewUser(reviewUser);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 删除 @用户 表
     * @param req
     * @param resp
     * @throws Exception
     */
    public void deleteReviewUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        ReviewUser reviewUser = JSON.parseObject(jsonString, ReviewUser.class);
        //4.执行service方法
        reviewUserService.deleteReviewUser(reviewUser);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 根据 用户id 查询 @用户表
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectReviewUserByUserId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _remindUserId = req.getParameter("remindUserId");
        //3.转换数据
        Integer remindUserId = JSON.parseObject(_remindUserId, Integer.class);
        //4.执行service方法
        List<ReviewUser> reviewUsers = reviewUserService.selectReviewUserByUserId(remindUserId);
        //5.响应数据
        if (reviewUsers != null && !reviewUsers.isEmpty()) {
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(reviewUsers));
        } else {
            resp.getWriter().write("fail");
        }
    }

    /**
     * 根据 id 删除 @用户表
     * @param req
     * @param resp
     * @throws Exception
     */
    public void deleteReviewUserById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _id = req.getReader().readLine();
        //3.转换数据
        Integer id = JSON.parseObject(_id, Integer.class);
        //4.执行service方法
        reviewUserService.deleteReviewUserById(id);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 根据 评论id 删除 @用户表
     * @param req
     * @param resp
     * @throws Exception
     */
    public void deleteReviewUserByPostId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        Integer postId = JSON.parseObject(jsonString, Integer.class);
        //4.执行service方法
        reviewUserService.deleteByPostId(postId);
        //5.响应数据
        resp.getWriter().write("success");
    }

}
