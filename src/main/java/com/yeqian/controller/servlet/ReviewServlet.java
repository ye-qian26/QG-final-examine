package com.yeqian.controller.servlet;

import com.alibaba.fastjson.JSON;
import com.yeqian.pojo.Audit;
import com.yeqian.pojo.Review;
import com.yeqian.service.AuditService;
import com.yeqian.service.ReviewService;
import com.yeqian.service.impl.AuditServiceImpl;
import com.yeqian.service.impl.ReviewServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet("/reviewServlet/*")
public class ReviewServlet extends BaseServlet {
    ReviewService reviewService = new ReviewServiceImpl();
    /**
     * 添加评论
     * @param req
     * @param resp
     * @throws Exception
     */
    public void addReview(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _content = req.getParameter("content");
        if (_content == null || _content.isEmpty()) {
            //评论内容为空
            resp.getWriter().write("fail");
            return;
        }
        String _userId = req.getParameter("userId");
        String _postId = req.getParameter("postId");
        //3.转换数据
        String content = new String(_content.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        Integer userId = JSON.parseObject(_userId, Integer.class);
        Integer postId = JSON.parseObject(_postId, Integer.class);
        //4.执行service方法
        reviewService.addReview(content, userId, postId);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 查询评论
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectReviewByPostId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        Integer postId = JSON.parseObject(jsonString, Integer.class);
        //4.执行service方法
        List<Review> reviews = reviewService.selectReviewByPostId(postId);
        //5.响应数据
        if (reviews != null && !reviews.isEmpty()) {
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(reviews));
        } else {
            resp.getWriter().write("fail");
        }
    }

    /**
     * 增加评论点赞量
     * @param req
     * @param resp
     * @throws Exception
     */
    public void addReviewLikesById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        Integer id = JSON.parseObject(jsonString, Integer.class);
        //4.执行service方法
        reviewService.addReviewLikesById(id);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 减少评论点赞量
     * @param req
     * @param resp
     * @throws Exception
     */
    public void reduceReviewLikesById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        Integer id = JSON.parseObject(jsonString, Integer.class);
        //4.执行service方法
        reviewService.reduceReviewLikesById(id);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 根据 帖子id 删除 评论
     * @param req
     * @param resp
     * @throws Exception
     */
    public void deleteReviewByPostId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        Integer postId = JSON.parseObject(jsonString, Integer.class);
        //4.执行service方法
        reviewService.deleteByPostId(postId);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 查询 评论 跟评
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectReviewByReviewId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        Integer reviewId = JSON.parseObject(jsonString, Integer.class);
        //4.执行service方法
        List<Review> reviews = reviewService.selectByReviewId(reviewId);
        //5.响应数据
        if (reviews != null && !reviews.isEmpty()) {
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(reviews));
        } else {
            resp.getWriter().write("fail");
        }
    }

    /**
     * 添加 评论 跟评
     * @param req
     * @param resp
     * @throws Exception
     */
    public void addFollowReview(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _content = req.getParameter("content");
        if (_content == null || _content.isEmpty()) {
            //评论内容为空
            resp.getWriter().write("fail");
            return;
        }
        String _userId = req.getParameter("userId");
        String _postId = req.getParameter("postId");
        String _reviewId = req.getParameter("reviewId");
        //3.转换数据
        String content = new String(_content.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        Integer userId = JSON.parseObject(_userId, Integer.class);
        Integer postId = JSON.parseObject(_postId, Integer.class);
        Integer reviewId = JSON.parseObject(_reviewId, Integer.class);
        //4.执行service方法
        reviewService.addFollowReview(content, userId, postId, reviewId);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 查询 符合条件 的 最新一条评论
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectNewReview(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _content = req.getParameter("content");
        String _userId = req.getParameter("userId");
        String _postId = req.getParameter("postId");
        //3.转换数据
        String content = new String(_content.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        Integer userId = JSON.parseObject(_userId, Integer.class);
        Integer postId = JSON.parseObject(_postId, Integer.class);
        //4.执行service方法
        Review review = reviewService.selectReview(content, userId, postId);
        //5.响应数据
        if (review != null) {
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(review));
        } else {
            resp.getWriter().write("fail");
        }
    }

    /**
     * 查询 符合条件 的 最新一条 跟评
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectNewFollowReview(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _content = req.getParameter("content");
        String _userId = req.getParameter("userId");
        String _postId = req.getParameter("postId");
        String _reviewId = req.getParameter("reviewId");
        //3.转换数据
        String content = new String(_content.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        Integer userId = JSON.parseObject(_userId, Integer.class);
        Integer postId = JSON.parseObject(_postId, Integer.class);
        Integer reviewId = JSON.parseObject(_reviewId, Integer.class);
        //4.执行service方法
        Review review = reviewService.selectFollowReview(content, userId, postId, reviewId);
        //5.响应数据
        if (review != null) {
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(review));
        } else {
            resp.getWriter().write("fail");
        }
    }

    /**
     * 根据 id 查询 评论
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectReviewById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        Integer id = JSON.parseObject(jsonString, Integer.class);
        //4.执行service方法
        Review review = reviewService.selectById(id);
        //5.响应数据
        if (review != null) {
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(review));
        } else {
            resp.getWriter().write("fail");
        }
    }

    /**
     * 根据 帖子id 删除 跟评
     * @param req
     * @param resp
     * @throws Exception
     */
    public void deleteFollowReviewByPostId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        Integer postId = JSON.parseObject(jsonString, Integer.class);
        //4.执行service方法
        reviewService.deleteFollowReviewByPostId(postId);
        //5.响应数据
        resp.getWriter().write("success");
    }

}
