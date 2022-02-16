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
import org.junit.jupiter.api.BeforeAll;

import com.yh.libraryapp.library.model.dao.LibraryDAO;
import com.yh.libraryapp.library.model.vo.LibraryVO;
import com.yh.libraryapp.member.model.dao.MemberMapper;
import com.yh.libraryapp.member.model.vo.MemberVO;

@WebServlet("/home/signUp")
public class SignUpServlet extends HttpServlet {

	private static SqlSessionFactory sqlSessionFactory;
	
	public static void setup() throws IOException {
		String resource = "com/yh/libraryapp/config/mybatis-config-test.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		initLibrarys(request);

		HttpSession session = request.getSession();
		if (session.getAttribute("signUpResult") != null
				&& !((Boolean) session.getAttribute("isFailSignUp")).booleanValue()) {
			session.removeAttribute("signUpResult");
		} else {
			session.setAttribute("isFailSignUp", false);
		}

		request.getRequestDispatcher("/views/member/signUp.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		setup();
		initLibrarys(request);

		HttpSession session = request.getSession();
		
		String mem_name = request.getParameter("name");
		String mem_email = request.getParameter("email");
		String mem_pwd = request.getParameter("password");
		String mem_confirm_pwd = request.getParameter("confirm_password");
		int lib_regi_num = Integer.parseInt(request.getParameter("library_name"));


		// 비밀번호 불일치한 경우
		if(!mem_pwd.equals(mem_confirm_pwd))
		{
			session.setAttribute("signUpResult", "비밀번호가 불일치합니다.");
			session.setAttribute("isFailSignUp", true);
			response.sendRedirect("/Library/home/signUp");
			return;
		}
		
		MemberVO member = new MemberVO.Builder(-1)
									.pwd(mem_pwd)
									.mem_email(mem_email)
									.mem_name(mem_name)
									.lib_regi_num(lib_regi_num)
									.build();

		boolean result = false;		
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
			result = mapper.insert(member);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			if (result) {
				response.sendRedirect("/Library/home");
			} else {
				session.setAttribute("signUpResult", "이메일이 중복되었습니다.");
				session.setAttribute("isFailSignUp", true);
				response.sendRedirect("/Library/home/signUp");
			}
		}
	}

	private static void initLibrarys(HttpServletRequest request) {
		try {
			List<LibraryVO> librarys = LibraryDAO.findAllLibraryNames();
			request.setAttribute("librarys", librarys);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
