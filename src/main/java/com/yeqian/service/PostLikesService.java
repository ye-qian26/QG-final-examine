package com.yeqian.service;

import com.yeqian.pojo.PostLikes;
import com.yeqian.util.mybatis.annotations.Delete;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

import java.util.List;

public interface PostLikesService {

    /**
     * 添加 帖子 点赞表
     * @param postLikes
     */
    void addPostLikes(PostLikes postLikes);

    /**
     * 删除 帖子 点赞表
     * @param postLikes
     */
    void deletePostLikes(PostLikes postLikes);

    /**
     * 根据 id 删除 点赞表
     * @param id
     */
    void deletePostLikesById(Integer id);


    /**
     * 根据 用户id 查询 点赞表
     * @param likesUserId
     * @return
     */
    List<PostLikes> selectPostLikesByUserId(Integer likesUserId);

    /**
     * 根据 帖子id 删除 帖子点赞表
     * @param postId
     */
    void deletePostLikesByPostId(Integer postId);
}
