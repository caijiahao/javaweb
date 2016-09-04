<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<%
Cookie myCookie = new Cookie("name","Tom");
Cookie user_id=new Cookie("ID","023922-01");
response.addCookie(myCookie);
response.addCookie(user_id);
Cookie allCookie[]=request.getCookies();
%>
<center>
<h3>客户端的Cookie信息有：</h3>
<table width="400" border="1">
<tr align="center">
<th>索引</th>
<th>内容</th>
</tr>
<%
for(int i=0;i<allCookie.length;i++){
	String index=allCookie[i].getName();
	String value=allCookie[i].getValue();
	%>
	<tr align="center">
	<td><%=index %></td>
	<td><%=value %></td>
	</tr>
<%}
%>
</table>
</center>
</body>
</html>