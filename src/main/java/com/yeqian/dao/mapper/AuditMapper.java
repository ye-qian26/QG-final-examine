package com.yeqian.dao.mapper;

import com.yeqian.pojo.Audit;
import com.yeqian.util.mybatis.annotations.*;

import java.util.List;

public interface AuditMapper {

    /**
     * 添加申请
     * @param audit
     */
    @Insert("insert audit values (null, #{userId}, #{plateName}, #{status}, #{isClean})")
    void addAudit(Audit audit);

    /**
     * 查询所有申请（未被清理）
     * @return
     */
    @Select("select * from audit where is_clean = 0")
    List<Audit> selectAllAudit();

    /**
     * 根据id删除申请数据
     * @param id
     */
    @Update("update audit set is_clean = 1 where id = #{id}")
    void deleteAuditById(@Param("id") Integer id);

    /**
     * 修改申请状态
     * @param id
     * @param status
     */
    @Update("update audit set status = #{status} where id = #{id}")
    void updateAuditStatus(@Param("id") Integer id, @Param("status") Integer status);
}
