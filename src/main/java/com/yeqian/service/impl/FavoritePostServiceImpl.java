package com.yeqian.service.impl;

import com.yeqian.dao.mapper.FavoritePostMapper;
import com.yeqian.pojo.FavoritePost;
import com.yeqian.pojo.Post;
import com.yeqian.service.FavoritePostService;
import com.yeqian.util.mybatis.proxy.MapperProxyFactory;

import java.util.Collections;
import java.util.List;

public class FavoritePostServiceImpl implements FavoritePostService {
    FavoritePostMapper favoritePostMapper = MapperProxyFactory.getProxy(FavoritePostMapper.class);

    @Override
    public FavoritePost selectByUserIdAndPostId(Integer userId, Integer postId) {
        return favoritePostMapper.selectByUserIdAndPostId(userId, postId);
    }

    @Override
    public void deleteByUserIdAndPostId(Integer userId, Integer postId) {
        favoritePostMapper.deleteByUserIdAndPostId(userId, postId);
    }

    @Override
    public void addFavoritePost(Integer userId, Integer postId) {
        favoritePostMapper.addFavoritePost(userId, postId);
    }

    @Override
    public void deleteByPostId(Integer postId) {
        favoritePostMapper.deleteByPostId(postId);
    }

    @Override
    public List<Post> selectPostsByUserId(Integer userId) {
        return favoritePostMapper.selectPostsByUserId(userId);
    }
}
