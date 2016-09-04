<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    <%@ page language="java" import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<%
String path="D:\\eclipse\\javaWeb项目代码\\example";
File file = new File(path,"jsp.txt");
FileReader fr = new FileReader(file);
BufferedReader br = new BufferedReader(fr);
StringBuffer strB=new StringBuffer();
String str = br.readLine();
while(str!=null){
	strB.append(str).append("<br>");
	str=br.readLine();
}
br.close();
%>
</head>
<body>
<center><%=strB %></center>
</body>
</html>