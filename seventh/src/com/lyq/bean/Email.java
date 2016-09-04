package com.lyq.bean;

import java.io.Serializable;

public class Email implements Serializable{

	private static final long serialVersionUID = 1L;
	//Email��ַ
	private String mailAdd;
	//�Ƿ���һ����׼��Email��ַ
	private boolean email;
	public Email(){
		
	}
	
	public Email(String mailAdd){
		this.mailAdd=mailAdd;
	}
	
	public boolean isEmail(){
		//������ʽ
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
