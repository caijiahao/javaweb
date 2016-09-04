<%@ page language="java" contentType="text/html; charset=gb18030"
    pageEncoding="gb18030"%>
    <%@ page language="java" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<title>Insert title here</title>
</head>
<body>
<%
try{
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/test";
	String username ="root";
	String password = "13713393809";
	Connection conn = DriverManager.getConnection(url,username,password);
	if(conn != null){
		out.println("数据库连接成功！");
		conn.close();
	}else{
		out.println("数据库连接失败！");
	}
}catch(ClassNotFoundException e){
	e.printStackTrace();
}catch(SQLException e){
	
}
%>
555
</body>
</html>