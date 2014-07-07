package jp.co.fitec.lesson.yoneyama.web.bookstore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {

	public String doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
