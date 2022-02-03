package member.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.dao.MemberDAO;
import member.model.vo.MemberLoginVO;
import member.model.vo.MemberLoginedVO;

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
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/views/member/login.jsp");
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
