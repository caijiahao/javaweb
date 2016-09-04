package test;

import java.io.IOException;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.pojo.Computer;
import com.pojo.Person;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/cfg/applicationContext.xml");
		Computer computer = (Computer)context.getBean("Computer");
		Person person = (Person)context.getBean("Person");
		System.out.println(person.getAddress()+":"+person.getName()+":"+person.getAge());
		computer.show();
		 System.out.println("-----------------------------------读取Properties资源文件内容-----------------------------------");
			try {
				Properties props = PropertiesLoaderUtils.loadAllProperties("studentInfo.txt");
				//中文处理
				//String val = new String(props.getProperty("log4j.appender.stdout").getBytes("ISO-8859-1"),"UTF-8");
				System.out.println("id = "+props.getProperty("id"));
				String val = new String(props.getProperty("name").getBytes("ISO-8859-1"),"UTF-8");
				System.out.println("name = "+val);
				String val1 = new String(props.getProperty("age").getBytes("ISO-8859-1"),"UTF-8");
				System.out.println("age = "+val1);
				String val2 = new String(props.getProperty("hobby").getBytes("ISO-8859-1"),"UTF-8");
				System.out.println("hobby = "+val2);
				String val3 = new String(props.getProperty("score").getBytes("ISO-8859-1"),"UTF-8");
				System.out.println("score = "+val3);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
