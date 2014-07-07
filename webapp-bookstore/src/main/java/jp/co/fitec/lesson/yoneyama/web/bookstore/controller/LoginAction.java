package jp.co.fitec.lesson.yoneyama.web.bookstore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.fitec.lesson.yoneyama.web.bookstore.entity.UserAccount;
import jp.co.fitec.lesson.yoneyama.web.bookstore.service.Authenticator;

public class LoginAction implements Action {

	public String doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserAccount userAccount = Authenticator.authenticate(email, password);
	
		if(userAccount != null) { // 認証成功時の処理
			
			HttpSession session = request.getSession();
			session.setAttribute("userAccount", userAccount);
			
			response.sendRedirect("book/list.do");
			return null;
			
		} else { // 認証失敗時の処理

			request.setAttribute("message", "Incorrect email or password.");
			return "/";
		}
		
	}

}
