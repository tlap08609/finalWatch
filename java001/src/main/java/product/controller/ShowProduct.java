package product.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.model.Product;
import product.model.dao.ProductHibernateDAO;


@WebServlet("/ShowProductIndex")
public class ShowProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	int pageNo = 1;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		ProductHibernateDAO ch = new ProductHibernateDAO();
//		List<Product> list = ch.getAll();
//		request.setAttribute("allProduct", list);
		try {
			String pageNoStr = request.getParameter("pageNo");
			if (pageNoStr == null) {
				ProductHibernateDAO.pageNo = 1;
//				Cookie[] cookies = request.getCookies();
//				if (cookies != null) {
//					for (Cookie c : cookies) {
//						//System.out.println("getName=" + c.getName());
//						if (c.getName().equals(memberId + "pageNo")) {
//
//							try {
//								pageNo = Integer.parseInt(c.getValue().trim());
//							} catch (NumberFormatException e) {
//								;
//							}
//							break;
//						}
//					}
//				}
			} else {
				try {
					ProductHibernateDAO.pageNo = Integer.parseInt(pageNoStr.trim());
				} catch (NumberFormatException e) {
					ProductHibernateDAO.pageNo = 1;
				}
			}
		
		ProductHibernateDAO pd = new ProductHibernateDAO();
		List<Product> lp = pd.getPageBooks();
//		int tt  = pd.setPageNo(pageNo);
//		System.out.println("tt   "+tt);
//		pd.setRecordsPerPage(ProductHibernateDAO.recordsPerPage);
		request.setAttribute("pageNo", ProductHibernateDAO.pageNo);
		request.setAttribute("totalPages", pd.getTotalPages());
		request.setAttribute("recordsPerPage",
				ProductHibernateDAO.recordsPerPage);
		request.setAttribute("products_lp", lp);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("showCart.jsp");
		rd.forward(request, response);
		return;
	} catch (SQLException e) {
//		System.out.println("is this?");
		e.printStackTrace();
	}
	
}
}
