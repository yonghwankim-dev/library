package com.yh.libraryapp.member.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yh.libraryapp.member.model.dao.MemberDAO;
import com.yh.libraryapp.member.model.vo.MemberLoginVO;
import com.yh.libraryapp.member.model.vo.MemberLoginedVO;

@WebServlet("/home/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/member/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		
		MemberLoginVO member = new MemberLoginVO(email, pwd);
		MemberLoginedVO logined_member = null;
		
		try {
			logined_member = MemberDAO.login(member);
		} catch (SQLException	 e) {
			e.printStackTrace();
		}
		
		if(logined_member!=null)
		{
			request.getSession().setAttribute("member", logined_member);
		}
		response.sendRedirect("/Library/home");
	}
}
