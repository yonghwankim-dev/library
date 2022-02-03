package book.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import book.model.dao.BookDAO;
import book.model.vo.BookListVO;

@WebServlet("/home")
public class BookListServlet extends HttpServlet{

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BookListVO> books = null;
		
		String lib_name = request.getParameter("library");
		lib_name = lib_name==null ? "전체" : lib_name; 
		
		try {
			if(lib_name!=null && !lib_name.contentEquals("전체"))
			{
				books = BookDAO.findFilteredBook(lib_name);
			}
			else
			{
				books = BookDAO.findAllBook();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("library", lib_name);
		request.setAttribute("books", books);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
