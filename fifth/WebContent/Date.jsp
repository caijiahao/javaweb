<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
   <%@ page import="java.util.*"%>  
<%@ page import="java.text.*"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<% 
String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //获取系统时间
System.out.print(datetime);
%>
<%=datetime %>
</body>
</html>