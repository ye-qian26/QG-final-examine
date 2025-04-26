package com.yeqian.service.impl;

import com.yeqian.dao.mapper.PostLikesMapper;
import com.yeqian.dao.mapper.PostMapper;
import com.yeqian.pojo.PostLikes;
import com.yeqian.service.PostLikesService;
import com.yeqian.util.mybatis.proxy.MapperProxyFactory;
import org.glassfish.grizzly.http.server.util.Mapper;

import java.util.Collections;
import java.util.List;

public class PostLikesServiceImpl implements PostLikesService {
    PostLikesMapper postLikesMapper = MapperProxyFactory.getProxy(PostLikesMapper.class);

    @Override
    public void addPostLikes(PostLikes postLikes) {
        postLikesMapper.addPostLikes(postLikes);
    }

    @Override
    public void deletePostLikes(PostLikes postLikes) {
        postLikesMapper.deletePostLikes(postLikes);
    }

    @Override
    public void deletePostLikesById(Integer id) {
        postLikesMapper.deletePostLikesById(id);

    }

    @Override
    public List<PostLikes> selectPostLikesByUserId(Integer likesUserId) {
        return postLikesMapper.selectPostLikesByUserId(likesUserId);
    }

    @Override
    public void deletePostLikesByPostId(Integer postId) {
        postLikesMapper.deletePostLikesByPostId(postId);
    }
}
