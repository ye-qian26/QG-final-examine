package com.yeqian.service;

import com.yeqian.pojo.FavoritePost;
import com.yeqian.pojo.Post;
import com.yeqian.util.mybatis.annotations.Delete;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

import java.util.List;

public interface FavoritePostService {

    /**
     * 根据用户id和帖子id查询收藏表
     * @param userId
     * @param postId
     * @return
     */
    FavoritePost selectByUserIdAndPostId(Integer userId, Integer postId);

    /**
     * 根据用户id和帖子id删除对应收藏列表
     * @param userId
     * @param postId
     */
    void deleteByUserIdAndPostId(Integer userId, Integer postId);

    /**
     * 添加收藏
     * @param userId
     * @param postId
     */
    void addFavoritePost(Integer userId, Integer postId);

    /**
     * 根据 帖子id 删除 收藏
     * @param postId
     */
    void deleteByPostId(Integer postId);


    /**
     * 根据 用户id 查询 所收藏的帖子
     * @param userId
     * @return
     */
    List<Post> selectPostsByUserId(Integer userId);
}
