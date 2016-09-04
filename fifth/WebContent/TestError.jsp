<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用exception对象获取异常信息</title>
</head>
<body>
<%
request.setAttribute("price", "12.5元");
float price=Float.parseFloat(request.getAttribute("price").toString());
%>
</body>
</html>