<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="com.po.User"%>
 <%@ taglib prefix="s"  uri="/struts-tags"%>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<title>主页</title>
</head>
<body>
	<h2>欢迎您：<s:property value="#session.user.userName"/></h2>
	<a href="goodsListAction">商品列表</a>
</body>
</html>