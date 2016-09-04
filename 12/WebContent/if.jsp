<%@ page language="java" contentType="text/html; charset=gb18030"
    pageEncoding="gb18030"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty param.username}" var="result">
<form name="form1" method="post" action="">
用户名:
  <input name="username" type="text" id="username">
  <br>
  <br>
  <input type="submit" name="Submit" value="登陆">
  </form>
  </c:if>
  <c:if test="${!result}">
      [${param.username}]欢迎访问我公司网站!
  </c:if>
</body>
</html>