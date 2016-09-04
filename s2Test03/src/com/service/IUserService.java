package com.service;

import com.po.User;

public interface IUserService {
	/**
	 *根据用户信息，判断登录是否成功 
	 * @param user 用户信息
	 * @return 处理状态
	 */
	public boolean getLoginState(User user);
}
