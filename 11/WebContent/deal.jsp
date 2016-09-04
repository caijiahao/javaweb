<%@ page language="java" contentType="text/html; charset=gb18030"
    pageEncoding="gb18030"%>
    <%@taglib uri="/stringDeal" prefix="wghfn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%request.setCharacterEncoding("gb18030"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<title>显示结果</title>
</head>
<body>
内容为：<br>
${wghfn:shiftEnter(param.content)}
</body>
</html>