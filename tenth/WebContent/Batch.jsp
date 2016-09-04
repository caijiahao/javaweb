<%@ page language="java" contentType="text/html; charset=gb18030"
    pageEncoding="gb18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<title>Insert title here</title>
<jsp:useBean id="batch" class="com.lyq.Batch"></jsp:useBean>
</head>
<body>
<%
int row = batch.saveBatch();
out.print("批量插入了【"+row+"】条数据！");
%>
</body>
</html>