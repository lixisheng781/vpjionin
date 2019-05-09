package com.vpclub.mybatis;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

@Component
public class StringArrayTypeHandler extends BaseTypeHandler<String[]> {
	
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType) throws SQLException {
		String[] temp = Arrays.stream(parameter).filter(item -> StringUtils.isNotBlank(item)).map(item -> item.trim()).toArray(String[]::new);
		ps.setString(i, String.join("," , temp));
	}
	
	@Override
	public String[] getNullableResult(ResultSet rs, String columnName) throws SQLException {
		String str = rs.getString(columnName);
		if (rs.wasNull())
			return null;
		
		return   handlerStringArray(str);
	}

	@Override
	public String[] getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		String str = rs.getString(columnIndex);
		if (rs.wasNull())
			return null;
		
		return   handlerStringArray(str);
	}
	
	@Override
	public String[] getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		String str = cs.getString(columnIndex);
		if (cs.wasNull())
			return null;
		
		return   handlerStringArray(str);
	}
	
	private String[] handlerStringArray(String str) {
		return Arrays.stream(str.split(",")).filter(item -> StringUtils.isNotBlank(item)).map(item -> item.trim()).toArray(String[]::new);
	}
	
}
