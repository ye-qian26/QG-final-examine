package com.yeqian.dao.mapper;

import com.yeqian.pojo.Plate;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;
import com.yeqian.util.mybatis.annotations.Update;

import java.util.List;

public interface PlateMapper {

    /**
     * 添加板块
     * @param name
     * @param userId
     */
    @Insert("insert into plate(user_id, name) values (#{userId}, #{name})")
    void addPlate(@Param("userId") Integer userId, @Param("name") String name);

    /**
     * 通过用户id查找板块
     * @param userId
     * @return
     */
    @Select("select * from plate where user_id = #{userId}")
    List<Plate> selectByUserId(@Param("userId") Integer userId);


    /**
     * 修改板块公告
     * @param plateId
     * @param notice
     */
    @Update("update plate set notice = #{notice} where id = #{plateId}")
    void updatePlateNotice(@Param("plateId") Integer plateId, @Param("notice") String notice);

    /**
     * 根据板块id查询板块
     * @param id
     * @return
     */
    @Select("select * from plate where id = #{id}")
    Plate selectById(@Param("id") Integer id);

    /**
     * 查询所有板块
     * @return
     */
    @Select("select * from plate")
    List<Plate> selectAllPlate();

    /**
     * 根据 板块名 模糊查询 板块
     * @param name
     * @return
     */
    @Select("select * from plate where name like #{name}")
    List<Plate> selectPlateByName(@Param("name") String name);

    /**
     * 增加板块点赞量
     * @param id
     */
    @Update("update plate set likes = likes + 1 where id = #{id}")
    void addPlateLikes(@Param("id") Integer id);

    /**
     * 减少板块点赞量
     * @param id
     */
    @Update("update plate set likes = likes - 1 where id = #{id}")
    void reducePlateLikes(@Param("id") Integer id);

    /**
     * 增加板块浏览量
     * @param id
     */
    @Update("update plate set page_view = page_view + 1 where id = #{id}")
    void addPlatePageView(@Param("id") Integer id);

    /**
     * 根据 板块名 模糊查询 板块 并按 浏览量 降序排序
     * @param name
     * @return
     */
    @Select("select * from plate where name like #{name} order by page_view desc")
    List<Plate> selectPlateByNameWithPageView(@Param("name") String name);

    /**
     * 查询 所有板块 并按 浏览量 降序排序
     * @return
     */
    @Select("select * from plate order by page_view desc")
    List<Plate> selectPlateWithPageView();

    /**
     * 根据 板块名 模糊查询 板块 并按 点赞量 降序排序
     * @param name
     * @return
     */
    @Select("select * from plate where name like #{name} order by likes desc")
    List<Plate> selectPlateByNameWithLikes(@Param("name") String name);

    /**
     * 查询 所有板块 并按 点赞了 降序排序
     * @return
     */
    @Select("select * from plate order by likes desc")
    List<Plate> selectPlateWithLikes();
}
