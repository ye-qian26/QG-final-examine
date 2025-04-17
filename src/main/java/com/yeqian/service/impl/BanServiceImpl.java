package com.yeqian.service.impl;

import com.yeqian.dao.mapper.BanMapper;
import com.yeqian.pojo.Ban;
import com.yeqian.service.BanService;
import com.yeqian.util.mybatis.proxy.MapperProxyFactory;

public class BanServiceImpl implements BanService {
    BanMapper banMapper = MapperProxyFactory.getProxy(BanMapper.class);

    @Override
    public void add(Ban ban) {
        banMapper.add(ban);
    }

    @Override
    public Ban selectByUserIdAndPlateId(Integer userId, Integer plateId) {
        return banMapper.selectByUserIdAndPlateId(userId, plateId);
    }

    @Override
    public void deleteBan(Ban ban) {
        banMapper.deleteBan(ban);
    }
}
