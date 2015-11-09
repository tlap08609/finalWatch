package login.filter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import regis.model.Member;
@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "mustLogin1", value = "/BuyBook.do"),
				//@WebInitParam(name = "mustLogin1", value = "/_03_listBooks/*"), 
				//@WebInitParam(name = "mustLogin2", value = "/_04_ShoppingCart/*"),
				@WebInitParam(name = "mustLogin2", value = "/service.jsp"),
				@WebInitParam(name = "mustLogin3", value = "/_05_orderProcess/*"),
				@WebInitParam(name = "mustLogin4", value = "/_20_productMaintain/*")		
		})
public class LoginFilter implements Filter {
	Collection<String> url = new ArrayList<String>();
	String servletPath;
	String contextPath;
	String requestURI;
	public void init(FilterConfig fConfig) throws ServletException {
		Enumeration<String> e = fConfig.getInitParameterNames();
		while (e.hasMoreElements()) {
			String path = e.nextElement();
			System.out.println("Filter讀到的起始參數:" + fConfig.getInitParameter(path));
			url.add(fConfig.getInitParameter(path));
		}
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		boolean isRequestedSessionIdValid = false;
		if (request instanceof HttpServletRequest
				&& response instanceof HttpServletResponse) {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			servletPath = req.getServletPath();  
			contextPath = req.getContextPath();
			requestURI  = req.getRequestURI();
			isRequestedSessionIdValid = req.isRequestedSessionIdValid();
			
			if (mustLogin()) {
				if (checkLogin(req)) {   //  需要登入，已經登入
					chain.doFilter(request, response);
				} else {				//  需要登入，尚未登入
					HttpSession session = req.getSession();
					session.setAttribute("requestURI", requestURI);
					if ( ! isRequestedSessionIdValid ) {
						session.setAttribute("timeOut", "使用逾時，請重新登入");
					}
					resp.sendRedirect("needLogin.jsp");
					return;
				}
			} else {   //不需要登入
				chain.doFilter(request, response);
			}
		} else {
			throw new ServletException("Request / Response 型態錯誤");
		}
	}
	private boolean checkLogin(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Member loginToken = (Member) session.getAttribute("LoginOK");
		if (loginToken == null) {
			return false;
		} else {
			return true;
		}
	}
	/*
	  
"/_03_listBooks/*"
"/_20_productMaintain/*"
"/_04_ShoppingCart/*"
"/_05_orderProcess/*"	

	 */

	private boolean mustLogin() {
		boolean login = false;
		for (String sURL : url) {
			if (sURL.endsWith("*")) {
				String oldURL = sURL;
				sURL = sURL.substring(0, sURL.length() - 1);
				if (servletPath.startsWith(sURL)) {
					System.out.println("ServletPath=" + servletPath + " 需要登入url=" + oldURL);
					login = true;
					break;
				}
			} else {
				if (servletPath.equals(sURL)) {
					login = true;
					break;
				}
			}
		}
		return login;
	}
	@Override
	public void destroy() {
	}
}