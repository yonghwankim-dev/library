package com.yh.libraryapp.member.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yh.libraryapp.library.model.dao.LibraryDAO;
import com.yh.libraryapp.library.model.vo.LibraryVO;
import com.yh.libraryapp.member.model.dao.MemberDAO;
import com.yh.libraryapp.member.model.vo.MemberSignUpVO;

@WebServlet("/home/signUp")
public class SignUpServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		initLibrarys(request);
			
		HttpSession session = request.getSession();
		if(session.getAttribute("signUpResult")!=null && 
				!((Boolean) session.getAttribute("isFailSignUp")).booleanValue())
		{
			session.removeAttribute("signUpResult");
		}
		else
		{
			session.setAttribute("isFailSignUp", false);
		}
		
		request.getRequestDispatcher("/views/member/signUp.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		initLibrarys(request);
		
		String mem_name = request.getParameter("name");
		String mem_email = request.getParameter("email");
		String mem_pwd = request.getParameter("password");
		String mem_confirm_pwd = request.getParameter("confirm_password");
		String lib_regi_name = request.getParameter("library_name");
		
		MemberSignUpVO member = new MemberSignUpVO(mem_name, mem_email, mem_pwd, mem_confirm_pwd, lib_regi_name);
		HttpSession session = request.getSession();
		
		try {
			if(mem_pwd.equals(mem_confirm_pwd))
			{
				int result = MemberDAO.signUp(member);
				if(result==-1)
				{
					session.setAttribute("signUpResult", "이메일 중복되었습니다.");
				}
				else
				{
					response.sendRedirect("/Library/home");
				}
			}
			else
			{
				session.setAttribute("signUpResult", "비밀번호가 중복되었습니다.");
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			session.setAttribute("isFailSignUp", true);
			response.sendRedirect("/Library/home/signUp");
		}	
	}
	
	private static void initLibrarys(HttpServletRequest request)
	{
		try {
			List<LibraryVO> librarys = LibraryDAO.findAllLibraryNames();
			request.setAttribute("librarys", librarys);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
