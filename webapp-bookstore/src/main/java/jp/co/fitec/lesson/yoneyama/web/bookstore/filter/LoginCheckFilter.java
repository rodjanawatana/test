package jp.co.fitec.lesson.yoneyama.web.bookstore.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginCheckFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			             FilterChain filterChain) throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		String servletPath = ((HttpServletRequest)request).getServletPath();
		
		if(PathMatcher.matches(servletPath) || session.getAttribute("userAccount") != null) {
			
			filterChain.doFilter (request, response);
			
		} else {
			((HttpServletResponse)response).sendRedirect("/webapp-bookstore/");
		}
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Not implements
	}

	@Override
	public void destroy() {
		// Not implements
	}
}
