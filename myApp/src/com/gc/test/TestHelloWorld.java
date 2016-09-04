package com.gc.test;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


import com.gc.action.HelloWorld;
import com.gc.action.Log;
import com.gc.action.LogProxy;
import com.gc.action.TimeBook;
import com.gc.action.TimeBookProxy;
import com.gc.impl.Hello;
import com.gc.impl.TimeBookInterface;

public class TestHelloWorld {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		//AbstractApplicationContext actx=new FileSystemXmlApplicationContext("/src/config.xml");
      //  Hello hello =( Hello)actx.getBean("HelloWorld");
      //  System.out.println(hello.doSalutation());
      //  HelloWorld HelloWorld =(HelloWorld) actx.getBean("HelloWorld");
        //System.out.println(HelloWorld.getMsg()+" "+HelloWorld.getDate());
        //����������ڲ�����������ִ��destroy-method�ķ�����
       // actx.registerShutdownHook();
		/*
		Object obj = Class.forName("com.gc.action.HelloWorld").newInstance();
		BeanWrapper bw = new BeanWrapperImpl(obj);
		bw.setPropertyValue("msg","HelloWorld");
		bw.setPropertyValue("date",new Date());
		System.out.println(bw.getPropertyValue("date")+" "+bw.getPropertyValue("msg"));*/
		
		//ͨ��ApplicationContext��ȡ�����ļ�
		/*ApplicationContext actx = new FileSystemXmlApplicationContext("/src/config.xml");
		//�趨��ǰʱ��
		Object[] objs = new Object[]{"HelloWorld",Calendar.getInstance().getTime()};
		//���ʻ�֧��
		String msg = actx.getMessage("HelloWorld", objs,Locale.CHINA);
		System.out.println(msg);*/
		
		/*ApplicationContext actx = new FileSystemXmlApplicationContext("/src/config.xml");
		Log log = (Log)actx.getBean("log");
		log.log("gf");*/
		
		/*LogProxy logProxy = new LogProxy();
		TimeBookInterface timeBookProxy = (TimeBookInterface)logProxy.bind(new TimeBook());
		timeBookProxy.doAuditing("����");*/
		
		ApplicationContext actx = new FileSystemXmlApplicationContext("/src/config.xml");
		TimeBookInterface timeBookProxy = (TimeBookInterface)actx.getBean("timeBook");
		timeBookProxy.doCheck("����");
	}

}
