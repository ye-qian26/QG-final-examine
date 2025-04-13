package com.yeqian.service;

import com.yeqian.pojo.User;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;
import com.yeqian.util.mybatis.annotations.Update;

public interface UserService {
    /**
     * 添加用户
     * @param user
     */
    void insertUser(User user);

    /**
     * 根据手机号查询用户
     * @param tele
     * @return
     */
    User selectUserByTele(String tele);

    /**
     * 根据手机号和密码查询用户
     * @param tele
     * @param password
     * @return
     */
    User selectUser(String tele, String password);

    /**
     * 修改用户昵称
     * @param username
     * @param id
     */
    void updateUsername(String username, Integer id);

    /**
     * 修改用户头像
     * @param headPortrait
     * @param id
     */
    void updateUserHeadPortrait(String headPortrait, Integer id);

    /**
     * 修改用户密码
     * @param password
     * @param id
     */
    void updateUserPassword(String password, Integer id);

}
