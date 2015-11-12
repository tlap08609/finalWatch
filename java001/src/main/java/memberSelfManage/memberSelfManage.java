package memberSelfManage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoppingCart.model.Orders;
import shoppingCart.model.dao.OrderHibernateDAO;


@WebServlet("/memberSelfManage")
public class memberSelfManage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String orderNo = request.getParameter("orderNo");
		int no = Integer.parseInt(orderNo.trim());
		OrderHibernateDAO ordDAO = new OrderHibernateDAO();
		List<Orders> ob = ordDAO.getOrder(no);
		request.setAttribute("OrderBean", ob);
		RequestDispatcher rd = request
				.getRequestDispatcher("ShowOrderDetail.jsp");
		rd.forward(request, response);
		return;
	}

}
