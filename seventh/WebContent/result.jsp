<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.lyq.bean.*"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<%
String mailAdd=request.getParameter("mailAdd");
Email email = new Email(mailAdd);
if(email.isEmail()){
	out.print(mailAdd+"<br>是一个标准的邮箱地址!<br>");
}else{
	out.print(mailAdd+" <br>不是一个标准的邮箱地址！<br>");
}
%>
<a href="index.jsp">返回</a>
</div>
</body>
</html>