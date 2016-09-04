package com.model2;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private String id;
	private String name;
	private String sex;
	private Integer age;
	private String major;
	private Set<Subject> subjects = new HashSet<Subject>();

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	public Set<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	
	@Override
	public String toString(){
		return id + "\t" + name + "\t" + sex + "\t" + age + "\t" + major;
	}
}
