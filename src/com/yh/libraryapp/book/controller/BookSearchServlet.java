package com.yh.libraryapp.book.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.libraryapp.book.model.dao.BookDAO;
import com.yh.libraryapp.book.model.vo.BookListVO;

@WebServlet("/search")
public class BookSearchServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<BookListVO> books = null;
		
		String query = request.getParameter("content");
	
		try {
			books = BookDAO.searchBook(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("books", books);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
