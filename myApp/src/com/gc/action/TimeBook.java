package com.gc.action;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.gc.impl.TimeBookInterface;

public class TimeBook implements TimeBookInterface{

	
	
	public void doAuditing(String name){
	System.out.println("������ݵ���س�������ִ�С�����");
	}

	@Override
	public void doCheck(String name) {
		// TODO Auto-generated method stub
		System.out.println("������ʵ���س�������ִ��....");
	}
}
