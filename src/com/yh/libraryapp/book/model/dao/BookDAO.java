package com.yh.libraryapp.book.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.yh.libraryapp.book.model.vo.BookListVO;
import com.yh.libraryapp.common.JDBCTemplate;

public class BookDAO {
	
	
	public static List<BookListVO> findAllBook() throws SQLException
	{
		List<BookListVO> books = new ArrayList<BookListVO>();
		
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM all_book_vw";
		
		try {
			conn = JDBCTemplate.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				String book_name = rs.getString("book_name");
				String authors = rs.getString("authors");
				String pub_com = rs.getString("pub_com");
				int pub_year = rs.getInt("pub_year");
				
				BookListVO bookElement = new BookListVO(book_name, authors, pub_com, pub_year); 
				books.add(bookElement);
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
		
		return books;
	}
	
	public static List<BookListVO> findFilteredBook(String lib_name) throws SQLException
	{
		List<BookListVO> books = new ArrayList<BookListVO>();
		
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM filter_book_vw WHERE lib_name = ?";
		
		try {
			conn = JDBCTemplate.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, lib_name);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				String book_name = rs.getString("book_name");
				String authors = rs.getString("authors");
				String pub_com = rs.getString("pub_com");
				int pub_year = rs.getInt("pub_year");
				
				BookListVO bookElement = new BookListVO(book_name, authors, pub_com, pub_year); 
				books.add(bookElement);
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
		
		return books;
	}
	
	// ���� ���հ˻�
	public static List<BookListVO> searchBook(String query) throws SQLException
	{
		List<BookListVO> books = new ArrayList<BookListVO>();
		
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM all_book_vw "
				+ "WHERE book_name like ? or "
				+ "authors like ? or "
				+ "pub_com like ? or "
				+ "pub_year like ? ";
		
		try {
			conn = JDBCTemplate.getConnection();
			pst = conn.prepareStatement(sql);
			for(int i=1;i<=4;i++)
			{
				pst.setString(i, '%'+query+'%');
			}
			
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				String book_name = rs.getString("book_name");
				String authors = rs.getString("authors");
				String pub_com = rs.getString("pub_com");
				int pub_year = rs.getInt("pub_year");
				
				BookListVO bookElement = new BookListVO(book_name, authors, pub_com, pub_year); 
				books.add(bookElement);
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
		
		return books;
	}
}
