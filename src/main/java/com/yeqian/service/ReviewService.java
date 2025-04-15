package com.yeqian.service;

import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;

public interface ReviewService {

    /**
     * 添加评论
     * @param content
     * @param userId
     * @param postId
     */
    void addReview(String content, Integer userId, Integer postId);
}
