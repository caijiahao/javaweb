<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>初始页面</title>
</head>
<body>
  <h2>struts2的HelloWorld练习</h2>
  <form action="hello" method="post">
  <label for="name">输入您的名字：</label>
  <input type="text" name="name"/>
  <label for="class">班级:</label>
  <input type="text" name="className"/>
  <label for="stuId">学号:</label>
  <input type="text" name="stuId"/>
  <label for="age">年龄:</label>
  <input type="text" name="age"/>
  <input type="submit" value="显示">
  </form>
</body>
</html>