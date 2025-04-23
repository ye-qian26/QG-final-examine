package com.yeqian.service;

import com.yeqian.pojo.ReviewUser;
import com.yeqian.util.mybatis.annotations.Delete;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

import java.util.List;

public interface ReviewUserService {

    /**
     * 增加 @用户 表
     * @param reviewUser
     */
    void addReviewUser(ReviewUser reviewUser);

    /**
     * 删除 @用户 表
     * @param reviewUser
     */
    void deleteReviewUser(ReviewUser reviewUser);

    /**
     * 根据 用户id 查询 @用户表
     * @param remindUserId
     * @return
     */
    List<ReviewUser> selectReviewUserByUserId(Integer remindUserId);

    /**
     * 根据 id 删除 @用户表
     * @param id
     */
    void deleteReviewUserById(Integer id);

    /**
     * 根据 帖子id 删除 @用户表
     * @param postId
     */
    void deleteByPostId(Integer postId);
}
