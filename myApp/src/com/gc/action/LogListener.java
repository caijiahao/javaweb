package com.gc.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class LogListener implements ApplicationListener{

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.setLenient(false);
		String currentDate = format.format(new Date());
		System.out.println("输出时间："+currentDate+" 输出内容："+event.toString());
	}

}
