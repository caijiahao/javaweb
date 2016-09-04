<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <title>登录页面</title>
</head>
<body>
	<s:form action="loginAction"  method="post" name="loginForm">
	 	<s:textfield label="用户名" name="userName"/>
	 	<s:textfield label="昵称" name="smallName"/>
	 	<s:password label="密码" name="pwd"/>
	 	<s:textfield label="提示" name="tip"/>
	 	<s:textfield label="手机号" name="phone"/>
	 	<s:submit  value="注册"/>
	</s:form>
</body>
</html>