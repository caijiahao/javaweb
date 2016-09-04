<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    <%@ page language="java"  import="java.io.*"%>
           <%@ page language="java"  import="java.sql.*"%>
               <%@ page language="java"  import="java.lang.Exception"%>
                <%@ page language="java"  import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>新闻发布</title>
</head>
<body>
<%!
//根据提交内容创建HTML文件
private void createFile(String title,String content,File file)throws IOException,SQLException{
	if(!file.exists()){
		file.createNewFile();
	}
	PrintWriter pw = new PrintWriter(new FileOutputStream(file));
	pw.println("<tilte>"+title+"</title>");
	pw.println(content);
	pw.close();
}
%>

<%!
//取得Statement对象
private Statement getStatement()throws SQLException{
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(Exception e){}
	String url="jdbc:MySQL://localhost:3306/new?user=root&password=13713393809&characterEncoding=gb2312";
	Connection con = DriverManager.getConnection(url);
	return con.createStatement();
}
%>

<%!
private void insertSQL(String title,String fileName)throws SQLException{
	String sql = "insert into news values('"+title+"','"+fileName+"')";
	Statement st = getStatement();
	st.executeUpdate(sql);
	st.close();
}
%>
<%
String title=request.getParameter("title");
System.out.print(title);
String content = request.getParameter("content");
Date date = new Date();
String str = "news" + date.getYear()+date.getMonth()+date.getDay()+date.getHours()+date.getMinutes()+date.getSeconds();
File file = new File("D:\\eclipse\\javaWeb项目代码\\example\\WebContent\\new",str+".jsp");
try{
	createFile(title,content,file);
	String fileName=file.getName();
	insertSQL(title,fileName);
	response.sendRedirect("new/"+fileName);
}catch(Exception e){
	out.print(e.toString());
}
%>
</body>
</html>