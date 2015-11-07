package product.model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shoppingCart.model.ShoppingCart;

@WebServlet("/BuyBook.do")
public class BuyBookServlet extends HttpServlet {
	// 當使用者按下『加入購物車』時，瀏覽器會送出請求到本程式
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		// if (session == null) { // 使用逾時
		// request.setAttribute("Errors",
		// "使用逾時，請重新登入(BuyBookServlet:SessionTimeOut)");
		// RequestDispatcher rd =
		// request.getRequestDispatcher("/_02_login/login.jsp");
		// rd.forward(request, response);
		// return;
		// }
		/*
		 * if (session == null) { // 請使用者登入 response.sendRedirect(response
		 * .encodeRedirectURL("needLogin.jsp")); return; }
		 */
		System.out.println("hi");
		// 取出存放在session物件內的ShoppingCart物件
		ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
		// 如果找不到ShoppingCart物件
		if (cart == null) {
			// 就新建ShoppingCart物件
			cart = new ShoppingCart();
			// 將此新建ShoppingCart的物件放到session物件內
			session.setAttribute("ShoppingCart", cart);
		}
		String productNo = request.getParameter("productNo");
		String productName = request.getParameter("productName");
		String productPrice = request.getParameter("productPrice");
		String productStock = request.getParameter("productStock");
		String pageNo = request.getParameter("pageNo");
		String productContent = request.getParameter("productContent");
		String qtyStr = request.getParameter("qty");

		if (pageNo == null) {
			pageNo = "1";
		}
		int qty = 0;
		int productID = 0;
		double price = 0;
		int ps = 0;

		try {
			// 進行資料型態的轉換
			qty = Integer.parseInt(qtyStr.trim());
			productID = Integer.parseInt(productNo.trim());
			ps = Integer.parseInt(productStock.trim());
			price = Double.parseDouble(productPrice.trim());

		} catch (NumberFormatException e) {
			throw new ServletException(e);
		}
		// 將訂單資料封裝到OrderItemBean內
		OrderItemBean oi = new OrderItemBean(productID, qty, price,	productName, productContent,ps);
		// 將OrderItemBean加入ShoppingCart的物件內
		cart.addToCart(productID, oi);
		RequestDispatcher rd = request
				.getRequestDispatcher("ShowProductIndex?pageNo="
						+ pageNo);
		rd.forward(request, response);
	}
}