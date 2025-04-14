package com.yeqian.dao.mapper;

import com.yeqian.pojo.Post;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

import java.util.List;

public interface PostMapper {

    /**
     * 通过板块id查询帖子
     * @param plateId
     * @return
     */
    @Select("select * from post where plate_id = #{plateId}")
    List<Post> selectPostByPlateId(@Param("plateId") Integer plateId);


    /**
     * 添加帖子
     * @param content
     * @param image
     */
    @Insert("insert into post(content, image) values (#{content}, #{image})")
    void addPost(@Param("content") String content, @Param("image")String image);
}
