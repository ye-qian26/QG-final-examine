package com.yeqian.util.mybatis.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 字段类型处理器接口
 * @param <T>
 */
public interface TypeHandler<T> {

    void setParameter(PreparedStatement ps, int i , T value) throws SQLException;

    T getResult(ResultSet rs, String columnName) throws SQLException;
}
