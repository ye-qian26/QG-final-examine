package com.yeqian.dao.mapper;

import com.yeqian.pojo.FavoritePost;
import com.yeqian.pojo.Post;
import com.yeqian.util.mybatis.annotations.Delete;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;

import java.util.List;

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


    /**
     * 根据 用户id 查询 所收藏的帖子
     * @param userId
     * @return
     */
    @Select("select p.* from post p " +
            "JOIN favorite_post fp on p.id = fp.post_id " +
            "JOIN user u on u.id = fp.user_id " +
            "where u.id = #{userId}")
    List<Post> selectPostsByUserId(@Param("userId") Integer userId);
}
