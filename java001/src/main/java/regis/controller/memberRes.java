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

/**
 * Servlet implementation class Test
 */
@WebServlet("/test.do")
public class memberRes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String tt = request.getParameter("iId");
		String tt1 = request.getParameter("iPs");
		String tt2 = request.getParameter("iEmail");

		MemberHibernateDAO ch = new MemberHibernateDAO();

		Member member = new Member(1, tt, tt1, tt2);
		ch.save(member);
		// javamail
		String from = "tlap08609@gmail.com";
		List<String> to = Arrays.asList(new String[] { tt2 });
		List<String> cc = Arrays.asList(new String[] {});
		List<String> bcc = Arrays.asList(new String[] {});
		String subject = "" + tt + "您好， 歡迎加入會員";
		System.out.println(subject);
		String text = "<h1>謝謝您加入會員</h1>"
				+ "<h2>您的驗證碼為：＂java001Class＂，請將此驗證碼於登入時一同寫入，謝謝！</h2>"
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
