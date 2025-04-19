package com.yeqian.dao.mapper;

import com.yeqian.pojo.HistoricalRecord;
import com.yeqian.pojo.Post;
import com.yeqian.util.mybatis.annotations.Delete;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

import java.util.List;

public interface HistoricalRecordMapper {

    /**
     * 添加历史记录
     * @param hr
     */
    @Insert("insert into historical_record values (null, #{userId}, #{postId})")
    void addHistoricalRecord(HistoricalRecord hr);

    /**
     * 删除历史记录
     * @param hr
     */
    @Delete("delete from historical_record where user_id = #{userId} and post_id = #{postId}")
    void deleteHistoricalRecord(HistoricalRecord hr);

    /**
     * 根据 用户id 查询 历史记录
     * @param userId
     * @return
     */
    @Select("select p.* from post p " +
            "join historical_record hr on p.id = hr.post_id " +
            "join user u on u.id = hr.user_id " +
            "where u.id = #{userId} " +
            "order by hr.id desc")
    List<Post> selectHistoricalRecordsByUserId(@Param("userId") Integer userId);
}
