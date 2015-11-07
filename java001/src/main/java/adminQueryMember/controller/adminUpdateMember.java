package adminQueryMember.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import regis.model.Member;
import regis.model.dao.MemberHibernateDAO;

@WebServlet("/adminUpdateMember")
public class adminUpdateMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession hsession = request.getSession();
		Map<String, String>  errorMsg = new HashMap<>();
		hsession.setAttribute("error", errorMsg);
		String modify = request.getParameter("finalDecision");
		String pk = request.getParameter("pk");
		int ipk = Integer.parseInt(pk);
//		System.out.println(modify);
		MemberHibernateDAO ms = new MemberHibernateDAO();
		int count = 0 ;
		
		if (modify.equalsIgnoreCase("DELETE")) {
			count = ms.delete(ipk);
			if (count == 1){
				hsession.setAttribute("modify", "刪除成功");
			} else {
				hsession.setAttribute("modify", "刪除時發生異常");
			}
			
		} else if (modify.equalsIgnoreCase("UPDATE")) {
			// 1. 進行必要的資料轉換: 無
			String name = request.getParameter("name");
			String pswd = request.getParameter("pswd");
			String email = request.getParameter("email");

			
			// 2. 進行必要的資料轉換: 無

			// 3. 檢查使用者輸入資料
			if (name == null || name.trim().length() == 0) {
				errorMsg.put("name", "姓名欄必須輸入");
			}
			if (email == null || email.trim().length() == 0) {
				errorMsg.put("pswd", "密碼欄必須輸入");
			}
			
			if (!errorMsg.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("adminUpdateMember.jsp");
				rd.forward(request, response);
				return;
			}
			
			Member mb = new Member(ipk,  name, pswd,email);
			
			count = ms.update(mb);
			if (count == 1){
				hsession.setAttribute("modify", "修改成功");
			} else {
				hsession.setAttribute("modify", "修改時發生異常");
			}
		} 		
		response.sendRedirect("adminQueryMember");
	}

}
