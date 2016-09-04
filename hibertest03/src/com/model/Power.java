package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="t_power")
public class Power {
  private String id;
  private String name;
  private String introduction;
  private Set<Role> roles = new HashSet<Role>();

  @Id
  @Column(name="id")
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
@Column(name="name",length=50)
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Column(name="introduction",length=100)
public String getIntroduction() {
	return introduction;
}
public void setIntroduction(String introduction) {
	this.introduction = introduction;
}
@ManyToMany(mappedBy="powers",cascade=CascadeType.ALL)
public Set<Role> getRoles() {
	return roles;
}
public void setRoles(Set<Role> roles) {
	this.roles = roles;
}

  
  
}
