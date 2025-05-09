package com.yeqian.service;

import com.yeqian.pojo.User;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;
import com.yeqian.util.mybatis.annotations.Update;

import java.util.List;

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

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    User selectUserById(Integer id);

    /**
     * 查询 用户 之外的 所有用户
     * @param id
     * @return
     */
    List<User> selectAllUserWithoutId(Integer id);

    /**
     * 根据 id 和 用户名 查询用户
     * @param username
     * @param id
     * @return
     */
    User selectUserByUsernameAndId(String username, Integer id);


}


