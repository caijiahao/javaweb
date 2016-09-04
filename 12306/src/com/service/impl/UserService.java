package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.impl.BaseDao;
import com.model.po.User;
import com.service.IUserService;

@Service
public class UserService<T> implements IUserService<T> {
	@Autowired
    private BaseDao<T> baseDao;
  
	@SuppressWarnings("unchecked")
	@Override
	public User getUserById(String id) {
		return (User) baseDao.get( (Class<T>) User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addUser(User user) {
         baseDao.save((T) user);

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void updateUser(User user) {
		baseDao.update((T) user);
		
	}

}
