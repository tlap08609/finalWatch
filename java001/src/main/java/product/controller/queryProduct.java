package product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableInterceptor.ForwardRequest;

import product.model.Product;
import product.model.dao.ProductHibernateDAO;


@WebServlet("/queryProduct")
public class queryProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String word = request.getParameter("word");
		ProductHibernateDAO queryProductName = new ProductHibernateDAO();
		List<Product> list= queryProductName.queryProduct(word);
		request.setAttribute("products_lp", list);
		RequestDispatcher rd = request.getRequestDispatcher("/showCart.jsp");
			rd.forward(request, response);
			return;
	}

}
