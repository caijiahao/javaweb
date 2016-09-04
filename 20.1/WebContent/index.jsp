<%@ page language="java" contentType="text/html; charset=gb18030"
    pageEncoding="gb18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<title>Insert title here</title>
</head>
<body>
<form name="form1" method="post" action="PlacardServlet" target="_blank" onsubmit="return check(this)">
公告标题:<input name="title" type="text" id="title" size="52">
公告内容:<textarea rows="9" cols="50" id="content" name="content"></textarea>
<input name="Submit" type="submit" class="btn_grey" value="保存">
<input name="Submit" type="reset" class="btn_grey" value="重置">
</form>
</body>
</html>