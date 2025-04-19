package com.yeqian.dao.mapper;

import com.yeqian.pojo.Ban;
import com.yeqian.pojo.Plate;
import com.yeqian.util.mybatis.annotations.Delete;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

import java.util.List;

public interface BanMapper {

    /**
     * 增加封禁用户
     * @param ban
     */
    @Insert("insert into ban values (null, #{userId}, #{banUserId}, #{plateId})")
    void add(Ban ban);

    /**
     * 根据 被封禁用户id 和 板块id 查询封禁表
     * @param banUserId
     * @param plateId
     * @return
     */
    @Select("select * from ban where ban_user_id = #{banUserId} and plate_id = #{plateId}")
    Ban selectByUserIdAndPlateId(@Param("banUserId") Integer banUserId, @Param("plateId") Integer plateId);

    /**
     * 根据 被封禁用户id 和 板块id 删除封禁
     * @param ban
     */
    @Delete("delete from ban where user_id = #{userId} and ban_user_id = #{banUserId} and plate_id = #{plateId}")
    void deleteBan(Ban ban);

    /**
     * 根据 用户id 查询 封禁表
     * @param userId
     * @return
     */
    @Select("select * from ban where user_id = #{userId}")
    List<Ban> selectByUserId(@Param("userId") Integer userId);
}
