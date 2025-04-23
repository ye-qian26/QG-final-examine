package com.yeqian.service.impl;

import com.yeqian.dao.mapper.HistoricalRecordMapper;
import com.yeqian.pojo.HistoricalRecord;
import com.yeqian.pojo.Post;
import com.yeqian.service.HistoricalRecordService;
import com.yeqian.util.mybatis.proxy.MapperProxyFactory;

import java.util.Collections;
import java.util.List;

public class HistoricalRecordServiceImpl implements HistoricalRecordService {
    HistoricalRecordMapper historicalRecordMapper = MapperProxyFactory.getProxy(HistoricalRecordMapper.class);

    @Override
    public void addHistoricalRecord(HistoricalRecord hr) {
        historicalRecordMapper.addHistoricalRecord(hr);
    }

    @Override
    public void deleteHistoricalRecord(HistoricalRecord hr) {
        historicalRecordMapper.deleteHistoricalRecord(hr);
    }

    @Override
    public List<Post> selectHistoricalRecordsByUserId(Integer userId) {
        return historicalRecordMapper.selectHistoricalRecordsByUserId(userId);
    }

    @Override
    public void deleteByPostId(Integer postId) {
        historicalRecordMapper.deleteByPostId(postId);
    }
}
