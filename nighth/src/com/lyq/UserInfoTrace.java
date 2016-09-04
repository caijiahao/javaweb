package com.lyq;

import javax.servlet.http.HttpSessionBindingEvent;

public class UserInfoTrace implements javax.servlet.http.HttpSessionBindingListener{

	private String user;
	private UserInfoList container = UserInfoList.getInstance();
	public UserInfoTrace(){
		user="";
	}
	
	/*设置在线监听人员*/
	public void setUser(String user){
		this.user=user;
	}
	
	/*获取在线监听*/
	public String getUser(){
		return this.user;
	}
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("上线" + this.user);
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("下线"+this.user);
		if(user!=null){
			container.removeUserInfo(user);
		}
	}

}
