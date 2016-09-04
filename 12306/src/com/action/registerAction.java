package com.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.po.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IUserService;

public class registerAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String password2;
	private String realname;
	private Integer sex;
	private String province;
	private String city;
	private Integer certType;
	private String cert;
	private String  birthday;
	private Integer userType;
	private String content;
	
	
	
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



	public String getPassword2() {
		return password2;
	}



	public void setPassword2(String password2) {
		this.password2 = password2;
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



	public String getProvince() {
		return province;
	}



	public void setProvince(String province) {
		this.province = province;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public Integer getCertType() {
		return certType;
	}



	public void setCertType(Integer certType) {
		this.certType = certType;
	}



	public String getCert() {
		return cert;
	}



	public void setCert(String cert) {
		this.cert = cert;
	}



	public String getBirthday() {
		return birthday;
	}



	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}



	public Integer getUserType() {
		return userType;
	}



	public void setUserType(Integer userType) {
		this.userType = userType;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	@Override
	public String execute() throws ParseException{
		String[] ctxs =  new String[]{"com/conf/xml/applicationContext.xml", "com/conf/xml/serviceAndDaoContext.xml"};
		 ApplicationContext cxt = new ClassPathXmlApplicationContext(ctxs);
		 IUserService uService = (IUserService)cxt.getBean("uService");
		 User user = new User();
		 user.setAddress(province+city);
		 SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd" );
		 System.out.println(birthday);
		 user.setBirthday(sdf.parse(birthday));
		 user.setCertificateNumber(cert);
		 user.setRemark(content);
		 user.setSex(sex);
		 user.setRealname(realname);
		 user.setTouristType(userType);
		 user.setPassword(password);
		 user.setCertificateType(certType);
		 user.setUsername(username);
		 uService.addUser(user);
		 return "success";
		
	}
	
	@Override
	public void validate() {
		if(username.trim().equals("")||username==null){
			this.addFieldError("username", "用户名不为空");
		}
		if(password.trim().equals("")||password==null){
			this.addFieldError("password", "密码不为空");
		}
		if(!password2.trim().equals(password.trim())){
			this.addFieldError("password2", "密码不一致 ");
		}
		if(password.trim().length()<6){
			this.addFieldError("password", "不少于6位字符");
		}
		 Pattern pattern = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$");
		  Matcher matcher = pattern.matcher(username);
		if(!matcher.matches()){
			this.addFieldError("username", "由字母、数字或“_”组成，长度不少于6位，不多于30位");
		}

	}

}
