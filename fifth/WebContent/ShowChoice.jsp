<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>��ʾ�û���ѡ��</title>
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
	msg="��ѡ���Ա�<br>";
}
if(sex.equals("��")){
	msg="������ã�<br>";
}
if(sex.equals("Ů")){
	msg="Ůʿ��ã�<br>";
}
if(len==0){
	msg=msg+"��ѡ����ϲ����ˮ��!";
}else{
	out.print("<p>лл��Ĳ���</p><br>");
	msg=msg+"��ѡ���ˣ�";
	for(int i =0;i<len;i++){
		msg = msg + fruit[i]+"/";
	}
}
out.print(msg);
%>
</center>
</body>
</html>