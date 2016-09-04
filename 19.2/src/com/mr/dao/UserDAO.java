package com.mr.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mr.user.User;

public class UserDAO implements UserDAOImpl{

	private DataSource dataSource;  //ע��DataSource
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
//�����ݱ�tb_user���������
	@Override
	public void inserUser(User user) {
		// TODO Auto-generated method stub
		String name = user.getName();
		Integer age = user.getAge();
		String sex = user.getSex();
		Connection conn = null;
		Statement stmt = null;
		try{
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			stmt.execute("INSERT INTO tb_user(name,age,sex)"+"VALUES('"+name+"','" + age + "','" + sex + "')");
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
            if(stmt != null) {
                try {
                    stmt.close();//�ر�Statement����
                }   
                catch(SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null) {
                try {
                    conn.close();//�ر����ݿ�����
                }
                catch(SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}
