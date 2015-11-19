package regis.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javamail.JavaMailUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import regis.model.Member;
import regis.model.dao.MemberHibernateDAO;

@WebServlet("/Forgetpassword")
public class Forgetpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String fId = request.getParameter("fId");
		String fEmail = request.getParameter("fEmail");

		MemberHibernateDAO dd = new MemberHibernateDAO();
		List<Member> dd1 = dd
				.findMemPs("select memberPs from Member where memberName='"
						+ fId + "'");
		// javamail
		String from = "tlap08609@gmail.com";
		List<String> to = Arrays.asList(new String[] { fEmail });
		List<String> cc = Arrays.asList(new String[] {});
		List<String> bcc = Arrays.asList(new String[] {});
		String subject = "" + fId + "您好，我們是MS機械錶，此封信有你的密碼，請小心保存";
		String text = "<h1>謝謝您的來信詢問密碼事宜，</h1>"
				+ "<h2>您的密碼為："+dd1.get(0)+"，請將此密碼寫入你的登入訊息，謝謝！</h2>"
				+ "<br><br><font color='blue'> 再次感謝, "
				+ "</font><br>MS機械錶專賣店敬上";
		List<String> attachment = Arrays.asList(new String[] {});
		;
		JavaMailUtil util1 = new JavaMailUtil(from, to, cc, bcc, subject, text,
				attachment);
		if (util1.send()) {
			System.out.println("發信成功");
		} else {
			System.out.println("發信失敗");
		}
		response.sendRedirect("index.jsp");
	}

}
