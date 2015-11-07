package adminQueryProduct;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.model.Product;
import product.model.dao.ProductHibernateDAO;
import regis.model.Member;
import regis.model.dao.MemberHibernateDAO;


@WebServlet("/findProduct.do")
public class FindProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String key = request.getParameter("key");
		int ipk = Integer.parseInt(key);
		ProductHibernateDAO ch = new ProductHibernateDAO();
		Product pro = ch.findByPrimaryKey(ipk);
		request.setAttribute("pro", pro);
		RequestDispatcher rd = request.getRequestDispatcher("adminUpdateProduct.jsp");
		rd.forward(request, response);
		return;
	}
}
