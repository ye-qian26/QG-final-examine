package com.yeqian.service;

import com.yeqian.pojo.Post;
import com.yeqian.util.mybatis.annotations.*;

import java.util.List;

public interface PostService {

    /**
     * 通过板块id查询帖子
     * @param plateId
     * @return
     */
    List<Post> selectPostByPlateId(Integer plateId);

    /**
     * 添加帖子
     * @param content
     * @param image
     */
    void addPost(String content, String image, Integer plateId, Integer userId);

    /**
     *
     * @param id
     */
    void deletePostById(Integer id);

    /**
     * 增加帖子点赞量
     * @param id
     */
    void addPostLikesById(Integer id);

    /**
     * 减少帖子点赞量
     * @param id
     */
    void reducePostLikesById(Integer id);

    /**
     * 增加帖子浏览量
     * @param id
     */
    void addPostPageView(Integer id);

    /**
     * 通过id查询帖子
     * @param id
     * @return
     */
    Post selectPostById(Integer id);
}
