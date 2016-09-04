package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.db.util.HiberDBUtil;
import com.model.Power;
import com.model.Role;

public class Test2 {

	public static void main(String[] args) {
		Session ses = HiberDBUtil.getSession();
		
		//鍒涘缓瀛︾敓瀵硅薄
		Role superRole  = new Role();
		superRole.setId("1");
		superRole.setIntroduction("超级用户");
		superRole.setName("超级用户");
		//鍒涘缓瀛︾敓瀵硅薄
		Role normalRole = new Role();
		normalRole.setId("2");
		normalRole.setIntroduction("普通用户");
		normalRole.setName("普通用户");
		
		Power add = new Power();
		add.setId("1");
		add.setIntroduction("添加数据");
		add.setName("添加数据");
		
		Power delete = new Power();
		delete.setId("2");
		delete.setIntroduction("删除数据");
		delete.setName("删除数据");
		
		Power read = new Power();
		read.setId("3");
		read.setIntroduction("读取数据");
		read.setName("读取数据");
		
		Power file = new Power();
		file.setId("4");
		file.setIntroduction("文件操作");
		file.setName("文件操作");
		
		Power modify = new Power();
		modify.setId("5");
		modify.setIntroduction("修改数据");
		modify.setName("修改数据");
		
		superRole.getPowers().add(add);
		superRole.getPowers().add(delete);
		superRole.getPowers().add(modify);
		superRole.getPowers().add(read);
		superRole.getPowers().add(file);
		
		
		normalRole.getPowers().add(file);
		normalRole.getPowers().add(read);
		Transaction ts = ses.beginTransaction();
		//澶氬澶氬繀椤诲悓鏃跺鍏宠仈鍙屾柟杩涜淇濆瓨
		
		
		ses.save(superRole);
		ses.save(normalRole);
		
		ses.save(add);
		ses.save(delete);
		ses.save(modify);
		ses.save(read);
		ses.save(file);
		
			
		
		ts.commit();
		
		 Query query = ses.createQuery("FROM Role");
		 List<Role> roles = query.list();
		 for(Role role :roles){
			 System.out.println(role.getId()+":"+role.getName()+":"+role.getIntroduction());
		 }
		 HiberDBUtil.closeSession();
		HiberDBUtil.closeSessionFactory();

	}

}

