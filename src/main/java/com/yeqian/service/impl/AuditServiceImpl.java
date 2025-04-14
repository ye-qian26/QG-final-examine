package com.yeqian.service.impl;

import com.yeqian.dao.mapper.AuditMapper;
import com.yeqian.pojo.Audit;
import com.yeqian.service.AuditService;
import com.yeqian.util.mybatis.proxy.MapperProxyFactory;

import java.util.List;

public class AuditServiceImpl implements AuditService {
    AuditMapper auditMapper = MapperProxyFactory.getProxy(AuditMapper.class);

    @Override
    public void addAudit(Audit audit) {
        auditMapper.addAudit(audit);
    }

    @Override
    public List<Audit> selectAllAudit() {
        return auditMapper.selectAllAudit();
    }

    @Override
    public void deleteAuditById(Integer id) {
        auditMapper.deleteAuditById(id);
    }

    @Override
    public void updateAuditStatus(Integer id, Integer status) {
        auditMapper.updateAuditStatus(id, status);
    }
}
