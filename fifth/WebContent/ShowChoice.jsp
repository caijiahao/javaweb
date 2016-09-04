<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>显示用户的选择</title>
</head>
<body>
<center>
<%
request.setCharacterEncoding("gb2312");
String msg="";
String sex=request.getParameter("sex");
String[] fruit=request.getParameterValues("fruit");
int len = fruit.length;
if(sex==null){
	msg="请选择性别<br>";
}
if(sex.equals("男")){
	msg="先生你好！<br>";
}
if(sex.equals("女")){
	msg="女士你好！<br>";
}
if(len==0){
	msg=msg+"请选择你喜爱的水果!";
}else{
	out.print("<p>谢谢你的参与</p><br>");
	msg=msg+"你选择了：";
	for(int i =0;i<len;i++){
		msg = msg + fruit[i]+"/";
	}
}
out.print(msg);
%>
</center>
</body>
</html>