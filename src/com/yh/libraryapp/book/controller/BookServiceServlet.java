package com.yh.libraryapp.book.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.temporal.TemporalField;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.yh.libraryapp.book.model.vo.BookRsrVO;
import com.yh.libraryapp.book.model.vo.BookRtnVO;

@WebServlet("/book/service")
public class BookServiceServlet extends HttpServlet{
	private static SqlSessionFactory sqlSessionFactory;
	
	public static void setup() throws IOException {
		String resource = "com/yh/libraryapp/config/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);	
	}
	
	// 도서 대출
	private void loanBook(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		HttpSession httpSession = request.getSession();	
		MemberVO member = (MemberVO) httpSession.getAttribute("member");
		String book_name = request.getParameter("book_name");
		String[] books = request.getParameterValues("loan");
		boolean result = false;
		
		for(int i=0;i<books.length;i++)
		{
			result = false;
			
			int mem_num = member.getMem_num();
			int book_regi_num = Integer.parseInt(books[i].split(" ")[0]);
			int lib_regi_num = LibNameType.valueOf(books[i].split(" ")[1]).getValue();
			LocalDateTime dateTime = LocalDateTime.now();
			Date book_loan_date = Date.valueOf(dateTime.toLocalDate());
			Date book_rtn_expt_date = Date.valueOf(dateTime.plusDays(10).toLocalDate());
						
			BookLoanVO bookLoan = new BookLoanVO.Builder(-1)
												.lib_regi_num(lib_regi_num)
												.book_regi_num(book_regi_num)
												.mem_num(mem_num)
												.book_loan_date(book_loan_date)
												.book_loan_extn_num(0)
												.book_rtn_expt_date(book_rtn_expt_date)
												.build();
			
			try(SqlSession sqlSession = sqlSessionFactory.openSession()){	
				result = sqlSession.insert("com.yh.libraryapp.book.model.dao.BookMapper.loan",bookLoan) > 0 ? true : false;
				result = sqlSession.update("com.yh.libraryapp.book.model.dao.BookMapper.updateLoanYNAndRsrYNWhenLoan",bookLoan) > 0 ? true : false;
				result = sqlSession.update("com.yh.libraryapp.book.model.dao.BookMapper.decreaseLoanNum",bookLoan) > 0 ? true : false;
				sqlSession.commit();
			}catch (Exception e) {
				e.printStackTrace();
				result = false;
			}finally {
				if(result)
				{
					responseResult("대출성공", book_name, response);
				}
				else
				{
					responseResult("대출실패", book_name, response);
				}
			}
		}
	}
	
	// 도서 반납
	private void rtnBook(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		HttpSession httpSession = request.getSession();	
		MemberVO member = (MemberVO) httpSession.getAttribute("member");
		String book_name = request.getParameter("book_name");
		String[] rtns = request.getParameterValues("rtn");
		boolean result = false;
		
		for(int i=0;i<rtns.length;i++)
		{
			int mem_num = member.getMem_num();
			int lib_regi_num = LibNameType.valueOf(rtns[i].split(" ")[1]).getValue();
			int book_regi_num = Integer.parseInt(rtns[i].split(" ")[0]);
			LocalDateTime dateTime = LocalDateTime.now();
			Date book_rtn_date = Date.valueOf(dateTime.toLocalDate());
			Date book_rtn_expt_date = Date.valueOf(rtns[i].split(" ")[3]);
			int book_due_days = (int) (book_rtn_date.getTime() - book_rtn_expt_date.getTime());// 도서 연체 일수
			book_due_days = book_due_days<=0 ? 0 : book_due_days;
	
			BookRtnVO bookRtn = new BookRtnVO.Builder(-1)
												.lib_regi_num(lib_regi_num)
												.book_regi_num(book_regi_num)
												.mem_num(mem_num)
												.book_rtn_date(book_rtn_date)
												.book_due_days(book_due_days)
												.build();
			
			try(SqlSession sqlSession = sqlSessionFactory.openSession()){	
				result = sqlSession.insert("com.yh.libraryapp.book.model.dao.BookMapper.rtn",bookRtn) > 0 ? true : false;
				result = sqlSession.update("com.yh.libraryapp.book.model.dao.BookMapper.updateLoanYNAndRsrYNWhenRtn",bookRtn) > 0 ? true : false;
				result = sqlSession.update("com.yh.libraryapp.book.model.dao.BookMapper.increaseLoanNum",bookRtn) > 0 ? true : false;
				result = sqlSession.delete("com.yh.libraryapp.book.model.dao.BookMapper.deleteBookLoan",bookRtn) > 0 ? true : false;
				sqlSession.commit();
			}catch (Exception e) {
				e.printStackTrace();
				result = false;
			}finally {
				if(result)
				{
					responseResult("반납성공", book_name, response);
				}
				else
				{
					responseResult("반납실패", book_name, response);
				}
			}
		}
	}
	
	private void rsrBook(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession httpSession = request.getSession();	
		MemberVO member = (MemberVO) httpSession.getAttribute("member");
		String book_name = request.getParameter("book_name");
		String[] rsrs = request.getParameterValues("rsr");
		boolean result = false;
		
		for(int i=0; i<rsrs.length; i++)
		{
			int mem_num = member.getMem_num();
			int book_regi_num = Integer.parseInt(rsrs[i].split(" ")[0]);
			int lib_regi_num = LibNameType.valueOf(rsrs[i].split(" ")[1]).getValue();
			int book_rsr_prity_num = 1;
			Map<String,Object> hashmap = new HashMap<String, Object>();
			result = false;
			
			hashmap.put("lib_regi_num", lib_regi_num);
			hashmap.put("book_regi_num", book_regi_num);
			
			try(SqlSession sqlSession = sqlSessionFactory.openSession()){
				Object prity = sqlSession.selectOne("com.yh.libraryapp.book.model.dao.BookMapper.findBookRsrPrityNumByLibRegiNumAndBookRegiNum", hashmap);
				book_rsr_prity_num = prity!=null ? (int) prity+1 : 1;
			}
			
			BookRsrVO bookRsr = new BookRsrVO.Builder(-1)
					 						 .lib_regi_num(lib_regi_num)
											 .book_regi_num(book_regi_num)
											 .mem_num(mem_num)
											 .book_rsr_prity_num(book_rsr_prity_num)
											 .build();
			
			try(SqlSession sqlSession = sqlSessionFactory.openSession()){
				result = sqlSession.insert("com.yh.libraryapp.book.model.dao.BookMapper.rsr",bookRsr) > 0 ? true : false;
				result = sqlSession.update("com.yh.libraryapp.book.model.dao.BookMapper.decreaseRsrNum",bookRsr) > 0 ? true : false;
				
				//sqlSession.commit();
			}catch (Exception e) {
				e.printStackTrace();
				result = false;
			}finally {
				if(result)
				{
					responseResult("예약성공", book_name, response);
				}
				else
				{
					responseResult("예약실패", book_name, response);
				}
			}
			
		}
	}
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setup();
		request.setCharacterEncoding("utf-8");
		
		String service = request.getParameter("service");
		
		if(service.equals("대출"))
		{
			loanBook(request, response);
		}
		else if(service.equals("반납"))
		{
			rtnBook(request, response);
		}else if(service.equals("예약"))
		{
			rsrBook(request, response);
		}
		
	}
	
	private static void responseResult(String msg, String book_name, HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
	    out.println("<form name=\"frm\" action=\"/Library/book/detail?book_name="+book_name+"\" method=\"get\">");
	    out.println("<input name=\"book_name\" value=\""+book_name+"\"/>");
	    out.println("< /form>");
	    out.println("<script> alert(\""+msg+"\");frm.submit();</script>");
	}
}
