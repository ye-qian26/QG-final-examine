package com.yeqian.dao.mapper;

import com.yeqian.pojo.Ban;
import com.yeqian.util.mybatis.annotations.Delete;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

public interface BanMapper {

    /**
     * 增加封禁用户
     * @param ban
     */
    @Insert("insert into ban values (null, #{userId}, #{plateId})")
    void add(Ban ban);

    /**
     * 根据用户id和板块id查询封禁表
     * @param userId
     * @param plateId
     * @return
     */
    @Select("select * from ban where user_id = #{userId} and plate_id = #{plateId}")
    Ban selectByUserIdAndPlateId(@Param("userId") Integer userId, @Param("plateId") Integer plateId);

    /**
     * 根据 用户id 和 板块id 删除封禁
     * @param ban
     */
    @Delete("delete from ban where user_id = #{userId} and plate_id = #{plateId}")
    void deleteBan(Ban ban);
}
