package com.service;

import com.model.po.User;

public interface IUserService<T> {
	public User getUserById(String id);
	public void addUser(User user);
	public void updateUser(User user);
}
