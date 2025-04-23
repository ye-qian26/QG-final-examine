package com.yeqian.dao.mapper;

import com.yeqian.pojo.ReviewUser;
import com.yeqian.util.mybatis.annotations.Delete;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

import java.util.List;

public interface ReviewUserMapper {

    /**
     * 增加 @用户 表
     * @param reviewUser
     */
    @Insert("insert into review_user values (null, #{userId}, #{remindUserId}, #{postId}, #{reviewId})")
    void addReviewUser(ReviewUser reviewUser);

    /**
     * 删除 @用户 表
     * @param reviewUser
     */
    @Delete("delete from review_user where user_id = #{userId} and remind_user_id = #{remindUserId} and post_id = #{postId} and review_id = #{reviewId}")
    void deleteReviewUser(ReviewUser reviewUser);

    /**
     * 根据 用户id 查询 @用户表
     * @param remindUserId
     * @return
     */
    @Select("select * from review_user where remind_user_id = #{remindUserId} order by id desc")
    List<ReviewUser> selectReviewUserByUserId(@Param("remindUserId") Integer remindUserId);

    /**
     * 根据 id 删除 @用户表
     * @param id
     */
    @Delete("delete from review_user where id = #{id}")
    void deleteReviewUserById(@Param("id") Integer id);

    /**
     * 根据 帖子id 删除 @用户表
     * @param postId
     */
    @Delete("delete from review_user where post_id = #{postId}")
    void deleteByPostId(@Param("postId") Integer postId);
}
