package com.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="c_type")
public class ClassType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer c_id;
	private String className;
	private Set<Student> students = new HashSet<Student>();
	@Id
	@Column(name = "c_id")
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	
	@Column(name = "className", length=50)
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="classType")
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	
	
}
