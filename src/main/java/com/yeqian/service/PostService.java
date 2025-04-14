package com.yeqian.service;

import com.yeqian.pojo.Post;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

import java.util.List;

public interface PostService {

    /**
     * 通过板块id查询帖子
     * @param plateId
     * @return
     */
    List<Post> selectPostByPlateId(Integer plateId);
}
