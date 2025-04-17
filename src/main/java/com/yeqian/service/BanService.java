package com.yeqian.service;

import com.yeqian.pojo.Ban;
import com.yeqian.util.mybatis.annotations.Delete;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

public interface BanService {

    /**
     * 增加封禁用户
     * @param ban
     */
    void add(Ban ban);

    /**
     * 根据用户id和板块id查询封禁表
     * @param userId
     * @param plateId
     * @return
     */
    Ban selectByUserIdAndPlateId(Integer userId, Integer plateId);

    /**
     * 根据 用户id 和 板块id 删除封禁
     * @param ban
     */
    void deleteBan(Ban ban);
}
