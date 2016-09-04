package com.lyq;

import javax.servlet.http.HttpSessionBindingEvent;

public class UserInfoTrace implements javax.servlet.http.HttpSessionBindingListener{

	private String user;
	private UserInfoList container = UserInfoList.getInstance();
	public UserInfoTrace(){
		user="";
	}
	
	/*�������߼�����Ա*/
	public void setUser(String user){
		this.user=user;
	}
	
	/*��ȡ���߼���*/
	public String getUser(){
		return this.user;
	}
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("����" + this.user);
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("����"+this.user);
		if(user!=null){
			container.removeUserInfo(user);
		}
	}

}
