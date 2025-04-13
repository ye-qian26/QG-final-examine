package com.yeqian.dao.mapper;

import com.yeqian.pojo.User;
import com.yeqian.util.mybatis.annotations.Insert;
import com.yeqian.util.mybatis.annotations.Param;
import com.yeqian.util.mybatis.annotations.Select;
import com.yeqian.util.mybatis.annotations.Update;

public interface UserMapper {

    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into user values (null, #{username}, MD5(#{password}), #{tele}, null)")
    void insertUser(User user);

    /**
     * 根据手机号查询用户
     * @param tele
     * @return
     */
    @Select("select * from user where tele = #{tele}")
    User selectUserByTele(@Param("tele") String tele);

    /**
     * 根据手机号和密码查询用户
     * @param tele
     * @param password
     * @return
     */
    @Select("select * from user where tele = #{tele} and password = MD5(#{password})")
    User selectUser(@Param("tele") String tele,@Param("password") String password);

    /**
     * 修改用户昵称
     * @param username
     * @param id
     */
    @Update("update user set username = #{username} where id = #{id}")
    void updateUsername(@Param("username") String username, @Param("id") Integer id);

    /**
     * 修改用户头像
     * @param headPortrait
     * @param id
     */
    @Update("update user set head_portrait = #{headPortrait} where id = #{id}")
    void updateUserHeadPortrait(@Param("headPortrait") String headPortrait, @Param("id") Integer id);

    /**
     * 修改用户密码
     * @param password
     * @param id
     */
    @Update("update user set password = MD5(#{password}) where id = #{id}")
    void updateUserPassword(@Param("password") String password, @Param("id") Integer id);
}
