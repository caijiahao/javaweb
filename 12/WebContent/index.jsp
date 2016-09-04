<%@ page language="java" contentType="text/html; charset=gb18030"
    pageEncoding="gb18030"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<title>应用&It;c:out&gt;标签输出字符串 “水平线标记&It;h&gt;”</title>
</head>
<body>
<c:out value="水平线标记<hr>" escapeXml="true"></c:out>
<br>
<c:out value="水平线标记<hr>" escapeXml="false"></c:out>
</body>
</html>