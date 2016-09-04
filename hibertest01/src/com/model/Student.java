package com.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="t_stu")
public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer age;
	private String address;
	private String hobby;
    private Integer s_id;
    private String name;
    private ClassType classType;
    @Column(name = "age")
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Column(name = "address", length=50)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "hobby", length=50)
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	@Id
	@Column(name = "s_id")
	public Integer getS_id() {
		return s_id;
	}
	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}
	@Column(name = "name", length=50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="c_id")
	public ClassType getClassType() {
		return classType;
	}
	public void setClassType(ClassType classType) {
		this.classType = classType;
	}
	
    
	
	
	

}
