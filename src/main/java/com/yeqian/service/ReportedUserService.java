package com.yeqian.service;

import com.yeqian.pojo.ReportedUser;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Select;
import com.yeqian.util.mybatis.annotations.Update;

import java.util.List;

public interface ReportedUserService {

    /**
     * 添加 举报用户 信息
     * @param reportedUser
     */
    void addReportedUser(ReportedUser reportedUser);

    /**
     * 查询所有 举报用户 信息（逻辑查询）
     * @return
     */
    List<ReportedUser> selectAllReportedUser();


    /**
     * 根据 id 删除 举报用户信息（逻辑删除）
     * @param id
     */
    void deleteById(Integer id);
}
