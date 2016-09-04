<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
     <%@ page import="java.util.*"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<%
String name =request.getParameter("name");
String pass=request.getParameter("pass");
if(!(name.equals("")||pass.equals(""))){
	name=new String(name);

%>
<center>
<b>欢迎<%=name %>的到来！</b><br>
您登陆的时间为:<%=new Date().toLocaleString() %>
</center>
<%
}else{
	%><center>对不起！你没有登录成功!</center><%
}
	%>
}

</body>
</html>