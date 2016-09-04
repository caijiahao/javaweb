<%@ page language="java" contentType="text/html; charset=gb18030"
    pageEncoding="gb18030"%>
    <%@page language="java" import="java.util.*" %>
    <%@page language="java" import="com.lyq.Book" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<title>Insert title here</title>
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
    List<Book> list =(List<Book>)request.getAttribute("list");
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
         <td>
             <form action="UpdateServlet" method="post" onsubmit="return check(this);">
               <input type="hidden" name="id" value="<%=book.getId() %>">
               <input type="text" name="bookCount" size="3">
               <input type="submit" value="修 改">
             </form>
         </td>   
         <td>
             <a href="DeleteServlet?id=<%= book.getId() %>">删除</a>
         </td>   
    </tr>
    <%
    	}
    }
    %>
</table>
</body>
</html>