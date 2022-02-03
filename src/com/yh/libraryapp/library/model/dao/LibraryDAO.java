package com.yh.libraryapp.library.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yh.libraryapp.common.JDBCTemplate;
import com.yh.libraryapp.library.model.vo.LibraryVO;

public class LibraryDAO {
	public static List<LibraryVO> findAllLibraryNames() throws SQLException
	{
		List<LibraryVO> librarys = new ArrayList<LibraryVO>();
		
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select lib_regi_num, lib_name from library";
		
		try {
			conn = JDBCTemplate.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				int lib_regi_num = rs.getInt("lib_regi_num");
				String lib_name = rs.getString("lib_name");
				
				librarys.add(new LibraryVO(lib_regi_num,lib_name));
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
		
		return librarys;
	}
}
