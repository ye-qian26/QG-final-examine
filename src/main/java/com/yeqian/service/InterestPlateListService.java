package com.yeqian.service;

import com.yeqian.pojo.InterestPlateList;
import com.yeqian.util.mybatis.annotations.Delete;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

import java.util.List;

public interface InterestPlateListService {

    /**
     * 根据 用户id 和 板块id 查询关注板块列表
     * @param userId
     * @param plateId
     * @return
     */
    InterestPlateList selectByUserIdAndPlateId(Integer userId, Integer plateId);

    /**
     * 添加 关注板块列表
     * @param interestPlateList
     */
    void addInterestPlateList(InterestPlateList interestPlateList);

    /**
     * 删除 关注板块列表
     * @param interestPlateList
     */
    void deleteInterestPlateList(InterestPlateList interestPlateList);

    /**
     * 根据 用户id 查询 关注板块列表
     * @param userId
     * @return
     */
    List<InterestPlateList> selectByUserId(Integer userId);
}
