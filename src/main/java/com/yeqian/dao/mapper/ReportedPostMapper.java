package com.yeqian.dao.mapper;

import com.yeqian.pojo.ReportedPost;
import com.yeqian.util.mybatis.annotations.Delete;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

import java.util.List;

public interface ReportedPostMapper {

    /**
     * 添加举报帖子
     * @param reportedPost
     */
    @Insert("insert into reported_post values (null, #{userId}, #{plateId}, #{postId}, #{reportContent})")
    void addReportPost(ReportedPost reportedPost);

    /**
     * 通过用户id查询帖子举报信息
     * @param userId
     * @return
     */
    @Select("select * from reported_post where user_id = #{userId}")
    List<ReportedPost> selectByUserId(@Param("userId") Integer userId);


    /**
     * 根据id删除举报信息
     * @param id
     */
    @Delete("delete from reported_post where id = #{id}")
    void deleteById(@Param("id") Integer id);

    /**
     * 根据 帖子id 删除 举报信息
     * @param postId
     */
    @Delete("delete from reported_post where post_id = #{postId}")
    void deleteByPostId(@Param("postId") Integer postId);
}
