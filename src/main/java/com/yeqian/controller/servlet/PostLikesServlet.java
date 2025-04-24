package com.yeqian.controller.servlet;

import com.alibaba.fastjson.JSON;
import com.yeqian.pojo.PostLikes;
import com.yeqian.pojo.ReviewUser;
import com.yeqian.service.PostLikesService;
import com.yeqian.service.ReviewUserService;
import com.yeqian.service.impl.PostLikesServiceImpl;
import com.yeqian.service.impl.ReviewUserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/postLikesServlet/*")
public class PostLikesServlet extends BaseServlet {
    PostLikesService postLikesService = new PostLikesServiceImpl();

    /**
     * 增加 点赞表
     * @param req
     * @param resp
     * @throws Exception
     */
    public void addPostLikes(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        PostLikes postLikes = JSON.parseObject(jsonString, PostLikes.class);
        //4.执行service方法
        postLikesService.addPostLikes(postLikes);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 删除 点赞表
     * @param req
     * @param resp
     * @throws Exception
     */
    public void deletePostLikes(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        PostLikes postLikes = JSON.parseObject(jsonString, PostLikes.class);
        //4.执行service方法
        postLikesService.deletePostLikes(postLikes);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 根据 id 珊瑚 点赞表
     * @param req
     * @param resp
     * @throws Exception
     */
    public void deletePostLikesById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        Integer id = JSON.parseObject(jsonString, Integer.class);
        //4.执行service方法
        postLikesService.deletePostLikesById(id);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 根据 用户id 查询 点赞表
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectPostLikesByUserId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _likesUserId = req.getParameter("likesUserId");
        //3.转换数据
        Integer likesUserId = JSON.parseObject(_likesUserId, Integer.class);
        //4.执行service方法
        List<PostLikes> postLikes = postLikesService.selectPostLikesByUserId(likesUserId);
        //5.响应数据
        if (postLikes != null && !postLikes.isEmpty()) {
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(postLikes));
        } else {
            resp.getWriter().write("fail");
        }
    }
}
