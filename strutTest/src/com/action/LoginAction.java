package com.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction  extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String userName;
	private String pwd;
	private String smallName;
	private String tip;
	private String phone;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	public String getSmallName() {
		return smallName;
	}
	public void setSmallName(String smallName) {
		this.smallName = smallName;
	}
	
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String execute(){
		if("userName".equals(userName)&&"123456".equals(pwd))
			   return SUCCESS;
		else
			   return ERROR;
	}

	
	/*@Override
	public void validate(){
		
		if(userName.trim().equals("") || userName==null)
		{
			this.addFieldError("userName", "账号不能为空");
		}
		if(pwd.trim().equals("") || pwd==null)
		{
			this.addFieldError("pwd", "密码不能为空");
		}
		if(pwd.trim().getBytes().length<6||pwd.trim().getBytes().length>15){
			this.addFieldError("pwd", "密码长度为6-15位");
		}
		if(userName.trim().getBytes().length<6||userName.trim().getBytes().length>15){
			this.addFieldError("userName", "账号长度为6-15");
		}
		if(smallName.trim().equals("") || smallName==null)
		{
			this.addFieldError("smallName", "昵称不能为空");
		}
		if(smallName.trim().getBytes().length<6||smallName.trim().getBytes().length>15){
			this.addFieldError("smallName", "昵称长度为6-15");
		}
		if(tip.trim().equals("") || tip == null){
			this.addFieldError("tip", "提示不能为空");
		}
		if(tip.trim().getBytes().length<10||tip.trim().getBytes().length>30){
			this.addFieldError("tip", "提示长度为10-30位");
		}
	}*/
}
