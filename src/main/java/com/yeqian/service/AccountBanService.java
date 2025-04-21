package com.yeqian.service;

import com.yeqian.pojo.AccountBan;
import com.yeqian.util.mybatis.annotations.Delete;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

import java.util.List;

public interface AccountBanService {

    /**
     * 添加账号封禁
     * @param accountBan
     */
    void addAccountBan(AccountBan accountBan);

    /**
     * 解除 账号封禁
     * @param banUserId
     */
    void deleteAccountBan(Integer banUserId);

    /**
     * 通过 被封禁的用户id 查询 账号封禁表
     * @param banUserId
     * @return
     */
    AccountBan selectAccountBanByBanUserId(Integer banUserId);

    /**
     * 查询 所有封禁账号
     * @return
     */
    List<AccountBan> selectAllAccountBan();
}
