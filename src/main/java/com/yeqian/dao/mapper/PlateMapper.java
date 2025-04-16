package com.yeqian.dao.mapper;

import com.yeqian.pojo.Plate;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;
import com.yeqian.util.mybatis.annotations.Update;

import java.util.List;

public interface PlateMapper {

    /**
     * 添加板块
     * @param name
     * @param userId
     */
    @Insert("insert into plate(user_id, name) values (#{userId}, #{name})")
    void addPlate(@Param("userId") Integer userId, @Param("name") String name);

    /**
     * 通过用户id查找板块
     * @param userId
     * @return
     */
    @Select("select * from plate where user_id = #{userId}")
    List<Plate> selectByUserId(@Param("userId") Integer userId);


    /**
     * 修改板块公告
     * @param plateId
     * @param notice
     */
    @Update("update plate set notice = #{notice} where id = #{plateId}")
    void updatePlateNotice(@Param("plateId") Integer plateId, @Param("notice") String notice);

    /**
     * 根据板块id查询板块
     * @param id
     * @return
     */
    @Select("select * from plate where id = #{id}")
    Plate selectById(@Param("id") Integer id);

    /**
     * 查询所有板块
     * @return
     */
    @Select("select * from plate")
    List<Plate> selectAllPlate();
}
