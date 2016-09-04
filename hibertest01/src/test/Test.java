package test;


import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;

import com.db.util.HiberDBUtil;
import com.model.ClassType;
import com.model.Student;

public class Test {

	public static void main(String[] args)  {
		Session session = HiberDBUtil.getSession();
        ClassType classType1 = new ClassType();
        classType1.setC_id(100);
        classType1.setClassName("1班");
        for(int i=0;i<5;i++){
        	Student student  = new Student();
        	student.setAddress("华南农业大学");
        	student.setHobby("大炮");
        	student.setS_id(i);
        	student.setAge(10);
        	student.setName("555");
        	student.setClassType(classType1);
        	org.hibernate.Transaction tr = session.beginTransaction();
            try {
                session.save(student);
                tr.commit();
            } catch (Exception e) {
                tr.rollback();
            }finally{
               
            }
        }
        HiberDBUtil.closeSession();
        }
        }
       
	


