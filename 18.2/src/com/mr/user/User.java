package com.mr.user;

public class User {
   private String name;
   private Integer age;
   private String sex;
   //���췽��
   public User(String name,Integer age,String sex){
	   this.name = name;
	   this.age = age;
	   this.sex = sex;
   }
   //���JavaBean������ֵ����
   public void printInfo(){
	   System.out.println("�û�����------"+name);
	   System.out.println("�û�����------"+age);
	   System.out.println("�û��Ա�------"+sex);
	   
   }
}
