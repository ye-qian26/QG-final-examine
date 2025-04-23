package com.yeqian.service.impl;

import com.yeqian.dao.mapper.UserMapper;
import com.yeqian.pojo.User;
import com.yeqian.service.UserService;
import com.yeqian.util.mybatis.proxy.MapperProxyFactory;

import java.util.Collections;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserMapper userMapper = MapperProxyFactory.getProxy(UserMapper.class);

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public User selectUserByTele(String tele) {
        return userMapper.selectUserByTele(tele);
    }

    @Override
    public User selectUser(String tele, String password) {
        return userMapper.selectUser(tele, password);
    }

    @Override
    public void updateUsername(String username, Integer id) {
        userMapper.updateUsername(username, id);
    }


    @Override
    public void updateUserHeadPortrait(String headPortrait, Integer id) {
        userMapper.updateUserHeadPortrait(headPortrait, id);
    }

    @Override
    public void updateUserPassword(String password, Integer id) {
        userMapper.updateUserPassword(password, id);
    }

    @Override
    public User selectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public List<User> selectAllUserWithoutId(Integer id) {
        return userMapper.selectAllUserWithoutId(id);
    }

    @Override
    public User selectUserByUsernameAndId(String username, Integer id) {
        return userMapper.selectUserByUsernameAndId(username, id);
    }
}
