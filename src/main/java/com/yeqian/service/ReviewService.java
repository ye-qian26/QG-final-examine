package com.yeqian.service;

import com.yeqian.pojo.Review;
import com.yeqian.util.mybatis.annotations.*;

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

    /**
     * 根据 帖子id 删除 评论
     * @param postId
     */
    void deleteByPostId(Integer postId);

    /**
     * 通过 评论id 查询 其所有跟评
     * @param reviewId
     * @return
     */
    List<Review> selectByReviewId(Integer reviewId);

    /**
     * 增加 跟评 评论
     * @param content
     * @param userId
     * @param postId
     * @param reviewId
     */
    void addFollowReview(String content, Integer userId,
                         Integer postId, Integer reviewId);

    /**
     * 查找评论（@用户功能）
     * @param content
     * @param userId
     * @param postId
     */
    Review selectReview(String content, Integer userId, Integer postId);

    /**
     * 查找跟评（@用户功能）
     * @param content
     * @param userId
     * @param postId
     */
    Review selectFollowReview(String content, Integer userId, Integer postId, Integer reviewId);

    /**
     * 通过 id 查询 评论
     * @param id
     * @return
     */
    Review selectById(Integer id);

    /**
     * 根据 帖子id 删除 跟评
     * @param postId
     */
    void deleteFollowReviewByPostId(Integer postId);
}
