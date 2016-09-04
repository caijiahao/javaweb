package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.po.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IUserService;

public class loginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private HttpServletRequest request;
	private HttpSession session;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public loginAction() {
		request=ServletActionContext.getRequest();
    	session=request.getSession();
	}

	@Override
	public String execute(){
		String[] ctxs =  new String[]{"com/conf/xml/applicationContext.xml", "com/conf/xml/serviceAndDaoContext.xml"};
		 ApplicationContext cxt = new ClassPathXmlApplicationContext(ctxs);
		 IUserService uService = (IUserService)cxt.getBean("uService");
		 User user = null;
		 user = uService.getUserById(username);
		 if(user!=null&&user.getPassword().equals(password)){
			 session.putValue("user",user);
			 return "success";
		 }
		 else{
		 return "error";
		 }
		
	}
	
	@Override
	public void validate() {
		if(username.trim().equals("")||username==null){
			this.addFieldError("userName", "用户名不为空");
		}
		if(password.trim().equals("")||password==null){
			this.addFieldError("password", "密码不为空");
		}

	}

}
