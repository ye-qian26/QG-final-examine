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

    /**
     * 根据 板块名 模糊查询 板块
     * @param name
     * @return
     */
    List<Plate> selectPlateByName(String name);

    /**
     * 增加板块点赞量
     * @param id
     */
    void addPlateLikes(Integer id);

    /**
     * 减少板块点赞量
     * @param id
     */
    void reducePlateLikes(Integer id);

    /**
     * 增加板块浏览量
     * @param id
     */
    void addPlatePageView(Integer id);

    /**
     * 根据 板块名 模糊查询 板块 并按 浏览量 降序排序
     * @param name
     * @return
     */
    List<Plate> selectPlateByNameWithPageView(String name);

    /**
     * 查询 所有板块 并按 浏览量 降序排序
     * @return
     */
    List<Plate> selectPlateWithPageView();

    /**
     * 根据 板块名 模糊查询 板块 并按 点赞量 降序排序
     * @param name
     * @return
     */
    List<Plate> selectPlateByNameWithLikes(String name);

    /**
     * 查询 所有板块 并按 点赞了 降序排序
     * @return
     */
    List<Plate> selectPlateWithLikes();
}
