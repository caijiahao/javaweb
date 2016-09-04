package com.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.User;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpSession session;
	private ServletContext application;

	private User user;
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public LoginAction(){
		request=ServletActionContext.getRequest();
		session=request.getSession();
		application=session.getServletContext();

	}
	@Override
	public String execute(){
		if("user".equals(user.getUserName())&&"123456".equals(user.getPassWord())){
			return "success";
		}else{
			return "error";
		}
	}
	
}
