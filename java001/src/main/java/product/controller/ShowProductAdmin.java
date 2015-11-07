package product.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.model.Product;
import product.model.dao.ProductHibernateDAO;


@WebServlet("/ShowProductAdmin")
public class ShowProductAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ProductHibernateDAO ch = new ProductHibernateDAO();
		List<Product> list = ch.getAll();
		request.setAttribute("allProduct", list);
		RequestDispatcher rd = request.getRequestDispatcher("ManageCart.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
