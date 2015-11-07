package javamail;

import java.util.Arrays;
import java.util.List;

public class JavaMailMain {

	public static void main(String[] args) {
		String from = "tlap08609@gmail.com";
		List<String> to = Arrays.asList(
				   new String[]{"tlap086091@livemail.tw"});
		List<String> cc = Arrays.asList(
				   new String[]{});
		List<String> bcc = Arrays.asList(
				   new String[]{});
		String subject = "您好， 歡迎加入會員";
		String text = 
		  "<h1>謝謝您加入會員</h1>" +
		  "<h2>您可以按下列連結感受最新的體驗</h2>" +
	      "<a href='http://tw.yahoo.com'>yahoo</a><br>" +
	      "<a href='http://www.google.com'>google</a><br>" +
          "<br><br><font color='blue'> 再次感謝, </font><br>工作小組敬上";
		List<String> attachment = Arrays.asList(
				   new String[]{"C:\\1.jpg"
						   });;
		JavaMailUtil  util = new JavaMailUtil(from, to, cc, bcc, subject, text ,attachment);
		if (util.send()){
		   System.out.println("發信成功");
		} else {
		   System.out.println("發信失敗");
		}
	}

}
