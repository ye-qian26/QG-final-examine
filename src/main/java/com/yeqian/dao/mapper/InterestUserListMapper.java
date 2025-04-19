package com.yeqian.dao.mapper;

import com.yeqian.pojo.InterestUserList;
import com.yeqian.util.mybatis.annotations.Delete;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

import java.util.List;

public interface InterestUserListMapper {

    /**
     * 根据 用户id 和 被关注用户id 查询关注用户列表
     * @param userId
     * @param interestedUserId
     * @return
     */
    @Select("select * from interest_user_list where user_id = #{userId} and interested_user_id = #{interestedUserId}")
    InterestUserList selectByUserIdAndInterestedUserId(@Param("userId") Integer userId, @Param("interestedUserId") Integer interestedUserId);

    /**
     * 添加 关注用户列表
     * @param InterestUserList
     */
    @Insert("insert into interest_user_list values (null, #{userId}, #{interestedUserId})")
    void addInterestPlateList(InterestUserList InterestUserList);

    /**
     * 删除 关注用户列表
     * @param InterestUserList
     */
    @Delete("delete from interest_user_list where user_id = #{userId} and interested_user_id = #{interestedUserId}")
    void deleteInterestPlateList(InterestUserList InterestUserList);

    /**
     * 根据 用户id 查询 关注用户表
     * @param userId
     * @return
     */
    @Select("select * from interest_user_list where user_id = #{userId}")
    List<InterestUserList> selectByUserId(@Param("userId") Integer userId);
}
