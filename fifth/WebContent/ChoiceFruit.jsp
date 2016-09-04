<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>选择你喜欢的水果</title>
</head>
<body>
<div align="center">
<p><strong>
请选择你喜欢的水果（可以多选）
</strong></p>
<form name="form1" method="post" action="ShowChoice.jsp">
<input type="checkbox" name="fruit" value="香蕉">
香蕉
<input type="checkbox" name="fruit" value="橘子">
橘子
<input type="checkbox" name="fruit" value="葡萄">
葡萄
<input type="checkbox" name="fruit" value="都不喜欢">
都不喜欢
<p><strong>
你的性别：
</strong>
<input type="radio" name="sex" value="男">男
<input type="radio" name="sex" value="女">女
</p>
<p>
<input type="submit" name="Submit" value="提交">
</p>
</form>
</div>
</body>
</html>