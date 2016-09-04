<%@ page language="java" contentType="text/html; charset=gb18030"
    pageEncoding="gb18030"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<title>Insert title here</title>
</head>
<body>
<div>
    <h1>操作普通属性</h1>
    属性name值：<s:property value="name"/>
    <br><hr>
   学号：<s:property value="student.id"/>
  姓名：<s:property value="student.name"/><br>
  say()方法：<s:property value="student.say()"/>
  <br><hr>
  request中的info值：<s:property value="#request['info']"/>
</div>
</body>
</html>