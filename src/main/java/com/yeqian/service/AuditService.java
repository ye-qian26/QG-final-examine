package com.yeqian.service;

import com.yeqian.pojo.Audit;
import com.yeqian.util.mybatis.annotations.*;

import java.util.List;

public interface AuditService {
    /**
     * 添加申请
     * @param audit
     */
    void addAudit(Audit audit);

    /**
     * 查询所有申请
     * @return
     */
    List<Audit> selectAllAudit();

    /**
     * 根据id删除申请数据
     * @param id
     */
    void deleteAuditById(Integer id);

    /**
     * 修改申请状态
     * @param id
     * @param status
     */
    void updateAuditStatus(Integer id, Integer status);
}
