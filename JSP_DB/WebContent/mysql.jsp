<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    <%@ page language="java" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<%
   try{
	   Class.forName("com.mysql.jdbc.Driver");
	   String url ="jdbc:MySQL://localhost:3306/test?user=root&password=13713393809";
	   Connection conn = DriverManager.getConnection(url);
	              out.print("<br><center>��ϲ�㣡MySQL���ݿ����ӳɹ���</center>");
	              conn.close();
   }catch(Exception e){
	   out.print("���ݿ����Ӵ��󣡣�������Ϣ���£�<br>");
	   out.print(e.getMessage());
   }
%>
</body>
</html>