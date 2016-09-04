package com.gc.action;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class TimeHandler implements MethodInterceptor{
	 private Logger logger = Logger.getLogger(this.getClass().getName());
	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		// TODO Auto-generated method stub
		long procTime = System.currentTimeMillis();
		logger.log(Level.INFO, arg0.getArguments()[0] + " 开始执行    "+arg0.getMethod() + " 方法");
		try{
			Object result =arg0.proceed();
			return result;
		}finally{
			procTime = System.currentTimeMillis()-procTime;
			logger.log(Level.INFO, arg0.getArguments()[0] + " 开始执行   " + arg0.getMethod() + " 方法结束");
	        logger.log(Level.INFO, "执行"+arg0.getMethod().getName() + " 方法共用了" + procTime + "毫秒");
		}
	}

}
