package memberSelfManage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import regis.model.Member;
import regis.model.dao.MemberHibernateDAO;
import shoppingCart.model.OrderItem;
import shoppingCart.model.dao.OrderHibernateDAO;


@WebServlet("/orderDetail")
public class orderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//String memberId = request.getParameter("memberId");
		String orderNo = request.getParameter("orderNo");
		int no = Integer.parseInt(orderNo.trim());
		OrderHibernateDAO ordDAO = new OrderHibernateDAO();
		List<Object[]> od = ordDAO.getOrder(no);
		List<OrderItem> oit = new ArrayList<>();
		for(Object[] oa : od){
			oit.add((OrderItem)oa[1]);
		}
		//MemberHibernateDAO mhd = new MemberHibernateDAO();
		//long l = Long.parseLong(memberId);
		//Member mm = mhd.findByPrimaryKey(l);
		
		request.setAttribute("Order", od.get(0)[0]);
		request.setAttribute("OrderItem", oit);
		//request.setAttribute("Member", mm);
		RequestDispatcher rd = request
				.getRequestDispatcher("ShowOrderDetail.jsp");
		rd.forward(request, response);
		return;
	}

}
