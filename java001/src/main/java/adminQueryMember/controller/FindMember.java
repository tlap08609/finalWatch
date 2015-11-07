package adminQueryMember.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import regis.model.Member;
import regis.model.dao.MemberHibernateDAO;


@WebServlet("/findMember.do")
public class FindMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String key = request.getParameter("key");
		int ipk = Integer.parseInt(key);
		MemberHibernateDAO ch = new MemberHibernateDAO();
		Member mb = ch.findByPrimaryKey(ipk);
		request.setAttribute("mb", mb);
		RequestDispatcher rd = request.getRequestDispatcher("adminUpdateMember.jsp");
		rd.forward(request, response);
		return;
	}
}
