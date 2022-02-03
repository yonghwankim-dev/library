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
import javax.servlet.http.HttpSession;

import member.model.dao.MemberDAO;
import member.model.vo.MemberLoginVO;
import member.model.vo.MemberLoginedVO;

@WebServlet("/home/logout")
public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("member")!=null)
		{
			session.removeAttribute("member");
		}
		response.sendRedirect("/Library/home");
	}

	
}
