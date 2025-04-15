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
        //3.执行service方法
        postService.addPost(content, image, plateId, userId);
        //4.响应数据
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

}
