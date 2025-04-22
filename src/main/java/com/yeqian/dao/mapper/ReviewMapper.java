package com.yeqian.dao.mapper;

import com.yeqian.pojo.Review;
import com.yeqian.util.mybatis.annotations.*;

import java.util.List;

public interface ReviewMapper {

    /**
     * 添加评论
     * @param content
     * @param userId
     * @param postId
     */
    @Insert("insert into review (content, user_id, post_id) values (#{content}, #{userId}, #{postId})")
    void addReview(@Param("content") String content, @Param("userId") Integer userId, @Param("postId") Integer postId);

    /**
     * 根据帖子id查询对应评论
     * @param postId
     * @return
     */
    @Select("select * from review where post_id = #{postId} and review_id is null")
    List<Review> selectReviewByPostId(@Param("postId") Integer postId);

    /**
     * 增加评论点赞量
     * @param id
     */
    @Update("update review set likes = likes + 1 where id = #{id}")
    void addReviewLikesById(@Param("id") Integer id);

    /**
     * 减少评论点赞量
     * @param id
     */
    @Update("update review set likes = likes - 1 where id = #{id}")
    void reduceReviewLikesById(@Param("id") Integer id);

    /**
     * 根据 帖子id 删除 评论
     * @param postId
     */
    @Delete("delete from review where post_id = #{postId}")
    void deleteByPostId(@Param("postId") Integer postId);

    /**
     * 通过 评论id 查询 其所有跟评
     * @param reviewId
     * @return
     */
    @Select("select * from review where review_id =#{reviewId}")
    List<Review> selectByReviewId(@Param("reviewId") Integer reviewId);

    /**
     * 增加 跟评 评论
     * @param content
     * @param userId
     * @param postId
     * @param reviewId
     */
    @Insert("insert into review (content, user_id, post_id, review_id) values (#{content}, #{userId}, #{postId}, #{reviewId})")
    void addFollowReview(@Param("content") String content, @Param("userId") Integer userId,
                         @Param("postId") Integer postId, @Param("reviewId") Integer reviewId);
}
