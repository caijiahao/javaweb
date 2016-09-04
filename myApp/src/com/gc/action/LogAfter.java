package com.gc.action;

import java.lang.reflect.Method;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

public class LogAfter implements AfterReturningAdvice{

	private Logger logger = Logger.getLogger(this.getClass().getName());
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		// TODO Auto-generated method stub
		logger.log(Level.INFO, arg2[0]+"审核数据完成...");
	}

}
