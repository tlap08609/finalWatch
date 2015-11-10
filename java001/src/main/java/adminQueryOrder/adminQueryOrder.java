package adminQueryOrder;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import regis.model.Member;
import regis.model.dao.MemberHibernateDAO;
import shoppingCart.model.Orders;
import shoppingCart.model.dao.OrderHibernateDAO;

@WebServlet("/adminQueryOrder")
public class adminQueryOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String name = request.getParameter("adminQueryMember");
//		name = new String(name.getBytes("ISO-8859-1"),"utf-8");
		OrderHibernateDAO ch = new OrderHibernateDAO();
		List<Orders> list =   ch.getAll();
		request.setAttribute("allOrder", list);
		RequestDispatcher rd = request.getRequestDispatcher
				              ("admin_manageOrder.jsp");
		rd.forward(request, response);
		return;
	}


}
