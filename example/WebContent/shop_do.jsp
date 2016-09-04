<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<%
String goodsName=request.getParameter("goods");
if(!goodsName.equals("")){
	goodsName=new String(goodsName.getBytes("ISO-8859-1"));
	ArrayList list=null;
	list=(ArrayList)session.getAttribute("list");
	if(list==null){
		list=new ArrayList();
		list.add(goodsName);
		session.setAttribute("list", list);
	}else{
		list.add(goodsName);
	}
	%>
	----------------------------------------
	<%
}else{
	response.sendRedirect("shop.jsp");
}
%>
<center>
<strong>提示：您刚才选择了商品<font color="red"><%=goodsName %>
</font>,请问您还想做什么？</strong><br><br>
<button onclick="location.href='shop.jsp'">继续购买商品</button>
<button onclick="location.href='pay.jsp'">到收银台结账</button>
</center>
</body>
</html>