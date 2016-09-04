<%@ page language="java" contentType="text/html; charset=gb18030"
    pageEncoding="gb18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<title>我的观点</title>
</head>
<body>
<center>  
    <fieldset style="width:300px;">  
        <legend>我的观点</legend>  
    <form action="CharacterWrapper.jsp" method="post" onsubmit="return getTe()">  
        <input type="text" name="te" value="100字以内" id="te" style="width:200px;height:150px;borderColor:blue"/><br/>  
        <input type="submit" value="提    交" style="margin-left:120px"/>  
    </form>  
    </fieldset>  
</center>  
</body>
</html>