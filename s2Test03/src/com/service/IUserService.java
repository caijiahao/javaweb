package com.service;

import com.po.User;

public interface IUserService {
	/**
	 *�����û���Ϣ���жϵ�¼�Ƿ�ɹ� 
	 * @param user �û���Ϣ
	 * @return ����״̬
	 */
	public boolean getLoginState(User user);
}
