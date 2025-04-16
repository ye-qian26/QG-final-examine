package com.yeqian.dao.mapper;

import com.yeqian.pojo.Post;
import com.yeqian.util.mybatis.annotations.*;
import sun.awt.image.IntegerInterleavedRaster;

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
    @Insert("insert into post(content, image, plate_id, user_id) values (#{content}, #{image}, #{plateId}, #{userId})")
    void addPost(@Param("content") String content, @Param("image")String image, @Param("plateId") Integer plateId, @Param("userId") Integer userId);

    /**
     *
     * @param id
     */
    @Delete("delete from post where id = #{id}")
    void deletePostById(@Param("id") Integer id);

    /**
     * 增加帖子点赞量
     * @param id
     */
    @Update("update post set likes = likes + 1 where id = #{id}")
    void addPostLikesById(@Param("id") Integer id);

    /**
     * 减少帖子点赞量
     * @param id
     */
    @Update("update post set likes = likes - 1 where id = #{id}")
    void reducePostLikesById(@Param("id") Integer id);

    /**
     * 增加帖子浏览量
     * @param id
     */
    @Update("update post set page_view = page_view + 1 where id = #{id}")
    void addPostPageView(@Param("id") Integer id);
}
