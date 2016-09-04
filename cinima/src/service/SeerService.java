package service;

import java.util.List;

import dao.SeerDAO;

public class SeerService {
	private SeerDAO seerDao;
	
	public SeerDAO getSeerDao() {
		return seerDao;
	}

	public void setSeerDao(SeerDAO seerDao) {
		this.seerDao = seerDao;
	}

	public List isLogin(String email,String password){
		return seerDao.islogin(email, password);
	}
}
