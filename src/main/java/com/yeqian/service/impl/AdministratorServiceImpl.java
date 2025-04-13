package com.yeqian.service.impl;

import com.yeqian.dao.mapper.AdministratorMapper;
import com.yeqian.pojo.Administrator;
import com.yeqian.service.AdministratorService;
import com.yeqian.util.mybatis.proxy.MapperProxyFactory;

public class AdministratorServiceImpl implements AdministratorService {
    AdministratorMapper administratorMapper = MapperProxyFactory.getProxy(AdministratorMapper.class);

    @Override
    public void insertAdministrator(Administrator administrator) {
        administratorMapper.insertAdministrator(administrator);
    }

    @Override
    public Administrator selectByTele(String tele) {
        return administratorMapper.selectByTele(tele);
    }

    @Override
    public Administrator selectAdministrator(String tele, String password) {
        return administratorMapper.selectAdministrator(tele, password);
    }

    @Override
    public void updateAdministratorName(String name, Integer id) {
        administratorMapper.updateAdministratorName(name, id);
    }

    @Override
    public void updateAdministratorHeadPortrait(String headPortrait, Integer id) {
        administratorMapper.updateAdministratorHeadPortrait(headPortrait, id);
    }

    @Override
    public void updateAdministratorPassword(String password, Integer id) {
        administratorMapper.updateAdministratorPassword(password, id);
    }
}
