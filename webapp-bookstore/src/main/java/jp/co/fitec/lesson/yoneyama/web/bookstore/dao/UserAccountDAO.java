package jp.co.fitec.lesson.yoneyama.web.bookstore.dao;


import jp.co.fitec.lesson.yoneyama.web.bookstore.entity.UserAccount;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UserAccountDAO extends BaseDAO {

	public UserAccount findBy(String email, String password) {

		Session session = sessionFactory.getCurrentSession();

		return (UserAccount)session.createCriteria(UserAccount.class)
				.add(Restrictions.eq("email", email))
				.add(Restrictions.eq("password", password))
				.uniqueResult();
	}
	
	public UserAccount findBy(String email) {
		
		return (UserAccount)sessionFactory.getCurrentSession()
					.get(UserAccount.class, email);
	}

	public static void insert(UserAccount userAccount) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(userAccount);
	}
}
