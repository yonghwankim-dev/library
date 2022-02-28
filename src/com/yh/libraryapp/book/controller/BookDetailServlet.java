package com.yh.libraryapp.book.controller;

import java.io.IOException;
import java.io.InputStream;
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
import com.yh.libraryapp.book.model.vo.BookDetailVO;
import com.yh.libraryapp.book.model.vo.BookOwnVO;

@WebServlet("/book/detail")
public class BookDetailServlet extends HttpServlet{
	private static SqlSessionFactory sqlSessionFactory;
	
	public static void setup() throws IOException {
		String resource = "com/yh/libraryapp/config/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setup();
		
		String book_name = request.getParameter("book_name");
		
		BookDetailVO book = null;
		List<BookOwnVO> bookOwnInfos = null;
		
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){	
			book = sqlSession.selectOne("com.yh.libraryapp.book.model.dao.BookMapper.findByBookName",book_name);
			bookOwnInfos = sqlSession.selectList("com.yh.libraryapp.book.model.dao.BookMapper.findBookOwnInfoByBookName",book_name);
		}
		
		request.setAttribute("book", book);
		request.setAttribute("bookOwnInfos", bookOwnInfos);
		
		request.getRequestDispatcher("/views/book/detail.jsp").forward(request, response);
	}
}
