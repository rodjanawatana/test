package jp.co.fitec.lesson.yoneyama.web.bookstore.filter;

public class PathMatcher {

	public static boolean matches(String path) {

		if(path.matches("/index.jsp") ||
		   path.matches("/login.do") || 
		   path.startsWith("/register") ||
		   path.endsWith(".css") ||
		   path.endsWith(".gif")) {
			
				return true;
		}
		
		return false;
	}
}
