<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
        <%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>֧������</title>
</head>
<body>
�ǳ���л���Ĺ��٣����������������ﹺ����һ����Ʒ:<br>
<%
ArrayList list=(ArrayList)session.getAttribute("list");
for(int i=0;i<list.size();i++){
	String goodsName=(String)list.get(i);
	%>
	��Ʒ<%=i %>:<%=goodsName %><br>
<% 
}
%>
</body>
</html>