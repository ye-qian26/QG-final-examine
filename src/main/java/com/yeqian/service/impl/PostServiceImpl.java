package com.yeqian.service.impl;

import com.yeqian.dao.mapper.PostMapper;
import com.yeqian.pojo.Post;
import com.yeqian.service.PostService;
import com.yeqian.util.mybatis.proxy.MapperProxyFactory;

import java.util.Collections;
import java.util.List;

public class PostServiceImpl implements PostService {
    PostMapper postMapper = MapperProxyFactory.getProxy(PostMapper.class);

    @Override
    public List<Post> selectPostByPlateId(Integer plateId) {
        return postMapper.selectPostByPlateId(plateId);
    }

    @Override
    public void addPost(String content, String image, Integer plateId, Integer userId, String releaseTime) {
        postMapper.addPost(content, image, plateId, userId, releaseTime);
    }

    @Override
    public void deletePostById(Integer id) {
        postMapper.deletePostById(id);
    }

    @Override
    public void addPostLikesById(Integer id) {
        postMapper.addPostLikesById(id);
    }

    @Override
    public void reducePostLikesById(Integer id) {
        postMapper.reducePostLikesById(id);
    }

    @Override
    public void addPostPageView(Integer id) {
        postMapper.addPostPageView(id);
    }

    @Override
    public Post selectPostById(Integer id) {
        return postMapper.selectPostById(id);
    }

    @Override
    public List<Post> selectPostByContentAndPlateId(String content, Integer plateId) {
        return postMapper.selectPostByContentAndPlateId(content, plateId);
    }

    @Override
    public List<Post> selectPostByContentAndPlateIdWithNew(String content, Integer plateId) {
        return postMapper.selectPostByContentAndPlateIdWithNew(content, plateId);
    }

    @Override
    public List<Post> selectPostByPlateIdWithNew(Integer plateId) {
        return postMapper.selectPostByPlateIdWithNew(plateId);
    }

    @Override
    public List<Post> selectPostByContentAndPlateIdWithPageView(String content, Integer plateId) {
        return postMapper.selectPostByContentAndPlateIdWithPageView(content, plateId);
    }

    @Override
    public List<Post> selectPostByPlateIdWithPageView(Integer plateId) {
        return postMapper.selectPostByPlateIdWithPageView(plateId);
    }

    @Override
    public List<Post> selectPostByContentAndPlateIdWithLikes(String content, Integer plateId) {
        return postMapper.selectPostByContentAndPlateIdWithLikes(content, plateId);
    }

    @Override
    public List<Post> selectPostByPlateIdWithLikes(Integer plateId) {
        return postMapper.selectPostByPlateIdWithLikes(plateId);
    }
}
