package ajax.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class UpdateUsername
 */
@WebServlet("/update")
public class UpdateUsername extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateUsername() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("stop");
		Map<String, Object> map = new HashMap<String,Object>();
		boolean isValid = false;
		String username = request.getParameter("username");
		System.out.println(username);
		if(username !=null && username.trim().length()!=0){
			isValid = true;
			map.put("username", username);
		}
		map.put("isValid", isValid);
		write(response,map);
		}

	private void write(HttpServletResponse response, Map<String, Object> map) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(map));
		
	}
}
