package com.yh.libraryapp.config.type_handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.yh.libraryapp.book.model.vo.type.LoanYNType;

public class LoanYNTypeHandler extends BaseTypeHandler<LoanYNType>{

	@Override
	public LoanYNType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return LoanYNType.lookup(cs.getString(columnIndex));
	}

	@Override
	public LoanYNType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return LoanYNType.lookup(rs.getString(columnIndex));
	}

	@Override
	public LoanYNType getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return LoanYNType.lookup(rs.getString(columnName));
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, LoanYNType loanYNType, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i, loanYNType.getValue());
	}
	

}
