package com.service.impl;

import com.dao.IUserDao;
import com.dao.impl.UserDao;
import com.po.User;
import com.service.IUserService;

public class UserService implements IUserService {
	private IUserDao dao  = new UserDao();
	@Override
	public boolean getLoginState(User user){
		boolean flg = false;
		User resultUser = dao.findUserByLogin(user);
		if(resultUser != null)
			flg = true;
		return flg;
	}
}
