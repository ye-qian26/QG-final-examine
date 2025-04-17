package com.yeqian.service.impl;

import com.yeqian.dao.mapper.ReviewMapper;
import com.yeqian.pojo.Review;
import com.yeqian.service.ReviewService;
import com.yeqian.util.mybatis.proxy.MapperProxyFactory;

import java.util.Collections;
import java.util.List;

public class ReviewServiceImpl implements ReviewService {
    ReviewMapper reviewMapper = MapperProxyFactory.getProxy(ReviewMapper.class);

    @Override
    public void addReview(String content, Integer userId, Integer postId) {
        reviewMapper.addReview(content, userId, postId);
    }

    @Override
    public List<Review> selectReviewByPostId(Integer postId) {
        return reviewMapper.selectReviewByPostId(postId);
    }

    @Override
    public void addReviewLikesById(Integer id) {
        reviewMapper.addReviewLikesById(id);
    }

    @Override
    public void reduceReviewLikesById(Integer id) {
        reviewMapper.reduceReviewLikesById(id);
    }

    @Override
    public void deleteByPostId(Integer postId) {
        reviewMapper.deleteByPostId(postId);
    }
}
