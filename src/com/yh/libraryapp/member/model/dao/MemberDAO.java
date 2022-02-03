package com.yh.libraryapp.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yh.libraryapp.common.JDBCTemplate;
import com.yh.libraryapp.member.model.vo.MemberLoginVO;
import com.yh.libraryapp.member.model.vo.MemberLoginedVO;
import com.yh.libraryapp.member.model.vo.MemberSignUpVO;
import com.yh.libraryapp.member.model.vo.MemberVO;

public class MemberDAO {
	private SqlSessionFactory sqlSessionFactory;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public static int signUp(MemberSignUpVO member) throws SQLException
	{
		PreparedStatement pst = null;
		Connection conn = null;
		int result = -1;
		String sql = "insert into member (pwd, mem_email, mem_name, lib_regi_num) " + 
						"values(?, ?, ?, " + 
						"(select lib_regi_num from library where lib_name=?))";
		
		try {
			conn = JDBCTemplate.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, member.getPwd());
			pst.setString(2, member.getMem_email());
			pst.setString(3, member.getMem_name());
			pst.setString(4, member.getLib_regi_name());
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {	
			if(pst!=null)
			{
				pst.close();
			}
			if(conn!=null)
			{
				conn.close();
			}
		}
		return result;
	}

	public static MemberLoginedVO login(MemberLoginVO member) throws SQLException {
		
		MemberLoginedVO logined_member = null;
		
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select *"
					+ "from member "
					+ "where mem_email = ?";
		
		try {
			conn = JDBCTemplate.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, member.getMem_email());
			rs = pst.executeQuery();
			
			if(rs.next())
			{
				if(rs.getString("pwd").contentEquals(member.getPwd()))
				{
					logined_member = new MemberLoginedVO(rs.getInt("mem_num")
														,rs.getString("mem_name")
														,rs.getString("mem_email")
														,rs.getInt("loan_num")
														,rs.getInt("rsr_num")
														,rs.getDate("due_date")
														,rs.getDate("mtl_loan_date")
														);
					return logined_member;	// ·Î±×ÀÎ ¼º°ø
				}
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)
			{
				rs.close();
			}
			if(pst!=null)
			{
				pst.close();
			}
			if(conn!=null)
			{
				conn.close();
			}	
		}
		return null;
	}
}
