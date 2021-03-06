package com.yh.libraryapp.book.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yh.libraryapp.book.model.vo.BookVO;

@WebServlet("/search")
public class BookSearchServlet extends HttpServlet{

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
		String content = request.getParameter("content");
	
		
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			
			books = sqlSession.selectList("com.yh.libraryapp.book.model.dao.BookMapper.findByContent",content);
		}
		
		request.setAttribute("books", books);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
