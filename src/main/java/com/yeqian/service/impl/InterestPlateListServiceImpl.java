package com.yeqian.service.impl;

import com.yeqian.dao.mapper.InterestPlateListMapper;
import com.yeqian.pojo.InterestPlateList;
import com.yeqian.service.InterestPlateListService;
import com.yeqian.util.mybatis.proxy.MapperProxyFactory;

import java.util.Collections;
import java.util.List;

public class InterestPlateListServiceImpl implements InterestPlateListService {
    InterestPlateListMapper interestPlateListMapper = MapperProxyFactory.getProxy(InterestPlateListMapper.class);

    @Override
    public InterestPlateList selectByUserIdAndPlateId(Integer userId, Integer plateId) {
        return interestPlateListMapper.selectByUserIdAndPlateId(userId, plateId);
    }

    @Override
    public void addInterestPlateList(InterestPlateList interestPlateList) {
        interestPlateListMapper.addInterestPlateList(interestPlateList);
    }

    @Override
    public void deleteInterestPlateList(InterestPlateList interestPlateList) {
        interestPlateListMapper.deleteInterestPlateList(interestPlateList);
    }

    @Override
    public List<InterestPlateList> selectByUserId(Integer userId) {
        return interestPlateListMapper.selectByUserId(userId);
    }
}
