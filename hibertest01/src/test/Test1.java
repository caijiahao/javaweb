package test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.db.util.HiberDBUtil;
import com.model.TUser;

public class Test1 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
        set.add("华南农业大学");
        set.add("广东省东莞市");
        
        Session session = HiberDBUtil.getSession();
        Transaction ts  = session.beginTransaction();

        try {
            TUser user = new TUser();
            user.setId(2);
            user.setName("蔡家豪");
            user.setAge(20);
            user.setUserAddresses(set);
            session.save(user);
            ts.commit();
        } catch (Exception e) {
        	ts.rollback();
        } finally {
        	HiberDBUtil.closeSession();
        }
        
        session = HiberDBUtil.getSession();
        String hql = "FROM TUser t where t.id=2";
        Query query = session.createQuery(hql);
        TUser user = (TUser) query.uniqueResult();
        System.out.println(user.getName());

	}

}
