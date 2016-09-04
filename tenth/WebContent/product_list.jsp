<%@ page language="java" contentType="text/html; charset=gb18030"
    pageEncoding="gb18030"%>
    <%@page language="java" import="com.lyq.*" %>
    <%@page language="java" import="java.util.*" %>
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
        <h2>所有商品信息</h2>
    </td>
</tr>
<tr align="center">
   <td><b>ID</b></td>
   <td><b>商品名称</b></td>
   <td><b>价格</b></td>
   <td><b>数量</b></td>
   <td><b>单位</b></td>
</tr>
<%
   List<Product> list = (List<Product>)request.getAttribute("list");
   for(Product p:list){
%>
<tr align="center">
   <td><%=p.getId() %></td>
   <td><%=p.getName() %></td>
   <td><%=p.getPrice() %></td>
   <td><%=p.getNum() %></td>
   <td><%=p.getUnit() %></td>
   </tr>
   <%
      }
   %>
   <tr>
       <td align="center" colsapn="5">
            <%= request.getAttribute("bar") %>
       </td>
   </tr>
</table>
</body>
</html>