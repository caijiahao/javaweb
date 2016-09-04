package dao;


import org.hibernate.Query;

import org.hibernate.Session;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import entity.Seer;

public class SeerDAO extends HibernateDao<Seer>{
	
	private static final Log log = LogFactory.getLog(SeerDAO.class);

	protected void initDao() {
		// do nothing
	}
	
	public List islogin(String email,String password ){
		Session s = getSession();
		System.out.println("here");
		String hql = "select s.id from Seer as s where s.email='"+email+"' and s.password='"+password+"'";
		Query query = s.createQuery(hql);
		query = s.createQuery(hql);
		List list = query.list();
		return list;
	}	
}
