package com.lyq;

import java.util.Vector;

public class UserInfoList {
private static UserInfoList user = new UserInfoList();
private Vector vector = null;

public UserInfoList(){
	this.vector = new Vector();
}
/*���ʹ�õ�instance����*/
public static UserInfoList getInstance(){
	return user;
}
/*�����û�*/
public boolean addUserInfo(String user){
	if(user != null){
		this.vector.add(user);
		return true;
	}else{
		return false;
	}
}
/*��ȡ�û��б�*/
public Vector getList(){
	return vector;
}
/*�Ƴ��û�*/
public void removeUserInfo(String user){
	if(user!=null){
		vector.removeElement(user);
	}
}
}
