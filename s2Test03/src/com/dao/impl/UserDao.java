package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.BaseDao;
import com.dao.IUserDao;
import com.po.User;

public class UserDao extends BaseDao implements IUserDao {

	@Override
	public User findUserByLogin(User user) {
		User resultUser = null;
		String strSql = "SELECT USERNAME, PASSWORD FROM USER U WHERE U.USERNAME = ? AND U.PASSWORD = ?";
		Object[] params = new Object[]{
								user.getUserName() == null  ?  "" : user.getUserName(),
								user.getPassword() == null ? "" : user.getPassword()
						};
		ResultSet rs = super.getResultSet(strSql, params);
		try {
			while(rs.next()){
				resultUser = new User(rs.getString(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAllObject();
		}
		return resultUser;
	}
	/*public User findUserByLogin(User user) {
		User resultUser = null;
		String sProcName = "call pr_findUser(?,?)";
		Object[] oParams = new Object[]{
				user.getUserName(),
				user.getPassword()
		};
		ResultSet rs = super.getResultSetByPro(sProcName, oParams);
		try {
			while(rs.next()){
				resultUser = new User(rs.getString(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAllObject();
		}
		return resultUser;
		
	}*/
	
	
}
