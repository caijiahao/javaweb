<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
        <%@ page language="java" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>调用MySql的存储过程</title>
</head>
<body>
<%
String proc="{call insertIN(?)}";
try{
	Class.forName("com.mysql.jdbc.Driver");
	String url ="jdbc:MySQL://localhost:3306/test?user=root&password=13713393809";
	 Connection conn = DriverManager.getConnection(url);
	 CallableStatement stmt = conn.prepareCall(proc);
	 stmt.setInt(1, 9);
	 stmt.execute();
	 stmt.close();
	 out.println("<br>MySQL数据库存储过程insertIN(IN param1 INT)被JSP成功调用！");
}catch(SQLException e){
	out.println(e.toString());
}
%>
</body>
</html>