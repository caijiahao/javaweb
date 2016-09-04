package com.lyq.bean;

import java.io.Serializable;

public class Email implements Serializable{

	private static final long serialVersionUID = 1L;
	//Email地址
	private String mailAdd;
	//是否是一个标准的Email地址
	private boolean email;
	public Email(){
		
	}
	
	public Email(String mailAdd){
		this.mailAdd=mailAdd;
	}
	
	public boolean isEmail(){
		//正则表达式
		String regex ="\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		if(mailAdd.matches(regex)){
			email=true;
		}
		return email;
	}
	
	public String getMailAdd(){
		return mailAdd;
	}
	
	public void setMailAdd(String mailAdd){
		this.mailAdd = mailAdd;
	}
}
