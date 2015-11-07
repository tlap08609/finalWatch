package regis.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adminLogin")
public class adminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

//		List<String> msg = new ArrayList<String>();
//		request.setAttribute("errMsgKey", msg);

		String adId = request.getParameter("adId");
		String adPs = request.getParameter("adPs");
		
		if (adId.equals("java001") && adPs.equals("java001")) {
//			msg.add("帳號密碼都正確！！");
			response.sendRedirect("admin_manageMember.jsp");
		} else {
//			msg.add("帳號密碼錯誤，即將導向首頁");
			response.sendRedirect("index.jsp");
		}
//		if (!msg.isEmpty()) {
//			RequestDispatcher rd = request
//					.getRequestDispatcher("checkAdmin.jsp");
//			rd.forward(request, response);
//			return;
//
//		}

	}

}
