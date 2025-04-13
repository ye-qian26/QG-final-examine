package com.yeqian.service;

import com.yeqian.pojo.Administrator;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;
import com.yeqian.util.mybatis.annotations.Update;

public interface AdministratorService {
    /**
     * 添加管理员
     * @param administrator
     */
    void insertAdministrator(Administrator administrator);

    /**
     * 根据手机号查询管理员
     * @param tele
     * @return
     */
    Administrator selectByTele(String tele);

    /**
     * 根据手机号和密码查询管理员
     * @param tele
     * @param password
     * @return
     */
    Administrator selectAdministrator(String tele, String password);

    /**
     * 修改管理员昵称
     * @param name
     * @param id
     */
    void updateAdministratorName(String name,  Integer id);

    /**
     * 修改管理员头像
     * @param headPortrait
     * @param id
     */
    void updateAdministratorHeadPortrait( String headPortrait,  Integer id);

    /**
     * 修改管理员密码
     * @param password
     * @param id
     */
    void updateAdministratorPassword(String password,  Integer id);
}
