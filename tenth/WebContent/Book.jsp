<%@ page language="java" contentType="text/html; charset=gb18030"
    pageEncoding="gb18030"%>
     <%@page language="java" import="java.util.*" %>
    <%@page language="java" import="com.lyq.Book" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<title>Insert title here</title>
<jsp:useBean id="findbook" class="com.lyq.Book"></jsp:useBean>
</head>
<body>
<table align="center" width="450" border="1">
<tr>
    <td align="center" colspan="5">
    <h2>所有图书信息</h2>
    </td>
    </tr>
    <tr align="center">
    <td><b>ID</b></td>
    <td><b>图书名称</b></td>
    <td><b>价格</b></td>
    <td><b>数量</b></td>
    <td><b>作者</b></td>
    <td><b>修改数量</b></td>
    </tr>
    <%
    List<Book> list = findbook.findAll();
        //判断集合是否有效
    if(list == null || list.size()<1){
    	out.print("没有数据！");
    }else{
    	//遍历图书集合中的数据
    	for(Book book :list){
    
    %>
    <tr align="center">
         <td><%=book.getId() %></td>
         <td><%=book.getName() %></td>
         <td><%=book.getPrice() %></td>
         <td><%=book.getBookCount() %></td>
         <td><%=book.getAuthor() %></td>  
         </tr>
         <%
    	}
    }
    %>
    </table>
</body>
</html>