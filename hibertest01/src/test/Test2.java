package test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.db.util.HiberDBUtil;
import com.model2.Subject;
import com.model2.Student;

public class Test2 {

	public static void main(String[] args) {
		Session ses = HiberDBUtil.getSession();
		
		//创建学生对象
		Student st1 = new Student();
		st1.setId("CMT1301");
		st1.setName("张三");
		st1.setAge(18);
		st1.setSex("男");
		st1.setMajor("计算机应用");
		
		//创建学生对象
		Student st2 = new Student();
		st2.setId("KJ1502");
		st2.setName("王敏");
		st2.setAge(22);
		st2.setSex("女");
		st2.setMajor("会计");
		
		//创建成绩对象
		Subject sc1 = new Subject();
		sc1.setId("JSJ003");
		sc1.setSubject("计算机基础");

		//创建成绩对象
		Subject sc2 = new Subject();
		sc2.setId("ZJ012");
		sc2.setSubject("政治经济学");

		//建立多对多关联
		st1.getSubjects().add(sc1);
		st1.getSubjects().add(sc2);
		st2.getSubjects().add(sc2);
		
		Transaction ts = ses.beginTransaction();
		//多对多必须同时对关联双方进行保存
		ses.save(st1);
		ses.save(st2);
		ses.save(sc1);
		ses.save(sc2);	
		
		ts.commit();
		HiberDBUtil.closeSession();
		HiberDBUtil.closeSessionFactory();

	}

}

