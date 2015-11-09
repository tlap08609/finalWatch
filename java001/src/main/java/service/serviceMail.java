package service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javamail.JavaMailUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/serviceMail")
public class serviceMail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sname = request.getParameter("name");
		String semail = request.getParameter("email");
		String stime = request.getParameter("service_time");
		String spro = request.getParameter("problem");

		String from = semail;
		List<String> to = Arrays.asList(new String[] {"tlap08609@gamil.com"});
		List<String> cc = Arrays.asList(new String[] {});
		List<String> bcc = Arrays.asList(new String[] {});
		String subject = "您好，我是" + sname + "我想要維修手錶";
		String text = "<h1>我手錶有"+spro+"問題</h1>" 
		+ "<h2>我想於"+stime+"光臨敝店，請回復我是否可以</h2>"
				+ "<br><br><font color='blue'> 感謝, "
				+ "</font><br>"+sname+"敬上";
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
        return;
	}
}
