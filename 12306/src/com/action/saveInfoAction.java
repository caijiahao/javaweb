package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.po.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IUserService;

public class saveInfoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String realname;
	private Integer sex;
	private Integer certType;
    private Integer touristType;
    private String streetexplicit;
    private String sourcepassword;
    private String newPassword;
    private String cert;
    
    private HttpServletRequest request;
	private HttpSession session;
	
	public String getCert() {
		return cert;
	}
	public void setCert(String cert) {
		this.cert = cert;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getCertType() {
		return certType;
	}
	public void setCertType(Integer certType) {
		this.certType = certType;
	}
	public Integer getTouristType() {
		return touristType;
	}
	public void setTouristType(Integer touristType) {
		this.touristType = touristType;
	}
	public String getStreetexplicit() {
		return streetexplicit;
	}
	public void setStreetexplicit(String streetexplicit) {
		this.streetexplicit = streetexplicit;
	}
	public String getSourcepassword() {
		return sourcepassword;
	}
	public void setSourcepassword(String sourcepassword) {
		this.sourcepassword = sourcepassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
    
	public saveInfoAction(){
		request=ServletActionContext.getRequest();
    	session=request.getSession();
	}
	@Override
	public String execute(){
		String[] ctxs =  new String[]{"com/conf/xml/applicationContext.xml", "com/conf/xml/serviceAndDaoContext.xml"};
		 ApplicationContext cxt = new ClassPathXmlApplicationContext(ctxs);
		 IUserService uService = (IUserService)cxt.getBean("uService");
		 User user = null;
		 user = (User)session.getAttribute("user");
		 if(user.getPassword().equals(sourcepassword)){
		 user.setAddress(streetexplicit);
		 user.setRealname(realname);
		 user.setSex(sex);
		 user.setTouristType(touristType);
		 user.setPassword(newPassword);
		 user.setCertificateType(certType);
		 user.setCertificateNumber(cert);
		 uService.updateUser(user);
		 session.putValue("user", user);
		 return "success";
		 }else{
			 return "error";
		 }
		
	}
}
