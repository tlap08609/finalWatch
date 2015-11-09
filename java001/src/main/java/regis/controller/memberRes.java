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
import all.util.Encrypt;

/**
 * Servlet implementation class Test
 */
@WebServlet("/test.do")
public class memberRes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String iId = request.getParameter("iId");
		String iPs = request.getParameter("iPs");
		String iEmail = request.getParameter("iEmail");

		MemberHibernateDAO ch = new MemberHibernateDAO();
		//System.out.println("iPs:"+iPs);
		String encrypedString = Encrypt.encryptString(iPs);
		String eIps = Encrypt.getMD5Endocing(encrypedString);
		System.out.println("eips:"+eIps);
		Member member = new Member(1, iId, eIps, iEmail);
		ch.save(member);
		// javamail
		String from = "tlap08609@gmail.com";
		List<String> to = Arrays.asList(new String[] { iEmail });
		List<String> cc = Arrays.asList(new String[] {});
		List<String> bcc = Arrays.asList(new String[] {});
		String subject = "" + iId + "您好， 歡迎加入會員";
		//System.out.println(subject);
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
