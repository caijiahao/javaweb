<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="gb18030"%>
 <%@taglib prefix="spring" uri="/spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<title>Spring MVC实例</title>
</head>
<body>
    <form name="User" action="/login.do" method="post">
    <spring:bind path="command.username">
    输入用户名: <input type="text" name="${status.expression }" value="${status.value }"/>
    <br>
          <font color="red"><b>${status.errorMessage}</b></font></br>
    </spring:bind>
    <spring:bind path="command.password">
    输入密码：<input type="password" name="${status.expression }" value="${status.value }"/>
    <br>
       <font color="red"><b>${status.errorMessage}</b></font>
    </spring:bind>
    <spring:bind path="command.password2">
    确认密码：<input type="password" name="${status.expression }" value="${status.value }"/>
    <br>
       <font color="red"><b>${status.errorMessage}</b></font>
    </spring:bind>
    <input type="submit" value="提交"/>
    </form>
</body>
</html>