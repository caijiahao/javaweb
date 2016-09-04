package com.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDao {
	// �������ݿ����Ӷ���
	private Connection connection = null;
	// �����������ִ�ж���
	private PreparedStatement pment = null;
	// ������̻���ִ�ж���
	private CallableStatement cment = null;
	// ����һ�����������
	private ResultSet rs = null;

	public BaseDao(){
	}
	/**
	 * ��ȡ���ݿ�����
	 */
	public void getConnection() {
		try {
			Context cxt = new InitialContext();
			DataSource ds  = (DataSource) cxt.lookup("java:comp/env/jdbc/12306_db");
			connection = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �ر��������ݿ��������
	 */
	public void closeAllObject() {
		try {
			if (rs != null)
				rs.close();
			if (pment != null)
				pment.close();
			if(cment != null)
				cment.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * ִ��insert,update,delete���ʱ����ȡ��Ӱ�������
	 * @param sSql 
	 * 								Ҫ��ִ�е�SQL����
	 * @param oParams
	 * 								 ִ��SQL��������Ĳ����б�
	 * @return
	 */
	public int getNonQuery(String sSql, Object[] oParams){
		int iNonQuery = 0;
		getConnection();
		try{
			// ����connection���Ӷ��󣬸���Ҫ��Ҫִ�е�SQL�����ִ�ж���
			pment = connection.prepareStatement(sSql);
			// �ж�ִ��SQL��������Ĳ����б��Ƿ�Ϊ�ն���������
			if (oParams != null && oParams.length != 0) {
				for (int i = 0; i < oParams.length; i++) {
					// ����ѭ����ִ��SQL��������Ĳ����б���������ִ�ж���
					pment.setObject((i + 1), oParams[i]);
				}
			}
			// ����ִ�ж���ִ���޸Ĳ���(insert,update,delete���)
			iNonQuery = pment.executeUpdate();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closeAllObject();
		}
		return iNonQuery;
	}
	/**
	 * ִ��insert,update,delete���ʱ����ȡ��Ӱ�������
	 * 
	 * @param sProcName
	 *            Ҫ��ִ�еĹ�������
	 * @param oParams
	 *            ִ��SQL��������Ĳ����б�
	 * @return ��Ӱ�������
	 */
	public int getNonQueryByPro(String sProcName, Object[] oParams) {
		int iNonQuery = 0;
		getConnection();
		try {
			// ����connection���Ӷ��󣬸���Ҫ��Ҫִ�е�SQL�����ִ�ж���
			cment = connection.prepareCall(sProcName);
			// �ж�ִ��SQL��������Ĳ����б��Ƿ�Ϊ�ն���������
			if (oParams != null && oParams.length != 0) {
				for (int i = 0; i < oParams.length; i++) {
					// ����ѭ����ִ��SQL��������Ĳ����б���������ִ�ж���
					cment.setObject((i + 1), oParams[i]);
				}
			}
			// ����ִ�ж���ִ���޸Ĳ���(insert,update,delete���)
			iNonQuery = cment.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closeAllObject();
		}
		return iNonQuery;
	}

	/**
	 * ִ��select���ʱ����ȡ�����
	 * 
	 * @param sProcName
	 *            Ҫ��ִ�е�SQL���
	 * @param oParams
	 *            ִ��SQL��������Ĳ����б�
	 * @return �����
	 */
	public ResultSet getResultSet(String sSql, Object[] oParams) {
		rs = null;
		getConnection();
		try {
			// ����connection���Ӷ��󣬸���Ҫ��Ҫִ�е�SQL�����ִ�ж���
			pment = connection.prepareStatement(sSql);
			// �ж�ִ��SQL��������Ĳ����б��Ƿ�Ϊ�ն���������
			if (oParams != null && oParams.length != 0) {
				for (int i = 0; i < oParams.length; i++) {
					// ����ѭ����ִ��SQL��������Ĳ����б���������ִ�ж���
					pment.setObject((i + 1), oParams[i]);
				}
			}
			// ����ִ�ж���ִ���޸Ĳ���(insert,update,delete���)
			rs = pment.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return rs;
	}
	
	/**
	 * ִ��select���ʱ����ȡ�����
	 * 
	 * @param sProcName
	 *            Ҫ��ִ�еĹ�������
	 * @param oParams
	 *            ִ��SQL��������Ĳ����б�
	 * @return �����
	 */
	public ResultSet getResultSetByPro(String sProcName, Object[] oParams) {
		rs = null;
		getConnection();
		try {
			// ����connection���Ӷ��󣬸���Ҫ��Ҫִ�е�SQL�����ִ�ж���
			cment = connection.prepareCall(sProcName);
			// �ж�ִ��SQL��������Ĳ����б��Ƿ�Ϊ�ն���������
			if (oParams != null && oParams.length != 0) {
				for (int i = 0; i < oParams.length; i++) {
					// ����ѭ����ִ��SQL��������Ĳ����б���������ִ�ж���
					cment.setObject((i + 1), oParams[i]);
				}
			}
			// ����ִ�ж���ִ���޸Ĳ���(insert,update,delete���)
			rs = cment.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return rs;
	}
}
