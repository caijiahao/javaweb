<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>通过cookie保存并读取用户登录信息</title>
</head>
<body>
<%
Cookie[] cookies = request.getCookies();
String user="";
String date="";
if(cookies!=null){
for(int i=0;i<cookies.length;i++){
if(cookies[i].getName().equals("mrCookie")){
	user = java.net.URLDecoder.decode(cookies[i].getValue().split("#")[0]);
	user = new String(user);
	date = cookies[i].getValue().split("#")[1];
}
}
}
if("".equals(user)&&"".equals(date)){
%>
          游客您好，欢迎您初次光临！
         <form action="deal.jsp" method="post">
         		请输入姓名：<input name="user" type="text" value="">
         		<input type="submit" value="确定">
         </form> 
         <%
}else{
         %>
         欢迎[<b><%=user %></b>]再次光临<br>
         您注册的时间 是：<%=date %>;
         <%
}
         %>
</body>
</html>