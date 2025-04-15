package com.yeqian.dao.mapper;

import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;

public interface ReviewMapper {

    /**
     * 添加评论
     * @param content
     * @param userId
     * @param postId
     */
    @Insert("insert into review (content, user_id, post_id) values (#{content}, #{userId}, #{postId})")
    void addReview(@Param("content") String content, @Param("userId") Integer userId, @Param("postId") Integer postId);
}
