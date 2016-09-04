<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.util.ArrayList"%>
<%@page import="com.po.Goods"%>
<%@page import="java.util.List"%>
<%@page import="com.po.User"%>
 <%@ taglib prefix="s"  uri="/struts-tags"%>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<title>商品信息页</title>
</head>
<body>
	<h2>欢迎您：<s:property value="#session.user.userName"/></h2>
	<table border="1px solid #ccc" cellpadding="1" cellspacing="0">
	<s:set name="glist" value="#session.goodslist"/>
	 
		<s:iterator value="#glist" var="goods" status="status">
		<tr>
			<td rowspan="5" width="130px" height="200px">
				<img width="120px"  height="190px"  title="<s:property value="#goods.gName"/>"   src="<s:property value="#goods.image"/>" />
			</td>
			<td width="400px"  height="20px">商品名称：<s:property value="#goods.gName"/></td>
		</tr>
		<tr>
			<td height="20px">卖家:<s:property value="#goods.gMember"/></td>
		</tr>
		<tr>
			<td style="vertical-align: top; " height="120px">描述：<s:property value="#goods.gDescription"/></td>
		</tr>
		<tr>
			<td align="right" height="20px">
				<span style="float:left;">价格：<s:property value="#goods.gPrice"/>元</span>
				<span style="float: right;">库存：<s:property value="#goods.stock"/>件</span>
			</td>
		</tr>
	
		<tr>
			<td align="left" height="20px">
				<input type="button" name="buyCar" value="放入购物车" />
			</td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		</s:iterator>
	</table>
</body>
</html>