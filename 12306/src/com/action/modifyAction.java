package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.po.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IUserService;

public class modifyAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpSession session;
	public modifyAction(){
		request=ServletActionContext.getRequest();
    	session=request.getSession();
	}
	@Override
	public String execute(){
		User user = (User)session.getValue("user");
		if(user ==null){
			return "error";
		}else{
			return "success";
		}
	}

}
