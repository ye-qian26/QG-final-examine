package com.yeqian.service.impl;

import com.yeqian.dao.mapper.PlateMapper;
import com.yeqian.pojo.Plate;
import com.yeqian.service.PlateService;
import com.yeqian.util.mybatis.proxy.MapperProxy;
import com.yeqian.util.mybatis.proxy.MapperProxyFactory;

import java.util.Collections;
import java.util.List;

public class PlateServiceImpl implements PlateService {
    PlateMapper plateMapper = MapperProxyFactory.getProxy(PlateMapper.class);

    @Override
    public void addPlate(Integer userId, String name) {
        plateMapper.addPlate(userId, name);
    }

    @Override
    public List<Plate> selectByUserId(Integer userId) {
        return plateMapper.selectByUserId(userId);
    }

    @Override
    public void updatePlateNotice(Integer plateId, String notice) {
        plateMapper.updatePlateNotice(plateId, notice);
    }

    @Override
    public Plate selectById(Integer id) {
        return plateMapper.selectById(id);
    }

    @Override
    public List<Plate> selectAllPlate() {
        return plateMapper.selectAllPlate();
    }
}
