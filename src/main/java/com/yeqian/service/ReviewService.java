package com.yeqian.service;

import com.yeqian.pojo.Review;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;
import com.yeqian.util.mybatis.annotations.Update;

import java.util.List;

public interface ReviewService {

    /**
     * 添加评论
     * @param content
     * @param userId
     * @param postId
     */
    void addReview(String content, Integer userId, Integer postId);

    /**
     * 根据帖子id查询对应评论
     * @param postId
     * @return
     */
    List<Review> selectReviewByPostId(Integer postId);

    /**
     * 增加评论点赞量
     * @param id
     */
    void addReviewLikesById(Integer id);

    /**
     * 减少评论点赞量
     * @param id
     */
    void reduceReviewLikesById(Integer id);
}
