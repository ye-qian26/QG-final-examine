package com.yeqian.service.impl;

import com.yeqian.dao.mapper.PostMapper;
import com.yeqian.pojo.Post;
import com.yeqian.service.PostService;
import com.yeqian.util.mybatis.proxy.MapperProxyFactory;

import java.util.List;

public class PostServiceImpl implements PostService {
    PostMapper postMapper = MapperProxyFactory.getProxy(PostMapper.class);

    @Override
    public List<Post> selectPostByPlateId(Integer plateId) {
        return postMapper.selectPostByPlateId(plateId);
    }
}
