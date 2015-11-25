package board.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.Board;
import board.model.dao.BoardHibernateDAO;

@WebServlet("/MemberWrite")
public class MemberWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberName = request.getParameter("memberName");
		String memberEmail = request.getParameter("memberEmail");
		String time = getDateTime();
		String mainText = request.getParameter("mainText");
		Board bb = new Board(memberName, memberEmail,time,mainText);
		BoardHibernateDAO bhd = new BoardHibernateDAO();
		bhd.save(bb);
		request.setAttribute("board", bb);
		RequestDispatcher rd = request
				.getRequestDispatcher("/MessangeBoard.jsp");
		rd.forward(request, response);
		return;
		

	}

	public String getDateTime() {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		// System.out.println(strDate);
		return strDate;
	}
}
