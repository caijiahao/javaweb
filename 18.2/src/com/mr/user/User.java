package com.mr.user;

public class User {
   private String name;
   private Integer age;
   private String sex;
   //构造方法
   public User(String name,Integer age,String sex){
	   this.name = name;
	   this.age = age;
	   this.sex = sex;
   }
   //输出JavaBean的属性值方法
   public void printInfo(){
	   System.out.println("用户姓名------"+name);
	   System.out.println("用户年龄------"+age);
	   System.out.println("用户性别------"+sex);
	   
   }
}
