package com.yeqian.service.impl;

import com.yeqian.dao.mapper.BanMapper;
import com.yeqian.pojo.Ban;
import com.yeqian.service.BanService;
import com.yeqian.util.mybatis.proxy.MapperProxyFactory;

import java.util.Collections;
import java.util.List;

public class BanServiceImpl implements BanService {
    BanMapper banMapper = MapperProxyFactory.getProxy(BanMapper.class);

    @Override
    public void add(Ban ban) {
        banMapper.add(ban);
    }

    @Override
    public Ban selectByUserIdAndPlateId(Integer banUserId, Integer plateId) {
        return banMapper.selectByUserIdAndPlateId(banUserId, plateId);
    }

    @Override
    public void deleteBan(Ban ban) {
        banMapper.deleteBan(ban);
    }

    @Override
    public List<Ban> selectByUserId(Integer userId) {
        return banMapper.selectByUserId(userId);
    }
}
