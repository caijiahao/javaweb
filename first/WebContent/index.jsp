<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    <%@ page import="java.util.Date" %>
     <%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Gb18030">
<title>��һ��Java WebӦ��</title>
</head>
<body>
<center>��������������������</center>
<%
Date date = new Date();
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String today = df.format(date);
%>
��ǰʱ�䣺<%=today %>
<%
   String str ="";
for(int i=1;i<=9;i++){
	for(int j=1;j<=9;j++){
		str +=j+"*"+i+"="+j*i;
		str+="&nbsp";
	}
	str +="<br>";
}
%>
<table width="440" height="85" border="1" cellpading="0" cellspacing="0" style="font:9pt;"
bordercolrdark="#666666" bordercolorlight="#FFFFFF" bordercolor="#FFFFFF">
<tr>
<td height="30" align="center">�žų˷���</td>
</tr>
<tr>
<td style="padding:3pt">
<%=str %>
</td>
</tr>
</table>
</body>
</html>