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
String head[]={"����һ","���ڶ�","������","������","������","������","������"};
String left[]={"����","����","����"};
String main[][]={
		{"����","��ѧ","��ѧ","����",	"Ӣ��","��Ϣ","��Ϣ"},
		{"��ѧ","Ӣ��","����","Ӣ��",	"��ѧ","��Ϣ","��Ϣ"},
		{"��ϰ","��ϰ","��ϰ","��ϰ",	"��ϰ","��Ϣ","��Ϣ"}
};
%>
<center><b>ϣ��Сѧ�γ̱�</b></center>
<table width="500" height="100" border="1" align="center">
<%
for(int i=0;i<4;i++){
	out.print("<tr>");
	for(int j=0;j<8;j++){
		if(i==0&&j==0)
			out.print("<td>����/ʱ��</td>");
		if(i==0&&j!=0)
			out.print("<td>"+head[j-1]+"</td>");
		if(i!=0&&j==0)
			out.print("<td>"+left[i-1]+"</td>");
		if(i!=0&&j!=0)
			out.print("<td>"+main[i-1][j-1]+"</td>");
	}
}
%>
</table>
</body>
</html>