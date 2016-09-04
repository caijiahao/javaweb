package com.gc.action;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LogAround implements MethodInterceptor{
	private Logger logger = Logger.getLogger(this.getClass().getName());
	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		// TODO Auto-generated method stub
	    logger.log(Level.INFO, arg0.getArguments()[0]+" 开始审核数据.....");
	    try{
	    	Object result = arg0.proceed();
	    	return result;
	    }
	    finally{
	    	logger.log(Level.INFO, arg0.getArguments()[0]+" 审核数据结束.....");
	    }
	}

}
