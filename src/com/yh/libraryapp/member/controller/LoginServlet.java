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
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.yh.libraryapp.member.model.vo.MemberVO;

@WebServlet("/home/login")
public class LoginServlet extends HttpServlet{

	private static SqlSessionFactory sqlSessionFactory;
	
	public static void setup() throws IOException {
		String resource = "com/yh/libraryapp/config/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("loginResult") != null
				&& !((Boolean) httpSession.getAttribute("isFailLogin")).booleanValue()) {
			httpSession.removeAttribute("loginResult");
		} else {
			httpSession.setAttribute("isFailLogin", false);
		}
		request.getRequestDispatcher("/views/member/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		setup();
		
		String mem_email = request.getParameter("email");
		String pwd = request.getParameter("password");
		HttpSession httpSession = request.getSession();
		MemberVO member = new MemberVO.Builder(-1)
										.mem_email(mem_email)
										.pwd(pwd)
										.build();
		
		
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			member =  sqlSession.selectOne("com.yh.libraryapp.member.model.dao.MemberMapper.findByEmailAndPwd",member);
		}finally {
			if(member!=null)
			{
				httpSession.setAttribute("member", member);
				response.sendRedirect("/Library/home");
			}
			else
			{
				httpSession.setAttribute("loginResult", "이메일 또는 비밀번호가 불일치합니다.");
				httpSession.setAttribute("isFailLogin", true);
				response.sendRedirect("/Library/home/login");
			}
		}		
	}
}
