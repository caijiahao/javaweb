<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s"  uri="/struts-tags"%>
    <title>登录页面</title>
</head>
<body>
	<s:form action="loginAction" method="post">
		<table border="1px solid #ccc" cellpadding="1" cellspacing="0">
			<tr>
				<td colspan="2" align="center">网上购物系统</td>
			</tr>
			<tr>
				<td width="100px" align="right">用户名：<s:textfield name="user.userName"/></td>
			</tr>
			<tr>
				<td align="right">密码：<s:password name="user.password"/></td>
			<tr>
				<td colspan="2" align="center"><s:submit value="登录" /></td>
			</tr>
			
		</table>
	</s:form>
</body>
</html>