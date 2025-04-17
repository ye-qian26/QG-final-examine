package com.yeqian.service;

import com.yeqian.pojo.ReportedPost;
import com.yeqian.util.mybatis.annotations.Delete;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

import java.util.List;

public interface ReportedPostService {

    /**
     * 添加举报帖子
     * @param reportedPost
     */
    void addReportPost(ReportedPost reportedPost);

    /**
     * 通过用户id查询帖子举报信息
     * @param userId
     * @return
     */
    List<ReportedPost> selectByUserId(Integer userId);


    /**
     * 根据id删除举报信息
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 根据 帖子id 删除 举报信息
     * @param postId
     */
    void deleteByPostId(Integer postId);
}
