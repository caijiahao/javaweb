package com.dao;

import com.po.User;

public interface IUserDao {
	public User findUserByLogin(User user);

}
