package com.yeqian.dao.mapper;

import com.yeqian.pojo.PostLikes;
import com.yeqian.util.mybatis.annotations.*;

import java.util.List;

public interface PostLikesMapper {

    /**
     * 添加 帖子 点赞表
     * @param postLikes
     */
    @Insert("insert into post_likes values (null, #{userId}, #{likesUserId}, #{postId})")
    void addPostLikes(PostLikes postLikes);

    /**
     * 删除 帖子 点赞表
     * @param postLikes
     */
    @Delete("delete from post_likes where user_id = #{userId} and " +
            "likes_user_id = #{likesUserId} and post_id = #{postId} order by id desc limit 1")
    void deletePostLikes(PostLikes postLikes);

    /**
     * 根据 id 删除 点赞表
     * @param id
     */
    @Delete("delete from post_likes where id = #{id}")
    void deletePostLikesById(@Param("id") Integer id);


    /**
     * 根据 被点赞用户id 查询 点赞表
     * @param likesUserId
     * @return
     */
    @Select("select * from post_likes where likes_user_id = #{likesUserId} order by id desc")
    List<PostLikes> selectPostLikesByUserId(@Param("likesUserId") Integer likesUserId);

    /**
     * 根据 帖子id 删除 帖子点赞表
     * @param postId
     */
    @Delete("delete from post_likes where post_id = #{postId}")
    void deletePostLikesByPostId(@Param("postId") Integer postId);

}
