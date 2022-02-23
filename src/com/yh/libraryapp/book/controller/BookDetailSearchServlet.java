package com.yh.libraryapp.book.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yh.libraryapp.book.model.dao.BookDAO;
import com.yh.libraryapp.book.model.vo.BookVO;

@WebServlet("/detailSearch")
public class BookDetailSearchServlet extends HttpServlet{

	private static SqlSessionFactory sqlSessionFactory;
	
	public static void setup() throws IOException {
		String resource = "com/yh/libraryapp/config/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setup();
		request.setCharacterEncoding("utf-8");
		List<BookVO> books = null;
		String lib_name = request.getParameter("lib_name").equals("전체") ? null : request.getParameter("lib_name");
		String book_name = request.getParameter("book_name").equals("") ? null : request.getParameter("book_name");
		String author_name = request.getParameter("author_name").equals("") ? null : request.getParameter("author_name");
		String pub_com = request.getParameter("pub_com").equals("") ? null : request.getParameter("pub_com");
		
		Integer pub_year_start = request.getParameter("pub_year_start").equals("") ? 
								 null : Integer.parseInt(request.getParameter("pub_year_start"));
		Integer pub_year_end = request.getParameter("pub_year_end").equals("") ? 
				 				null : Integer.parseInt(request.getParameter("pub_year_end"));
		
		Map<String,Object> hashmap = new HashMap<String, Object>();
		hashmap.put("lib_name", lib_name);
		hashmap.put("book_name", book_name);
		hashmap.put("author_name", author_name);
		hashmap.put("pub_com",pub_com);
		hashmap.put("pub_year_start", pub_year_start);
		hashmap.put("pub_year_end", pub_year_end);
					
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			books = sqlSession.selectList("com.yh.libraryapp.book.model.dao.BookMapper.findByContents",hashmap);
		}
		
		request.setAttribute("books", books);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
