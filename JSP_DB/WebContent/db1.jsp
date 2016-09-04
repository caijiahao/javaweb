<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page language="java" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>通讯录</title>
</head>
<body>
<b><br>通讯录一览表</b>
<table width="450" border="0" cellpadding="1" bgcolor="#000000">
<tr>
<th bgcolor="#FFFFFF" scope="col">编号</th>
<th bgcolor="#FFFFFF" scope="col">姓名</th>
<th bgcolor="#FFFFFF" scope="col">电话</th>
</tr>

<% ResultSet rs = null; %>
<%
int type=-1;
try{
	type=Integer.parseInt(request.getParameter("do"));
}catch(Exception eee){
	type=0;
}
try{
	Statement st = getStatement();
	String name =request.getParameter("name");
	switch(type){
	case 0:
		rs=st.executeQuery("select * from friends");
		break;
	case 1:
		name = new String(name.getBytes("ISO-8859-1"));
		rs=st.executeQuery("select * from friends where name like '%"+name+"%'");
		break;
	case 2:
		name = new String(name.getBytes("ISO-8859-1"));
		st.executeUpdate("delete from friends where name = '"+name+"'");
		response.sendRedirect("db1.jsp");
		break;
	case 3:
		name = new String(name.getBytes("ISO-8859-1"));
		String tel=request.getParameter("tel");
		st.executeUpdate("insert friends values('0','"+name+"','"+tel+"')");
		response.sendRedirect("db1.jsp");
		break;
	case 4:
		name = new String(name.getBytes("ISO-8859-1"));
		String tell=request.getParameter("tel");
		String sql="update friends set tel='"+tell+"'where name ='"+name+"'";
		st.executeUpdate(sql);
		response.sendRedirect("db1.jsp");
		break;
	}
%>
<%
while(rs.next()){
	%>

<tr>
<td bgcolor="#FFFFFF"><%=rs.getInt("id") %></td>
<td bgcolor="#FFFFFF"><%=rs.getString("name") %></td>
<td bgcolor="#FFFFFF"><%=rs.getString("tel") %></td>
</tr>
<%
}
rs.close();
st.close();
}catch(Exception ee){
	out.print(ee.toString());
}
%>
</table>

<form id="form1" name="form1" method="post" action="db1.jsp">
<div align="left">
<input type="hidden" name="do" value="1"/>
<input type="text" name="name" value="姓名"/>
<input type="submit" name="Submit" value="查询"/>
</div>
</form>

<form id="form1" name="form1" method="post" action="db1.jsp">
<div align="left">
<input type="hidden" name="do" value="2"/>
<input type="text" name="name" value="姓名"/>
<input type="submit" name="Submit" value="删除"/>
</div>
</form>

<form id="form1" name="form1" method="post" action="db1.jsp">
<input type="hidden" name="do" value="3"/>
<p>
<input type="text" name="name" value="姓名"/>
</p>
<p align="left">
<input type="text" name="tel" value="电话"/>
<input type="submit" name="Submit22" value="添加"/>
</p>
</form>

<form id="form1" name="form1" method="post" action="db1.jsp">
<input type="hidden" name="do" value="3"/>
<p>
<input type="text" name="name" value="姓名"/>
</p>
<p align="left">
<input type="text" name="tel" value="电话"/>
<input type="submit" name="Submit222" value="修改"/>
</p>
</form>
<%!
public Statement getStatement(){
	try{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:MySQL://localhost:3306/test?user=root&password=13713393809";
		 Connection conn = DriverManager.getConnection(url);
		 return conn.createStatement();
	}catch(Exception e){
		return null;
	}
}
%>
</body>
</html>