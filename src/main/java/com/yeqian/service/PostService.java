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
    void addPost(String content, String image, Integer plateId, Integer userId, String releaseTime);

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

    /**
     * 通过 板块id 和 帖子内容 模糊查询 帖子
     * @param content
     * @param plateId
     * @return
     */
    List<Post> selectPostByContentAndPlateId(String content, Integer plateId);

    /**
     * 通过 板块id 和 帖子内容 模糊查询 帖子
     * @param content
     * @param plateId
     * @return
     */
    List<Post> selectPostByContentAndPlateIdWithNew(String content, Integer plateId);

    /**
     * 通过 板块id 模糊查询 帖子 并按时间降序排序
     * @param plateId
     * @return
     */
    List<Post> selectPostByPlateIdWithNew(Integer plateId);

    /**
     * 通过 板块id 和 帖子内容 模糊查询 帖子 并按 浏览量 降序排序
     * @param content
     * @param plateId
     * @return
     */
    List<Post> selectPostByContentAndPlateIdWithPageView(String content, Integer plateId);

    /**
     * 通过 板块id 模糊查询 帖子 并按 浏览量 降序排序
     * @param plateId
     * @return
     */
    List<Post> selectPostByPlateIdWithPageView(Integer plateId);

    /**
     * 通过 板块id 和 帖子内容 模糊查询 帖子 并按 点赞量 降序排序
     * @param content
     * @param plateId
     * @return
     */
    List<Post> selectPostByContentAndPlateIdWithLikes(String content, Integer plateId);

    /**
     * 通过 板块id 模糊查询 帖子 并按 点赞量 降序排序
     * @param plateId
     * @return
     */
    List<Post> selectPostByPlateIdWithLikes(Integer plateId);
}
