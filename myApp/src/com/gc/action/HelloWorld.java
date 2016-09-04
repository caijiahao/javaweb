package com.gc.action;

import java.util.Date;

public class HelloWorld {

	public String msg = null;
	
	public Date date = null;

	public HelloWorld(){
		
	}
	public void init(){
		this.msg = "HelloWorld";
		this.date = new Date();
	}
	
	//Ïú»Ù
	public void cleanup(){
		this.msg="";
		this.date=null;
		System.out.println("ÄúÏú»ÙÁË");
	}
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}


	
	
}
