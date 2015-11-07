package adminQueryMember.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import product.model.Product;
import product.model.dao.ProductHibernateDAO;
import all.util.HibernateUtil;

@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024 * 1024 * 500 * 5)
@WebServlet("/adminUpdateProduct")
public class adminUpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession hsession = request.getSession();
		Map<String, String> errorMsg = new HashMap<>();
		hsession.setAttribute("error", errorMsg);
		String modify = request.getParameter("finalDecision");
		String pk = request.getParameter("pk");
		int ipk = Integer.parseInt(pk);
		// System.out.println("ipk:"+ipk);
		// System.out.println("modify====" + modify);
		ProductHibernateDAO ms = new ProductHibernateDAO();
		int count = 0;

		if (modify.equalsIgnoreCase("DELETE")) {
			count = ms.delete(ipk);
			if (count == 1) {
				hsession.setAttribute("modify", "刪除成功");
			} else {
				hsession.setAttribute("modify", "刪除時發生異常");
			}
			response.sendRedirect("ShowProductAdmin");

		} else if (modify.equalsIgnoreCase("UPDATE")) {
			// 1. 進行必要的資料轉換: 無
			Session session = HibernateUtil.getSessionFactory().openSession();
			ProductHibernateDAO cc = new ProductHibernateDAO();
			String pn = request.getParameter("proNam");
			String pc = request.getParameter("proCon");
			String pp = request.getParameter("proPri");
			double dpp = Double.parseDouble(pp);
			String ps = request.getParameter("proSto");
			int ips = Integer.parseInt(ps);
			Part part = request.getPart("productFile");
			// System.out.println("name=" + part.getName());
			long size = part.getSize();
			System.out.println("size=" + size);
			if (size == 0) {
//				InputStream is = part.getInputStream();
//				Blob sb = Hibernate.getLobCreator(session).createBlob(is, size);
				Product product = new Product(ipk, pn, pc, dpp, ips);
				count = cc.update(product);
			} else {
				InputStream is = part.getInputStream();
				Blob sb = Hibernate.getLobCreator(session).createBlob(is, size);
				Product product = new Product(ipk, pn, pc, dpp, ips, sb);
				count = cc.update(product);
			}
			
			
			
			
//			InputStream is = part.getInputStream();
//			Blob sb = Hibernate.getLobCreator(session).createBlob(is, size);
//			Product product = new Product(ipk, pn, pc, dpp, ips, sb);
//			count = cc.update(product);
			// cc.save(product);
			// 2. 進行必要的資料轉換: 無

			// 3. 檢查使用者輸入資料
			// if (name == null || name.trim().length() == 0) {
			// errorMsg.put("name", "姓名欄必須輸入");
			// }
			// if (email == null || email.trim().length() == 0) {
			// errorMsg.put("pswd", "密碼欄必須輸入");
			// }
			//
			if (!errorMsg.isEmpty()) {
				RequestDispatcher rd = request
						.getRequestDispatcher("ManageCart.jsp");
				rd.forward(request, response);
				return;
			}

			// Member mb = new Member(ipk, name, pswd,email);
			//

			if (count == 1) {
				hsession.setAttribute("modify", "修改成功");
			} else {
				hsession.setAttribute("modify", "修改時發生異常");
			}
			// }
			response.sendRedirect("ShowProductAdmin");
		}
	}
}
