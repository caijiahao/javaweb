package com.mr;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggerExecute implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		before();
		invocation.proceed();
		return null;
	}

	//ǰ��֪ͨ
	private void before(){
		System.out.println("����ʼִ�У�");
	}

}
