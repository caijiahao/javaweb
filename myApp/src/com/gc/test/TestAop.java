package com.gc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.gc.impl.LogicInterface;

public class TestAop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ApplicationContext actx = new FileSystemXmlApplicationContext("/src/exception_config.xml");
       LogicInterface logic = (LogicInterface) actx.getBean("logic1");
       try{
    	   logic.doInsert("张三");
    	   logic.doUpdate("李四");
    	   logic.doDelete("王五");
       }catch(Exception ex){
       
	}
	}
}
