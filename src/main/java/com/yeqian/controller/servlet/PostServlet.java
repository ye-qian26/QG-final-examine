package com.yeqian.controller.servlet;

import com.alibaba.fastjson.JSON;
import com.yeqian.pojo.Plate;
import com.yeqian.pojo.Post;
import com.yeqian.service.PlateService;
import com.yeqian.service.PostService;
import com.yeqian.service.impl.PlateServiceImpl;
import com.yeqian.service.impl.PostServiceImpl;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/postServlet/*")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class PostServlet extends BaseServlet {
    PostService postService = new PostServiceImpl();
    private static final String UPLOAD_DIR = "uploads";
    private static final String PROJECT_NAME = "Technical-Forum";

    /**
     * 通过plateId查询post
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectPostByPlateId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.接收数据
        String _plateId = req.getParameter("plateId");
        //2.转换数据
        Integer plateId = JSON.parseObject(_plateId, Integer.class);
        //3.执行service方法
        List<Post> posts = postService.selectPostByPlateId(plateId);
        //4.响应数据
        if (posts != null && !posts.isEmpty()) {
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(posts));
        } else {
            resp.getWriter().write("fail");
        }
    }

    /**
     * 处理文件
     * @param req
     * @param resp
     * @throws Exception
     */
    public void uploadAvatar(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");
        //2.获取文件
        Part filePart = req.getPart("file");
        String fileName = null;
        String contentDisposition = filePart.getHeader("content-disposition");
        if (contentDisposition != null) {
            String[] tokens = contentDisposition.split(";");
            for (String token : tokens) {
                if (token.trim().startsWith("filename")) {
                    fileName = token.substring(token.indexOf("=") + 1).trim().replace("\"", "");
                    break;
                }
            }
        }
        String filePath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR + File.separator + fileName;
        //3.保存文件到服务器
        File file = new File(filePath);
        file.getParentFile().mkdirs();
        filePart.write(filePath);
        //6.响应数据
//        resp.getWriter().write("{\"success\": true, \"data\": {\"imagePath\": \"/"
//                + PROJECT_NAME + "/" + UPLOAD_DIR + "/" + fileName + "\"," + "\"relativePath\": \"" + relativePath + "\"" + "}}");
        resp.getWriter().write("{\"success\": true, \"data\": {\"imagePath\": \"/"
                + PROJECT_NAME + "/" + UPLOAD_DIR + "/" + fileName + "\"}}");
    }

    /**
     * 添加帖子
     * @param req
     * @param resp
     * @throws Exception
     */
    public void addPost(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setCharacterEncoding("UTF-8");
        //1.接收数据
        String _content = req.getParameter("content");
        String image = req.getParameter("image");
        String _userId = req.getParameter("userId");
        String _plateId = req.getParameter("plateId");
        //2.解决get乱码问题以及转换数据
        String content = new String(_content.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        Integer userId = JSON.parseObject(_userId, Integer.class);
        Integer plateId = JSON.parseObject(_plateId, Integer.class);
        //3.获取当前时间
        LocalDateTime now = LocalDateTime.now();
        //定义时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //格式化时间
        String formattedDateTime = now.format(formatter);
        //4.执行service方法
        postService.addPost(content, image, plateId, userId, formattedDateTime);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 删除帖子
     * @param req
     * @param resp
     * @throws Exception
     */
    public void deletePostById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("UTF-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        Integer postId = JSON.parseObject(jsonString, Integer.class);
        //3.执行service方法
        postService.deletePostById(postId);
        //4.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 增加帖子点赞量
     * @param req
     * @param resp
     * @throws Exception
     */
    public void addPostLikesById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("UTF-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        Integer postId = JSON.parseObject(jsonString, Integer.class);
        //3.执行service方法
        postService.addPostLikesById(postId);
        //4.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 减少帖子点赞量
     * @param req
     * @param resp
     * @throws Exception
     */
    public void reducePostLikesById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("UTF-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        Integer postId = JSON.parseObject(jsonString, Integer.class);
        //3.执行service方法
        postService.reducePostLikesById(postId);
        //4.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 增加帖子浏览量
     * @param req
     * @param resp
     * @throws Exception
     */
    public void addPostPageView(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("UTF-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        Integer postId = JSON.parseObject(jsonString, Integer.class);
        //3.执行service方法
        postService.addPostPageView(postId);
        //4.响应数据
        resp.getWriter().write("success");
    }


    /**
     * 通过id查询帖子
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectPostById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("UTF-8");
        //2.接收数据
        String _postId = req.getParameter("postId");
        //3.转换数据
        Integer postId = JSON.parseObject(_postId, Integer.class);
        //4.执行service方法
        Post post = postService.selectPostById(postId);
        //5.响应数据
        if (post != null) {
            //有数据
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(post));
        } else {
            //无数据
            resp.getWriter().write("fail");
        }
    }

    /**
     * 通过 板块id 和 帖子内容 模糊查询 帖子
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectPostByContentAndPlateId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json;charset=utf-8");
        //2.接收数据
        String _content = req.getParameter("content");
        String _plateId = req.getParameter("plateId");
        String _select = req.getParameter("select");
        String select = new String(_select.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        //3.转换数据
        List<Post> posts = null;

        Integer plateId = JSON.parseObject(_plateId, Integer.class);
        if (_content != null && !_content.isEmpty()) {
            // content 不为空
            String content = new String(_content.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            content = "%" + content.trim() + "%";
            //判断用户是否有选择条件
            //4.执行service方法
            if (select.isEmpty()) {
                //用户未选择条件
                posts = postService.selectPostByContentAndPlateId(content, plateId);
            } else if ("最新发布".equals(select)) {
                //用户选择查询最新发布的帖子
                posts = postService.selectPostByContentAndPlateIdWithNew(content, plateId);
            } else if ("最多浏览".equals(select)) {
                //用户选择查询最多浏览的帖子
                posts = postService.selectPostByContentAndPlateIdWithPageView(content, plateId);
            } else if ("最多点赞".equals(select)) {
                //用户选择查询最多点赞的帖子
                posts = postService.selectPostByContentAndPlateIdWithLikes(content, plateId);
            }
            if (posts != null && !posts.isEmpty()) {
                resp.getWriter().write(JSON.toJSONString(posts));
            } else {
                resp.getWriter().write("fail");
            }
        } else {
            // content 为空
            //判断用户是否有选择条件
            //4.执行service方法
            if (select.isEmpty()) {
                //用户未选择条件
                posts = postService.selectPostByPlateId(plateId);
            } else if ("最新发布".equals(select)) {
                //用户选择查询最新发布的帖子
                posts = postService.selectPostByPlateIdWithNew(plateId);
            } else if ("最多浏览".equals(select)) {
                //用户选择查询最多浏览的帖子
                posts = postService.selectPostByPlateIdWithPageView(plateId);
            } else if ("最多点赞".equals(select)) {
                //用户选择查询最多点赞的帖子
                posts = postService.selectPostByPlateIdWithLikes(plateId);
            }
            if (posts != null && !posts.isEmpty()) {
                resp.getWriter().write(JSON.toJSONString(posts));
            } else {
                resp.getWriter().write("fail");
            }
        }
    }

    /**
     * 根据 用户id 查询 帖子
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectPostByUserId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("UTF-8");
        //2.接收数据
        String _userId = req.getReader().readLine();
        //3.转换数据
        Integer userId = JSON.parseObject(_userId, Integer.class);
        //4.执行service方法
        List<Post> posts = postService.selectPostByUserId(userId);
        //5.响应数据
        if (posts != null && !posts.isEmpty()) {
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(posts));
        } else {
            resp.getWriter().write("fail");
        }
    }
}
