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

	//前置通知
	private void before(){
		System.out.println("程序开始执行！");
	}

}
