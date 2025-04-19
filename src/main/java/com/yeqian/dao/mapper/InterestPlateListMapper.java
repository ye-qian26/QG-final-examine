package com.yeqian.dao.mapper;

import com.yeqian.pojo.InterestPlateList;
import com.yeqian.util.mybatis.annotations.Delete;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

import java.util.List;

public interface InterestPlateListMapper {

    /**
     * 根据 用户id 和 板块id 查询关注板块列表
     * @param userId
     * @param plateId
     * @return
     */
    @Select("select * from interest_plate_list where user_id = #{userId} and interested_plate_id = #{plateId}")
    InterestPlateList selectByUserIdAndPlateId(@Param("userId") Integer userId, @Param("plateId") Integer plateId);

    /**
     * 添加 关注板块列表
     * @param interestPlateList
     */
    @Insert("insert into interest_plate_list values (null, #{userId}, #{interestedPlateId})")
    void addInterestPlateList(InterestPlateList interestPlateList);

    /**
     * 删除 关注板块列表
     * @param interestPlateList
     */
    @Delete("delete from interest_plate_list where user_id = #{userId} and interested_plate_id = #{interestedPlateId}")
    void deleteInterestPlateList(InterestPlateList interestPlateList);

    /**
     * 根据 用户id 查询 关注板块列表
     * @param userId
     * @return
     */
    @Select("select * from interest_plate_list where user_id = #{userId}")
    List<InterestPlateList> selectByUserId(@Param("userId") Integer userId);
}
