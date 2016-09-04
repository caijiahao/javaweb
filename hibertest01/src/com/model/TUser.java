package com.model;

import java.util.HashSet;
import java.util.Set;

public class TUser {
	private int id;
    private String name;
    private Integer age;
    private Set<String> userAddresses = new HashSet<String>();
    
    
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<String> getUserAddresses() {
		return userAddresses;
	}
	public void setUserAddresses(Set<String> userAddresses) {
		this.userAddresses = userAddresses;
	}
    
    
}
