package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="t_role")
public class Role {
   private String id;
   private String name;
   private String introduction;
   private Set<Power> powers = new HashSet<Power>();
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

@ManyToMany(cascade=CascadeType.ALL)
@JoinTable(
        name="t_power_role",
        joinColumns=@JoinColumn(name="role_id"),
        inverseJoinColumns=@JoinColumn(name="power_id")
)
public Set<Power> getPowers() {
	return powers;
}
public void setPowers(Set<Power> powers) {
	this.powers = powers;
}
   
   
}
