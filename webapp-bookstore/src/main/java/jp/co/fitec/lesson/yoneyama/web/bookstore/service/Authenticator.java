package jp.co.fitec.lesson.yoneyama.web.bookstore.service;

import jp.co.fitec.lesson.yoneyama.web.bookstore.dao.UserAccountDAO;
import jp.co.fitec.lesson.yoneyama.web.bookstore.entity.UserAccount;

public class Authenticator {

	public static UserAccount authenticate(String userName, String password) {
		
		return new UserAccountDAO().findBy(userName, password);
	}
}
