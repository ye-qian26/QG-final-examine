package com.yeqian.service;

import com.yeqian.pojo.HistoricalRecord;
import com.yeqian.pojo.Post;
import com.yeqian.util.mybatis.annotations.Delete;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

import java.util.List;

public interface HistoricalRecordService {

    /**
     * 添加历史记录
     * @param hr
     */
    void addHistoricalRecord(HistoricalRecord hr);

    /**
     * 删除历史记录
     * @param hr
     */
    void deleteHistoricalRecord(HistoricalRecord hr);

    /**
     * 根据 用户id 查询 历史记录
     * @param userId
     * @return
     */
    List<Post> selectHistoricalRecordsByUserId(Integer userId);

    /**
     * 根据 帖子id 删除 历史记录
     * @param postId
     */
    void deleteByPostId(Integer postId);
}
