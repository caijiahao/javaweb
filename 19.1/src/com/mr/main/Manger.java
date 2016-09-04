package com.mr.main;            //�ǵ�����Ŀ�е���spring-core-3.2.0jar

import org.springframework.aop.framework.ProxyFactory;

import com.mr.LoggerExecute;
import com.mr.Target;

public class Manger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Target target = new Target();
		ProxyFactory di = new ProxyFactory();
		di.addAdvice(new LoggerExecute());
		di.setTarget(target);
		Target proxy = (Target)di.getProxy();
		proxy.execute("AOP�ļ�ʵ��");
	}

}
