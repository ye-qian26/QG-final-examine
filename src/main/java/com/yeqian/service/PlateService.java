package com.yeqian.service;

import com.yeqian.pojo.Plate;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;
import com.yeqian.util.mybatis.annotations.Update;

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

    /**
     * 修改板块公告
     * @param plateId
     * @param notice
     */
    void updatePlateNotice(Integer plateId, String notice);

    /**
     * 根据板块id查询板块
     * @param id
     * @return
     */
    Plate selectById(Integer id);

    /**
     * 查询所有板块
     * @return
     */
    List<Plate> selectAllPlate();
}
