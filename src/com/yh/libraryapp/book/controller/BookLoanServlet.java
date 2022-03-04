package com.yh.libraryapp.book.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.temporal.TemporalField;
import java.util.Arrays;
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

import com.yh.libraryapp.book.model.vo.BookVO;
import com.yh.libraryapp.library.model.vo.type.LibNameType;
import com.yh.libraryapp.member.model.vo.MemberVO;
import com.yh.libraryapp.book.model.vo.BookDetailVO;
import com.yh.libraryapp.book.model.vo.BookLoanVO;
import com.yh.libraryapp.book.model.vo.BookOwnVO;

@WebServlet("/book/loan")
public class BookLoanServlet extends HttpServlet{
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
		
		HttpSession httpSession = request.getSession();
		
		MemberVO member = (MemberVO) httpSession.getAttribute("member");
		String book_name = request.getParameter("book_name");
		String[] books = request.getParameterValues("loan");
		
		for(int i=0;i<books.length;i++)
		{
			boolean result = false;
			
			int mem_num = member.getMem_num();
			int book_regi_num = Integer.parseInt(books[i].split(" ")[0]);
			int lib_regi_num = LibNameType.valueOf(books[i].split(" ")[1]).getValue();
			LocalDateTime dateTime = LocalDateTime.now();
			Date book_loan_date = Date.valueOf(dateTime.toLocalDate());
			Date book_rtn_expt_date = Date.valueOf(dateTime.plusDays(10).toLocalDate());
						
			BookLoanVO bookLoan = new BookLoanVO.Builder(mem_num)
												.lib_regi_num(lib_regi_num)
												.book_regi_num(book_regi_num)
												.book_loan_date(book_loan_date)
												.book_loan_extn_num(0)
												.book_rtn_expt_date(book_rtn_expt_date)
												.book_loan_num(0)
												.build();
			
			try(SqlSession sqlSession = sqlSessionFactory.openSession()){	
				result = sqlSession.insert("com.yh.libraryapp.book.model.dao.BookMapper.loan",bookLoan) > 0 ? true : false;
				result = sqlSession.update("com.yh.libraryapp.book.model.dao.BookMapper.updateLoanYNAndRsrYN",bookLoan) > 0 ? true : false;
				result = sqlSession.update("com.yh.libraryapp.book.model.dao.BookMapper.updateLoanNum",bookLoan) > 0 ? true : false;
				//sqlSession.commit();
			}catch (Exception e) {
				e.printStackTrace();
				result = false;
			}finally {
				if(result)
				{
					request.getSession().setAttribute("loanResult", "대출성공");
				}
				else
				{
					request.getSession().setAttribute("loanResult", "대출실패");
				}
				response.sendRedirect("/Library/book/detail?book_name="+book_name);
			}
		}
		
		
											
											
	}
}
