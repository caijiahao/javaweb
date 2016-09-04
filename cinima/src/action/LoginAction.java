package action;

import java.util.List;

import service.SeerService;

public class LoginAction {
	private String email;
	private String password;
	private SeerService seerService;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public SeerService getSeerService() {
		return seerService;
	}
	public void setSeerService(SeerService seerService) {
		this.seerService = seerService;
	}
	public String post() throws Exception{
		System.out.println(email);
		System.out.println(password);
		email="joanfriending@gmail.com";
		password="202010";
		String s="loginSuccess";
		String f="loginFail";
		List l=seerService.isLogin(email, password);
		if(l.size()>0){
			return s;
		}
		else return f;
	}
}
