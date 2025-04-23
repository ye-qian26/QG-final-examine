package com.yeqian.service.impl;

import com.yeqian.dao.mapper.ReviewUserMapper;
import com.yeqian.pojo.ReviewUser;
import com.yeqian.service.ReviewUserService;
import com.yeqian.util.mybatis.proxy.MapperProxyFactory;

import java.util.Collections;
import java.util.List;

public class ReviewUserServiceImpl implements ReviewUserService {
    ReviewUserMapper reviewUserMapper = MapperProxyFactory.getProxy(ReviewUserMapper.class);

    @Override
    public void addReviewUser(ReviewUser reviewUser) {
        reviewUserMapper.addReviewUser(reviewUser);
    }

    @Override
    public void deleteReviewUser(ReviewUser reviewUser) {
        reviewUserMapper.deleteReviewUser(reviewUser);
    }

    @Override
    public List<ReviewUser> selectReviewUserByUserId(Integer remindUserId) {
        return reviewUserMapper.selectReviewUserByUserId(remindUserId);
    }

    @Override
    public void deleteReviewUserById(Integer id) {
        reviewUserMapper.deleteReviewUserById(id);
    }

    @Override
    public void deleteByPostId(Integer postId) {
        reviewUserMapper.deleteByPostId(postId);
    }
}
