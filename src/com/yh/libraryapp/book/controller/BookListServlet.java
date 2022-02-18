package com.yh.libraryapp.book.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yh.libraryapp.book.model.dao.BookDAO;
import com.yh.libraryapp.book.model.dao.BookMapper;
import com.yh.libraryapp.book.model.vo.BookVO;

@WebServlet("/home")
public class BookListServlet extends HttpServlet{
	private static SqlSessionFactory sqlSessionFactory;
	
	public static void setup() throws IOException {
		String resource = "com/yh/libraryapp/config/mybatis-config-test.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setup();
		
		List<BookVO> books = null;
		
		
		
		String lib_name = request.getParameter("library");
		lib_name = lib_name==null ? "전체" : lib_name;
		
		if(lib_name.equals("전체"))
		{
			try(SqlSession sqlSession = sqlSessionFactory.openSession()){
				BookMapper mapper = sqlSession.getMapper(BookMapper.class);
				books = mapper.findAllBook();
			}
		}
		else
		{
			try(SqlSession sqlSession = sqlSessionFactory.openSession()){
				BookMapper mapper = sqlSession.getMapper(BookMapper.class);
				books = mapper.findByLibName(lib_name);
			}
		}
		
		request.setAttribute("library", lib_name);
		request.setAttribute("books", books);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
