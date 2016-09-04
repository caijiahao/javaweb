package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.po.User;
import com.service.IUserService;

public class Test {

	@SuppressWarnings({ "rawtypes", "resource" })
	public static void main(String[] args) {
		User user = new User();
		user.setUsername("test");
		user.setPassword("test");
		
		User user1 = new User();
		user1.setUsername("test01");
		user1.setPassword("123456");
		
		String[] ctxs =  new String[]{"com/conf/xml/applicationContext.xml", "com/conf/xml/serviceAndDaoContext.xml"};
		 ApplicationContext cxt = new ClassPathXmlApplicationContext(ctxs);
		 IUserService uService = (IUserService)cxt.getBean("uService");

		uService.addUser(user);
		uService.addUser(user1);
		
		User user2 = uService.getUserById("test01");
		System.out.println("用户名："+user2.getUsername() +"\t密码:" + user2.getPassword());

	}

}
