package com.yeqian.dao.mapper;

import com.yeqian.pojo.Review;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;
import com.yeqian.util.mybatis.annotations.Update;

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
    @Select("select * from review where post_id = #{postId}")
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
}
