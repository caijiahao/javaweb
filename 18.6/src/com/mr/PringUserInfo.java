package com.mr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PringUserInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");//◊∞‘ÿ≈‰÷√Œƒº˛
     UserInfo ui = (UserInfo) context.getBean("user1");
     ui.printInfo();
	}

}
