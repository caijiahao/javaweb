<%@ page language="java" contentType="text/html; charset=gb18030"
    pageEncoding="gb18030"%>
<%@taglib prefix="spring" uri="/spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<title>Spring MVCʵ��</title>
</head>
<body>
   <spring:bind path="command.username">
     <h3>��ӭ${status.value}��½�ɹ�</h3>
   </spring:bind>
</body>
</html>