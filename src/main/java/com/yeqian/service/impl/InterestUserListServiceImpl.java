package com.yeqian.service.impl;

import com.yeqian.dao.mapper.InterestUserListMapper;
import com.yeqian.pojo.InterestUserList;
import com.yeqian.service.InterestUserListService;
import com.yeqian.util.mybatis.proxy.MapperProxyFactory;

import java.util.Collections;
import java.util.List;

public class InterestUserListServiceImpl implements InterestUserListService {
    InterestUserListMapper interestUserListMapper = MapperProxyFactory.getProxy(InterestUserListMapper.class);


    @Override
    public InterestUserList selectByUserIdAndInterestedUserId(Integer userId, Integer interestedUserId) {
        return interestUserListMapper.selectByUserIdAndInterestedUserId(userId, interestedUserId);
    }

    @Override
    public void addInterestPlateList(InterestUserList InterestUserList) {
        interestUserListMapper.addInterestPlateList(InterestUserList);
    }

    @Override
    public void deleteInterestPlateList(InterestUserList InterestUserList) {
        interestUserListMapper.deleteInterestPlateList(InterestUserList);
    }

    @Override
    public List<InterestUserList> selectByUserId(Integer userId) {
        return interestUserListMapper.selectByUserId(userId);
    }
}
