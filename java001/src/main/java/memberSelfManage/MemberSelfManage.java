package memberSelfManage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import regis.model.Member;
import regis.model.dao.MemberHibernateDAO;


@WebServlet("/MemberSelfManage")
public class MemberSelfManage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		MemberHibernateDAO mhd = new MemberHibernateDAO();
		long l = Long.parseLong(memberId);
		Member mm = mhd.findByPrimaryKey(l);
		request.setAttribute("Member", mm);
		RequestDispatcher rd = request
				.getRequestDispatcher("memberSelfManage.jsp");
		rd.forward(request, response);
		return;
		
	}

}
