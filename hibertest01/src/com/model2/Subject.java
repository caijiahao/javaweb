package com.model2;

import java.util.HashSet;
import java.util.Set;

public class Subject {
	private String id;
	private String subject;
	private Set<Student> students = new HashSet<Student>();

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	} 
	
	@Override
	public String toString(){
		return id + "\t" + subject;
	}
}
