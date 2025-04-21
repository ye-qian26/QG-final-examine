package com.yeqian.service.impl;

import com.yeqian.dao.mapper.AccountBanMapper;
import com.yeqian.pojo.AccountBan;
import com.yeqian.service.AccountBanService;
import com.yeqian.util.mybatis.proxy.MapperProxyFactory;

import java.util.Collections;
import java.util.List;

public class AccountBanServiceImpl implements AccountBanService {
    AccountBanMapper accountBanMapper = MapperProxyFactory.getProxy(AccountBanMapper.class);

    @Override
    public void addAccountBan(AccountBan accountBan) {
        accountBanMapper.addAccountBan(accountBan);
    }

    @Override
    public void deleteAccountBan(Integer banUserId) {
        accountBanMapper.deleteAccountBan(banUserId);
    }

    @Override
    public AccountBan selectAccountBanByBanUserId(Integer banUserId) {
        return accountBanMapper.selectAccountBanByBanUserId(banUserId);
    }

    @Override
    public List<AccountBan> selectAllAccountBan() {
        return accountBanMapper.selectAllAccountBan();
    }
}
