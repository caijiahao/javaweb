<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>写入cookie</title>
</head>
<body>
<%
request.setCharacterEncoding("GB18030");
String user=java.net.URLEncoder.encode(request.getParameter("user"),"GB18030");
Cookie cookie = new Cookie("mrCookie",user+"#"+new java.util.Date().toLocaleString());
cookie.setMaxAge(60*60*24*30);
response.addCookie(cookie);
%>
<script type="text/javascript">window.location.href="Regin.jsp"</script>
</body>
</html>