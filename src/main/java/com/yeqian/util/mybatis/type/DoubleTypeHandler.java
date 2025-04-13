package com.yeqian.util.mybatis.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoubleTypeHandler implements TypeHandler<Double> {

    @Override
    public void setParameter(PreparedStatement ps, int i, Double value) throws SQLException {
        ps.setDouble(i, value);
    }

    @Override
    public Double getResult(ResultSet rs, String columnName) throws SQLException {
        return rs.getDouble(columnName);
    }
}
