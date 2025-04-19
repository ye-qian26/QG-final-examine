package com.yeqian.controller.servlet;

import com.alibaba.fastjson.JSON;
import com.yeqian.pojo.FavoritePost;
import com.yeqian.pojo.Post;
import com.yeqian.pojo.Review;
import com.yeqian.service.FavoritePostService;
import com.yeqian.service.ReviewService;
import com.yeqian.service.impl.FavoritePostServiceImpl;
import com.yeqian.service.impl.ReviewServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet("/favoritePostServlet/*")
public class FavoritePostServlet extends BaseServlet {
    FavoritePostService favoritePostService = new FavoritePostServiceImpl();

    /**
     * 根据userId和postId查询收藏表
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectFavoritePost(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _userId = req.getParameter("userId");
        String _postId = req.getParameter("postId");
        //3.转换数据
        Integer userId = JSON.parseObject(_userId, Integer.class);
        Integer postId = JSON.parseObject(_postId, Integer.class);
        //4.执行service方法
        FavoritePost favoritePost = favoritePostService.selectByUserIdAndPostId(userId, postId);
        //5.响应数据
        if (favoritePost != null) {
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(favoritePost));
        } else {
            resp.getWriter().write("fail");
        }
    }

    /**
     * 根据userId和postId删除收藏表
     * @param req
     * @param resp
     * @throws Exception
     */
    public void deleteFavoritePost(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _userId = req.getParameter("userId");
        String _postId = req.getParameter("postId");
        //3.转换数据
        Integer userId = JSON.parseObject(_userId, Integer.class);
        Integer postId = JSON.parseObject(_postId, Integer.class);
        //4.执行service方法
        favoritePostService.deleteByUserIdAndPostId(userId, postId);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 添加收藏
     * @param req
     * @param resp
     * @throws Exception
     */
    public void addFavoritePost(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _userId = req.getParameter("userId");
        String _postId = req.getParameter("postId");
        //3.转换数据
        Integer userId = JSON.parseObject(_userId, Integer.class);
        Integer postId = JSON.parseObject(_postId, Integer.class);
        //4.执行service方法
        favoritePostService.addFavoritePost(userId, postId);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 根据 帖子id 删除 收藏信息
     * @param req
     * @param resp
     * @throws Exception
     */
    public void deleteFavoritePostByPostId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        Integer postId = JSON.parseObject(jsonString, Integer.class);
        //4.执行service方法
        favoritePostService.deleteByPostId(postId);
        //5.响应数据
        resp.getWriter().write("success");
    }


    /**
     * 根据 用户id 查询 收藏帖子信息
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectPostsByUserId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        Integer useId = JSON.parseObject(jsonString, Integer.class);
        //4.执行service方法
        List<Post> posts = favoritePostService.selectPostsByUserId(useId);
        //5.响应数据
        if (posts != null && !posts.isEmpty()) {
            //有数据
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(posts));
        } else {
            resp.getWriter().write("fail");
        }
    }

}
