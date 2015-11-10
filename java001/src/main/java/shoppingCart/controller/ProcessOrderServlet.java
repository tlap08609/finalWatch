package shoppingCart.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import product.model.OrderItemBean;
import regis.model.Member;
import shoppingCart.model.Orders;
import shoppingCart.model.OrderItem;
import shoppingCart.model.ShoppingCart;
import shoppingCart.model.dao.OrderHibernateDAO;
import shoppingCart.model.dao.OrderItemHibernateDAO;

// OrderConfirm.jsp 呼叫本程式
@WebServlet("/ProcessOrder.do")
public class ProcessOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String finalDecision = request.getParameter("finalDecision");
		//getsession.false的意義在於不希望拿不到舊的就創新的，也就是說他只要舊的
		HttpSession session = request.getSession(false);
		if (session == null) {   // 使用逾時
			response.sendRedirect(getServletContext().getContextPath() + "/index.jsp"  );
			return;
		}
		Member mb = (Member) session.getAttribute("LoginOK");
		if (mb == null) {
			response.sendRedirect(getServletContext().getContextPath() + "/index.jsp"  );
			return;
		}
		ShoppingCart sc = (ShoppingCart) session.getAttribute("ShoppingCart");
		if (sc == null) {
			// 如果找不到購物車(通常是Session逾時)，沒有必要往下執行
			// 導向首頁
			response.sendRedirect(getServletContext().getContextPath() + "/index.jsp"  );
			return;
		}
		if  (finalDecision.equals("CANCEL")){
			session.removeAttribute("ShoppingCart");
			response.sendRedirect(response.encodeRedirectURL (request.getContextPath()));
			return;  // 一定要記得 return 
		}
		String userId = mb.getMemberName();
//		ShoppingCart sc = new ShoppingCart();
//		String userId = "紅豆餅";
		double totalAmount = Math.round(sc.getSubtotal()); 
		String shippingAddress = request.getParameter("ShippingAddress");
		String bNO = request.getParameter("BNO");
		String invoiceTitle = request.getParameter("InvoiceTitle");
		Date today = (Date)session.getAttribute("today");
		Set<OrderItem> orderitems = new HashSet<>();;
		//List<OrderItem> items = new ArrayList<OrderItem>(); 
		Map<Integer, OrderItemBean> cart = sc.getContent();
		Set<Integer> set = cart.keySet();
		//OrderItemBean ta = new OrderItemBean();
		OrderItemHibernateDAO ee = new OrderItemHibernateDAO();
		OrderItem ttr = new OrderItem();
		//ee.save(ttr);
		for (Integer k : set) {
			OrderItemBean oib = cart.get(k);
			String description = oib.getProductContent();

			//OrderItem oiDAO = new OrderItem(0, 0, oib.getProductID(),
			//		description, oib.getQty(), oib.getPrice());
			OrderItem oiDAO = new OrderItem(oib.getProductID(),
							description, oib.getQty(), oib.getPrice());
			orderitems.add(oiDAO);
		   ee.save(oiDAO);
			//ee.save(oiDAO);
		}
		//System.out.println("寫入囉");
		
		// OrderBean:封裝一筆訂單資料的容器(包含訂單主檔與訂單明細檔的資料)
//OrderBean ob = new OrderBean(userId, totalAmount, shippingAddress, 
//		bNO, invoiceTitle, today, null, items);  
		
		Orders ob = new Orders(userId, totalAmount, shippingAddress, 
				bNO, invoiceTitle, today, null,null, orderitems ); 
		OrderHibernateDAO rr = new OrderHibernateDAO();
		rr.save(ob);
		
		//rr.insertOrder(ob);
		//rr.save(ob);
//		OrderDAO order = new OrderDAO();
//		order.insertOrder(ob);
		session.removeAttribute("ShoppingCart");
		//System.out.println("訂單完成");
//		response.sendRedirect(response.encodeRedirectURL ("final.jsp"));
		response.sendRedirect("final.jsp");
	}
}