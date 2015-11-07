package login.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import regis.model.Member;
import regis.model.dao.MemberHibernateDAO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userId = request.getParameter("userId");
		String password = request.getParameter("pswd");
		String rm = request.getParameter("rememberMe");
		String requestURI = (String) session.getAttribute("requestURI");
		// System.out.println("requestURI" + requestURI);

		// **********Remember Me****************************
		Cookie cookieUser = null;
		Cookie cookiePassword = null;
		Cookie cookieRememberMe = null;

		if (rm != null) { // rm存放瀏覽器送來之RememberMe的選項
			// Cookie cookie = new Cookie(name, URLEncoder.encode(value,
			// "UTF-8"));
			// String value = URLDecoder.decode(cookie.getValue(), "UTF-8");

			// cookieUser = new Cookie("user", userId);
			cookieUser = new Cookie("user", URLEncoder.encode(userId, "UTF-8"));
			String value = URLDecoder.decode(cookieUser.getValue(), "UTF-8");
			session.setAttribute("user", value);
			// session.setAttribute("user", URLEncoder.encode(userId, "UTF-8"));
			cookieUser.setMaxAge(30 * 60 * 60);
			cookieUser.setPath(request.getContextPath());
			// 稍微編碼(不算是加密)
			String encodePassword = DatatypeConverter
					.printBase64Binary(password.getBytes());
			cookiePassword = new Cookie("password", encodePassword);
			cookiePassword.setMaxAge(30 * 60 * 60);
			cookiePassword.setPath(request.getContextPath());
			cookieRememberMe = new Cookie("rm", "true");
			cookieRememberMe.setMaxAge(30 * 60 * 60);
			cookieRememberMe.setPath(request.getContextPath());
		} else {
			// cookieUser = new Cookie("user", userId);
			cookieUser = new Cookie("user", URLEncoder.encode(userId, "UTF-8"));
			String value = URLDecoder.decode(cookieUser.getValue(), "UTF-8");
			session.setAttribute("user", value);
			cookieUser.setMaxAge(0); // MaxAge==0 表示要請瀏覽器刪除此Cookie
			cookieUser.setPath(request.getContextPath());
			String encodePassword = DatatypeConverter
					.printBase64Binary(password.getBytes());
			cookiePassword = new Cookie("password", encodePassword);
			cookiePassword.setMaxAge(0);
			cookiePassword.setPath(request.getContextPath());
			cookieRememberMe = new Cookie("rm", "false");
			cookieRememberMe.setMaxAge(30 * 60 * 60);
			cookieRememberMe.setPath(request.getContextPath());
		}
		response.addCookie(cookieUser);
		response.addCookie(cookiePassword);
		response.addCookie(cookieRememberMe);
		// ********************************************
		// 4. 進行 Business Logic 運算
		// 將LoginServiceDB類別new為物件，存放物件參考的變數為 lsdb
		MemberHibernateDAO lsdb = new MemberHibernateDAO();
		lsdb.checkid();
		// MemberHibernateDAO lsdb1= new MemberHibernateDAO();
		// 呼叫 ms物件的 checkIDPassword()，要記得傳入userid與password兩個參數
		Member mb = lsdb.checkIDPassword(userId, password);
		if (mb != null) {
			// OK, 將mb物件放入Session範圍內，識別字串為"LoginOK"
			request.setAttribute("userId", userId);
			session.setAttribute("LoginOK", mb);
			response.sendRedirect("index.jsp");
		} else {
			// NG, userid與密碼的組合錯誤，放一個錯誤訊息到 errorMsgMap 之內
			response.sendRedirect("needLogin.jsp");
			// Boolean tt = lsdb.idExists(userId);

			// System.out.println("tt的值： "+tt);
			// if (tt) {
			// OK, 將mb物件放入Session範圍內，識別字串為"LoginOK"
			// int ipk = Integer.parseInt(userId);
			// Member indexMb = lsdb.findByPrimaryKey(1);

			// RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			// rd.forward(request, response);
			//
			//
			// return;
			// response.sendRedirect("index.jsp");

			// } else {
			// response.sendRedirect("loginWrong.jsp");
			// }

			// 5.依照 Business Logic 運算結果來挑選適當的畫面
			// 如果 errorMsgMap 是空的，表示沒有任何錯誤，交棒給下一棒

			// 此時不要用下面兩個敘述，因為網址列的URL不會改變
			// RequestDispatcher rd = request.getRequestDispatcher("...");
			// rd.forward(request, response);
			// if (requestURI != null) {
			// requestURI = (requestURI.length() == 0 ? request.getContextPath()
			// : requestURI);
			// response.sendRedirect(response.encodeRedirectURL(requestURI));
			// System.out.println("if:" +
			// response.encodeRedirectURL(requestURI));
			// return;
			// } else {
			// response.sendRedirect(response.encodeRedirectURL(request
			// .getContextPath()));
			// System.out.println("else:"+response.encodeRedirectURL(request
			// .getContextPath()));
			// return;
			// }

			// }
		}
	}
}
