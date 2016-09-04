package com.gc.action;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		// TODO Auto-generated method stub
		return clazz.equals(User.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User) obj;
		if(!"gf".equals(user.getUsername())){
			errors.rejectValue("username", "", null,"用户名不正确");
		}
		if(!"123456".equals(user.getPassword())){
			errors.rejectValue("password", "", null, "密码不正确");
		}
		if(!user.getPassword().equals(user.getPassword2())){
			errors.rejectValue("password2", "", null, "2次输入的密码不一致");
		}
	}

}
