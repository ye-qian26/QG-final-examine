package com.yeqian.service.impl;


import com.yeqian.dao.mapper.ReportedPostMapper;
import com.yeqian.pojo.ReportedPost;
import com.yeqian.service.ReportedPostService;
import com.yeqian.util.mybatis.proxy.MapperProxyFactory;

import java.util.Collections;
import java.util.List;

public class ReportedPostServiceImpl implements ReportedPostService {
    ReportedPostMapper reportedPostMapper = MapperProxyFactory.getProxy(ReportedPostMapper.class);

    @Override
    public void addReportPost(ReportedPost reportedPost) {
        reportedPostMapper.addReportPost(reportedPost);
    }

    @Override
    public List<ReportedPost> selectByUserId(Integer userId) {
        return reportedPostMapper.selectByUserId(userId);
    }

    @Override
    public void deleteById(Integer id) {
        reportedPostMapper.deleteById(id);
    }

    @Override
    public void deleteByPostId(Integer postId) {
        reportedPostMapper.deleteByPostId(postId);
    }
}
