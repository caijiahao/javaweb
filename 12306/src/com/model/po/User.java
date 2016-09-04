package com.model.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @功能：用户表的实体Bean,用于生成和进行用户表的各项操作
 * @开发者：陈文宇
 *
 */
@Entity
@Table(name = "t_user")
public class User implements Serializable{
	private static final long serialVersionUID = -3889811187861098960L;
	
	@Id
    private String username;
	private String password;
	
	private String realname;
	private Integer sex;
	private String address;
	private Integer certificateType;
	private String certificateNumber;
	private Date birthday;
	private Integer touristType;
	private String remark;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getCertificateType() {
		return certificateType;
	}
	public void setCertificateType(Integer certificateType) {
		this.certificateType = certificateType;
	}
	public String getCertificateNumber() {
		return certificateNumber;
	}
	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getTouristType() {
		return touristType;
	}
	public void setTouristType(Integer touristType) {
		this.touristType = touristType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
