<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="gb18030"%>
 <%@taglib prefix="spring" uri="/spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<title>Spring MVCʵ��</title>
</head>
<body>
    <form name="User" action="/login.do" method="post">
    <spring:bind path="command.username">
    �����û���: <input type="text" name="${status.expression }" value="${status.value }"/>
    <br>
          <font color="red"><b>${status.errorMessage}</b></font></br>
    </spring:bind>
    <spring:bind path="command.password">
    �������룺<input type="password" name="${status.expression }" value="${status.value }"/>
    <br>
       <font color="red"><b>${status.errorMessage}</b></font>
    </spring:bind>
    <spring:bind path="command.password2">
    ȷ�����룺<input type="password" name="${status.expression }" value="${status.value }"/>
    <br>
       <font color="red"><b>${status.errorMessage}</b></font>
    </spring:bind>
    <input type="submit" value="�ύ"/>
    </form>
</body>
</html>