<%@ page language="java" contentType="text/html; charset=gb18030"
    pageEncoding="gb18030"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<title>实时分时问候</title>
</head>
<body>
<c:set var="hours"><%= new java.util.Date().getHours() %></c:set>
<c:set var="second"><%= new java.util.Date().getMinutes() %></c:set>

<c:choose>
     ，        
</c:choose>
   现在时间是:${hours}:${second}
</body>
</html>