package com.yeqian.dao.mapper;

import com.yeqian.pojo.Audit;
import com.yeqian.util.mybatis.annotations.*;

import java.util.List;

public interface AuditMapper {

    /**
     * 添加申请
     * @param audit
     */
    @Insert("insert audit values (null, #{userId}, #{plateName}, #{status})")
    void addAudit(Audit audit);

    /**
     * 查询所有申请
     * @return
     */
    @Select("select * from audit")
    List<Audit> selectAllAudit();

    /**
     * 根据id删除申请数据
     * @param id
     */
    @Delete("delete from audit where id = #{id}")
    void deleteAuditById(@Param("id") Integer id);

    /**
     * 修改申请状态
     * @param id
     * @param status
     */
    @Update("update audit set status = #{status} where id = #{id}")
    void updateAuditStatus(@Param("id") Integer id, @Param("status") Integer status);
}
