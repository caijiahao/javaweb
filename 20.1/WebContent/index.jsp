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
�������:<input name="title" type="text" id="title" size="52">
��������:<textarea rows="9" cols="50" id="content" name="content"></textarea>
<input name="Submit" type="submit" class="btn_grey" value="����">
<input name="Submit" type="reset" class="btn_grey" value="����">
</form>
</body>
</html>