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
    @Insert("insert into post(content, image, plate_id, user_id, release_time) values (#{content}, #{image}, #{plateId}, #{userId}, #{releaseTime})")
    void addPost(@Param("content") String content, @Param("image")String image,
                 @Param("plateId") Integer plateId, @Param("userId") Integer userId, @Param("releaseTime") String releaseTime);

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

    /**
     * 通过id查询帖子
     * @param id
     * @return
     */
    @Select("select * from post where id = #{id}")
    Post selectPostById(@Param("id") Integer id);

    /**
     * 通过 板块id 和 帖子内容 模糊查询 帖子
     * @param content
     * @param plateId
     * @return
     */
    @Select("select * from post where plate_id = #{plateId} and content like #{content}")
    List<Post> selectPostByContentAndPlateId(@Param("content") String content, @Param("plateId") Integer plateId);

    /**
     * 通过 板块id 和 帖子内容 模糊查询 帖子 并按 时间 降序排序
     * @param content
     * @param plateId
     * @return
     */
    @Select("select * from post where plate_id = #{plateId} and content like #{content} order by release_time desc")
    List<Post> selectPostByContentAndPlateIdWithNew(@Param("content") String content, @Param("plateId") Integer plateId);

    /**
     * 通过 板块id 模糊查询 帖子 并按 时间 降序排序
     * @param plateId
     * @return
     */
    @Select("select * from post where plate_id = #{plateId} order by release_time desc")
    List<Post> selectPostByPlateIdWithNew(@Param("plateId") Integer plateId);

    /**
     * 通过 板块id 和 帖子内容 模糊查询 帖子 并按 浏览量 降序排序
     * @param content
     * @param plateId
     * @return
     */
    @Select("select * from post where plate_id = #{plateId} and content like #{content} order by page_view desc")
    List<Post> selectPostByContentAndPlateIdWithPageView(@Param("content") String content, @Param("plateId") Integer plateId);

    /**
     * 通过 板块id 模糊查询 帖子 并按 浏览量 降序排序
     * @param plateId
     * @return
     */
    @Select("select * from post where plate_id = #{plateId} order by page_view desc")
    List<Post> selectPostByPlateIdWithPageView(@Param("plateId") Integer plateId);

    /**
     * 通过 板块id 和 帖子内容 模糊查询 帖子 并按 点赞量 降序排序
     * @param content
     * @param plateId
     * @return
     */
    @Select("select * from post where plate_id = #{plateId} and content like #{content} order by likes desc")
    List<Post> selectPostByContentAndPlateIdWithLikes(@Param("content") String content, @Param("plateId") Integer plateId);

    /**
     * 通过 板块id 模糊查询 帖子 并按 点赞量 降序排序
     * @param plateId
     * @return
     */
    @Select("select * from post where plate_id = #{plateId} order by likes desc")
    List<Post> selectPostByPlateIdWithLikes(@Param("plateId") Integer plateId);
}
