package jp.co.fitec.lesson.yoneyama.web.bookstore.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.fitec.lesson.yoneyama.web.bookstore.dao.BookDAO;
import jp.co.fitec.lesson.yoneyama.web.bookstore.entity.Book;

public class BookListAction implements Action {

	@Override
	public String doAction(HttpServletRequest request, HttpServletResponse response) 
			                              throws ServletException, IOException {
		
		BookDAO bookDao = new BookDAO();
		List<Book> bookList = bookDao.findAll();
		request.setAttribute("bookList", bookList);
		
		return "list.jsp";
	}

}
