package com.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.po.User;
import com.service.IUserService;
import com.service.impl.UserService;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private HttpServletRequest request;
	private HttpSession session;


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

    public LoginAction(){
    	request=ServletActionContext.getRequest();
    	session=request.getSession();
  

    }
	@SuppressWarnings("deprecation")
	@Override
	public String execute(){
		boolean flg = false;
		IUserService uService = new UserService();
		flg = uService.getLoginState(user);
		if(flg){
			 session.putValue("user",user);
			return "success";
		}else{
			return "error";
		}
	}
	
	@Override
	public void validate() {
		if(user.getUserName().trim().equals("")||user.getUserName()==null){
			this.addFieldError("user.userName", "用户名不能为空");
		}

	}
}
