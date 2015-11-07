package product.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import product.model.Product;
import product.model.dao.ProductHibernateDAO;
import all.util.HibernateUtil;
@MultipartConfig(location = "", 
fileSizeThreshold = 1024 * 1024, 
maxFileSize = 1024 * 1024 * 500, 
maxRequestSize = 1024 * 1024 * 500 * 5)

@WebServlet("/add.do")
public class porductAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ProductHibernateDAO cc = new ProductHibernateDAO();
		request.setCharacterEncoding("utf-8");
		String pn = request.getParameter("proNam");
		String pc = request.getParameter("proCon");
		String pp = request.getParameter("proPri");
		double dpp = Double.parseDouble(pp);
		String ps = request.getParameter("proSto");
		int ips = Integer.parseInt(ps);
		
		Part part = request.getPart("productFile");
		long size = part.getSize(); 
		InputStream is =part.getInputStream();
		Blob sb = Hibernate.getLobCreator(session).
				createBlob(is, size);
		Product product = new Product(1, pn, pc, 
				dpp, ips, sb);
		cc.save(product);
		response.sendRedirect("ShowProductAdmin");
		
	}

}
