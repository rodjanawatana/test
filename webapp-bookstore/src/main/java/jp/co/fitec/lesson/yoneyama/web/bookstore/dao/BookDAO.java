package jp.co.fitec.lesson.yoneyama.web.bookstore.dao;

import java.util.List;

import jp.co.fitec.lesson.yoneyama.web.bookstore.entity.Book;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class BookDAO extends BaseDAO {

	public List<Book> findAll() {
		
		return findBy(null, null, null);
	}
	
	public List<Book> findBy(String isbn, String title, String publisherCode) {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Book.class);
		
		if(StringUtils.isNotBlank(isbn)) {
			criteria.add(Restrictions.like("isbn", isbn, MatchMode.ANYWHERE));
		}
		
		if(StringUtils.isNotBlank(title)) {
			criteria.add(Restrictions.like("title", title, MatchMode.ANYWHERE));
		}
		
		if(StringUtils.isNotBlank(publisherCode)) {
			criteria.add(Restrictions.eq("publisher.code", publisherCode));
		}
		
		return criteria.list();
	}
}
