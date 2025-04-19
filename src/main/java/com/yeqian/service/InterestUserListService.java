package com.yeqian.service;

import com.yeqian.pojo.InterestUserList;
import com.yeqian.util.mybatis.annotations.Delete;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

import java.util.List;

public interface InterestUserListService {

    /**
     * 根据 用户id 和 被关注用户id 查询关注用户列表
     * @param userId
     * @param interestedUserId
     * @return
     */
    InterestUserList selectByUserIdAndInterestedUserId(Integer userId, Integer interestedUserId);

    /**
     * 添加 关注用户列表
     * @param InterestUserList
     */
    void addInterestPlateList(InterestUserList InterestUserList);

    /**
     * 删除 关注用户列表
     * @param InterestUserList
     */
    void deleteInterestPlateList(InterestUserList InterestUserList);

    /**
     * 根据 用户id 查询 关注用户表
     * @param userId
     * @return
     */
    List<InterestUserList> selectByUserId(Integer userId);
}
