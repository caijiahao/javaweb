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
String head[]={"星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
String left[]={"上午","下午","晚上"};
String main[][]={
		{"语文","数学","数学","语文",	"英语","休息","休息"},
		{"数学","英语","语文","英语",	"数学","休息","休息"},
		{"自习","自习","自习","自习",	"自习","休息","休息"}
};
%>
<center><b>希望小学课程表</b></center>
<table width="500" height="100" border="1" align="center">
<%
for(int i=0;i<4;i++){
	out.print("<tr>");
	for(int j=0;j<8;j++){
		if(i==0&&j==0)
			out.print("<td>星期/时间</td>");
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