package com.yeqian.dao.mapper;

import com.yeqian.pojo.FavoritePost;
import com.yeqian.util.mybatis.annotations.Delete;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

public interface FavoritePostMapper {

    /**
     * 根据用户id和帖子id查询收藏表
     * @param userId
     * @param postId
     * @return
     */
    @Select("select * from favorite_post where user_id = #{userId} and post_id = #{postId}")
    FavoritePost selectByUserIdAndPostId(@Param("userId") Integer userId, @Param("postId") Integer postId);

    /**
     * 根据用户id和帖子id删除对应收藏列表
     * @param userId
     * @param postId
     */
    @Delete("delete from favorite_post where user_id = #{userId} and post_id = #{postId}")
    void deleteByUserIdAndPostId(@Param("userId") Integer userId, @Param("postId") Integer postId);

    /**
     * 添加收藏
     * @param userId
     * @param postId
     */
    @Insert("insert into favorite_post values (null, #{postId}, #{userId})")
    void addFavoritePost(@Param("userId") Integer userId, @Param("postId") Integer postId);

    /**
     * 根据 帖子id 删除 收藏
     * @param postId
     */
    @Delete("delete from favorite_post where post_id = #{postId}")
    void deleteByPostId(@Param("postId") Integer postId);


}
