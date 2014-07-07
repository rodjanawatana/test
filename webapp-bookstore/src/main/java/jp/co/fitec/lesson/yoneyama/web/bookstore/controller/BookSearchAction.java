package jp.co.fitec.lesson.yoneyama.web.bookstore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.fitec.lesson.yoneyama.web.bookstore.dao.BookDAO;

public class BookSearchAction implements Action {

	@Override
	public String doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String publisherCode = request.getParameter("code");
		
		BookDAO bookDao = new BookDAO();
		request.setAttribute("bookList", bookDao.findBy(isbn, title, publisherCode));
		
		return "list.jsp";
	}

}
