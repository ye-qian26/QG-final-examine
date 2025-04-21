package com.yeqian.dao.mapper;

import com.yeqian.pojo.ReportedUser;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;
import com.yeqian.util.mybatis.annotations.Update;

import java.util.List;

public interface ReportedUserMapper {

    /**
     * 添加 举报用户 信息
     * @param reportedUser
     */
    @Insert("insert into reported_user values (null, #{userId}, #{reportContent}, #{isClean})")
    void addReportedUser(ReportedUser reportedUser);

    /**
     * 查询所有 举报用户 信息（逻辑查询）
     * @return
     */
    @Select("select * from reported_user where is_clean = 0")
    List<ReportedUser> selectAllReportedUser();


    /**
     * 根据 id 删除 举报用户信息（逻辑删除）
     * @param id
     */
    @Update("update reported_user set is_clean = 1 where id = #{id}")
    void deleteById(@Param("id") Integer id);
}
