package com.gc.action;

import com.gc.impl.LogicInterface;

public class Logic1 implements LogicInterface{

	@Override
	public void doInsert(String name) {
		// TODO Auto-generated method stub
		System.out.println("ִ�о��帺��������ҵ���߼�....");
		for(int i = 0;i<100000000;i++){
			
		}
	}

	@Override
	public void doUpdate(String name) {
		// TODO Auto-generated method stub
		System.out.println("ִ�о��帺���޸ĵ�ҵ���߼�....");
		for(int i = 0;i<200000000;i++){
			
		}
	}

	@Override
	public void doDelete(String name) {
		// TODO Auto-generated method stub
		System.out.println("ִ�о��帺��ɾ����ҵ���߼�....");
		for(int i = 0;i<300000000;i++){
			i=i/0;
		}
	}

}
