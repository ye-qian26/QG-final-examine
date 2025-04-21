package com.yeqian.service.impl;

import com.yeqian.dao.mapper.ReportedUserMapper;
import com.yeqian.pojo.ReportedUser;
import com.yeqian.service.ReportedUserService;
import com.yeqian.util.mybatis.proxy.MapperProxyFactory;

import java.util.List;

public class ReportedUserServiceImpl implements ReportedUserService {
    ReportedUserMapper reportedUserMapper = MapperProxyFactory.getProxy(ReportedUserMapper.class);

    @Override
    public void addReportedUser(ReportedUser reportedUser) {
        reportedUserMapper.addReportedUser(reportedUser);
    }

    @Override
    public List<ReportedUser> selectAllReportedUser() {
        return reportedUserMapper.selectAllReportedUser();
    }

    @Override
    public void deleteById(Integer id) {
        reportedUserMapper.deleteById(id);
    }
}
