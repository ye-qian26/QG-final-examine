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

}
