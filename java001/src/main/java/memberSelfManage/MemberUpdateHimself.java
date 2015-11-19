package memberSelfManage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import regis.model.Member;
import regis.model.dao.MemberHibernateDAO;


@WebServlet("/MemberUpdateHimself")
public class MemberUpdateHimself extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pswd = request.getParameter("pswd");
		String email = request.getParameter("email");
		String pk = request.getParameter("pk");
		int ipk = Integer.parseInt(pk);
		MemberHibernateDAO ms = new MemberHibernateDAO();
		Member mb = new Member(ipk,name, pswd,email);
		ms.update(mb);
		response.sendRedirect("MemberSelfManage?memberId="+ipk);
	}

}
