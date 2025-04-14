package com.yeqian.service;

import com.yeqian.pojo.Plate;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

import java.util.List;

public interface PlateService {
    /**
     * 添加板块
     */
    void addPlate(Integer userId, String name);

    /**
     * 通过用户id查找板块
     * @param userId
     * @return
     */
    List<Plate> selectByUserId(Integer userId);
}
