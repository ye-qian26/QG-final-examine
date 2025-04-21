package com.yeqian.dao.mapper;

import com.yeqian.pojo.AccountBan;
import com.yeqian.util.mybatis.annotations.Delete;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

import java.util.List;

public interface AccountBanMapper {

    /**
     * 添加账号封禁
     * @param accountBan
     */
    @Insert("insert into account_ban values (null, #{userId}, #{banUserId})")
    void addAccountBan(AccountBan accountBan);

    /**
     * 解除 账号封禁
     * @param banUserId
     */
    @Delete("delete from account_ban where ban_user_id = #{banUserId}")
    void deleteAccountBan(@Param("banUserId") Integer banUserId);

    /**
     * 通过 被封禁的用户id 查询 账号封禁表
     * @param banUserId
     * @return
     */
    @Select("select * from account_ban where ban_user_id = #{banUserId}")
    AccountBan selectAccountBanByBanUserId(@Param("banUserId") Integer banUserId);

    /**
     * 查询 所有封禁账号
     * @return
     */
    @Select("select * from account_ban")
    List<AccountBan> selectAllAccountBan();
}
