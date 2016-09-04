<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<%
Object oCount = application.getAttribute("count");

Integer count = null;
if(oCount==null){
	count = new Integer(1);
}else{
	count=(Integer)application.getAttribute("count");
	count=new Integer(count.intValue()+1);
}
application.setAttribute("count", count);
%>
</head>
<body>
<br>
<h3>尊敬的访客，您好！欢迎您的到来！</h3>
您是这里的第<font color="red"><%=count.intValue() %></font>位访客，祝你玩的快乐！
</body>
</html>