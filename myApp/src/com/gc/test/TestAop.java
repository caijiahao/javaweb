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
    	   logic.doInsert("����");
    	   logic.doUpdate("����");
    	   logic.doDelete("����");
       }catch(Exception ex){
       
	}
	}
}
