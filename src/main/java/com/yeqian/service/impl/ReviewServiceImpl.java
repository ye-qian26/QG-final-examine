package com.yeqian.service.impl;

import com.yeqian.dao.mapper.ReviewMapper;
import com.yeqian.service.ReviewService;
import com.yeqian.util.mybatis.proxy.MapperProxyFactory;

public class ReviewServiceImpl implements ReviewService {
    ReviewMapper reviewMapper = MapperProxyFactory.getProxy(ReviewMapper.class);

    @Override
    public void addReview(String content, Integer userId, Integer postId) {
        reviewMapper.addReview(content, userId, postId);
    }
}
