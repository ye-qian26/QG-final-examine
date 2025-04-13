package com.yeqian.dao.mapper;

import com.yeqian.pojo.Administrator;
import com.yeqian.pojo.User;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;
import com.yeqian.util.mybatis.annotations.Update;

public interface AdministratorMapper {

    /**
     * 添加管理员
     * @param administrator
     */
    @Insert("insert into administrator values (null, #{name}, MD5(#{password}), #{tele}, null)")
    void insertAdministrator(Administrator administrator);

    /**
     * 根据手机号查询管理员
     * @param tele
     * @return
     */
    @Select("select * from administrator where tele = #{tele}")
    Administrator selectByTele(@Param("tele") String tele);

    /**
     * 根据手机号和密码查询管理员
     * @param tele
     * @param password
     * @return
     */
    @Select("select * from administrator where tele = #{tele} and password = MD5(#{password})")
    Administrator selectAdministrator(@Param("tele") String tele,@Param("password") String password);

    /**
     * 修改管理员昵称
     * @param name
     * @param id
     */
    @Update("update administrator set name = #{name} where id = #{id}")
    void updateAdministratorName(@Param("name") String name, @Param("id") Integer id);

    /**
     * 修改管理员头像
     * @param headPortrait
     * @param id
     */
    @Update("update administrator set head_portrait = #{headPortrait} where id = #{id}")
    void updateAdministratorHeadPortrait(@Param("headPortrait") String headPortrait, @Param("id") Integer id);

    /**
     * 修改管理员密码
     * @param password
     * @param id
     */
    @Update("update administrator set password = MD5(#{password}) where id = #{id}")
    void updateAdministratorPassword(@Param("password") String password, @Param("id") Integer id);
}
