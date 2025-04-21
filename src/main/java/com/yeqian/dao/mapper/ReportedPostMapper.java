package com.yeqian.dao.mapper;

import com.yeqian.pojo.ReportedPost;
import com.yeqian.util.mybatis.annotations.*;

import java.util.List;

public interface ReportedPostMapper {

    /**
     * 添加举报帖子
     * @param reportedPost
     */
    @Insert("insert into reported_post values (null, #{userId}, #{plateId}, #{postId}, #{reportContent}, #{isClean})")
    void addReportPost(ReportedPost reportedPost);

    /**
     * 通过用户id查询帖子举报信息
     * @param userId
     * @return
     */
    @Select("select * from reported_post where user_id = #{userId} and is_clean = 0")
    List<ReportedPost> selectByUserId(@Param("userId") Integer userId);


    /**
     * 根据 id 删除举报信息
     * @param id
     */
    @Update("update reported_post set is_clean = 1 where id = #{id}")
    void deleteById(@Param("id") Integer id);

    /**
     * 根据 帖子id 删除 举报信息
     * @param postId
     */
    @Delete("delete from reported_post where post_id = #{postId}")
    void deleteByPostId(@Param("postId") Integer postId);
}
