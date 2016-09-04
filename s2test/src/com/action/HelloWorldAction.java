package com.action;

public class HelloWorldAction {
   private String name;
   private String className;
   private String stuId;
   private int  age;
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
   
public String execute() throws Exception{
	return "success";
}

public String getClassName() {
	return className;
}

public void setClassName(String className) {
	this.className = className;
}

public String getStuId() {
	return stuId;
}

public void setStuId(String stuId) {
	this.stuId = stuId;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}


}
