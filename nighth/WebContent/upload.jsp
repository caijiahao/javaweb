<%@ page language="java" contentType="text/html; charset=gb18030"
    pageEncoding="gb18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<title>文件上传</title>
</head>
<body>
<form action="UploadServlet" enctype="multipart/form-data" method="post">
选择文件<input type="file" name="file1" id="file1">
<input type="submit" name="upload" value="上传"/>
</form>
</body>
</html>