package jp.co.fitec.lesson.yoneyama.web.bookstore.dao;

import org.hibernate.SessionFactory;

public abstract class BaseDAO {

	protected static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

}
