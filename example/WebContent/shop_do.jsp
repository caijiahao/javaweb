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
<strong>��ʾ�����ղ�ѡ������Ʒ<font color="red"><%=goodsName %>
</font>,������������ʲô��</strong><br><br>
<button onclick="location.href='shop.jsp'">����������Ʒ</button>
<button onclick="location.href='pay.jsp'">������̨����</button>
</center>
</body>
</html>