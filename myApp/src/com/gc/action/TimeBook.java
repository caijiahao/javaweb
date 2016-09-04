package com.gc.action;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.gc.impl.TimeBookInterface;

public class TimeBook implements TimeBookInterface{

	
	
	public void doAuditing(String name){
	System.out.println("审核数据的相关程序正在执行。。。");
	}

	@Override
	public void doCheck(String name) {
		// TODO Auto-generated method stub
		System.out.println("财务关帐的相关程序正在执行....");
	}
}
