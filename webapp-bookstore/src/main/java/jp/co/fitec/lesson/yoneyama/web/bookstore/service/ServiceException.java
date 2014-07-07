package jp.co.fitec.lesson.yoneyama.web.bookstore.service;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -4466702483763022333L;

	public ServiceException(Exception e) {
		super(e);
	}
}
