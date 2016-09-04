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
		
		//创建学生对象
		Role superRole  = new Role();
		superRole.setId("1");
		superRole.setIntroduction("�����û�");
		superRole.setName("�����û�");
		//创建学生对象
		Role normalRole = new Role();
		normalRole.setId("2");
		normalRole.setIntroduction("��ͨ�û�");
		normalRole.setName("��ͨ�û�");
		
		Power add = new Power();
		add.setId("1");
		add.setIntroduction("�������");
		add.setName("�������");
		
		Power delete = new Power();
		delete.setId("2");
		delete.setIntroduction("ɾ������");
		delete.setName("ɾ������");
		
		Power read = new Power();
		read.setId("3");
		read.setIntroduction("��ȡ����");
		read.setName("��ȡ����");
		
		Power file = new Power();
		file.setId("4");
		file.setIntroduction("�ļ�����");
		file.setName("�ļ�����");
		
		Power modify = new Power();
		modify.setId("5");
		modify.setIntroduction("�޸�����");
		modify.setName("�޸�����");
		
		superRole.getPowers().add(add);
		superRole.getPowers().add(delete);
		superRole.getPowers().add(modify);
		superRole.getPowers().add(read);
		superRole.getPowers().add(file);
		
		
		normalRole.getPowers().add(file);
		normalRole.getPowers().add(read);
		Transaction ts = ses.beginTransaction();
		//多对多必须同时对关联双方进行保存
		
		
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

