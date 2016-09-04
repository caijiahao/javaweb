package com.gc.action;

import java.lang.reflect.Method;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class LogBefore implements MethodBeforeAdvice{
   private Logger logger = Logger.getLogger(this.getClass().getName());

@Override
public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
	// TODO Auto-generated method stub
	logger.log(Level.INFO, arg1[0]+"开始审核数据");
}
   
}
