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
<b>��ӭ<%=name %>�ĵ�����</b><br>
����½��ʱ��Ϊ:<%=new Date().toLocaleString() %>
</center>
<%
}else{
	%><center>�Բ�����û�е�¼�ɹ�!</center><%
}
	%>
}

</body>
</html>