<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<%
Object oCount = application.getAttribute("count");

Integer count = null;
if(oCount==null){
	count = new Integer(1);
}else{
	count=(Integer)application.getAttribute("count");
	count=new Integer(count.intValue()+1);
}
application.setAttribute("count", count);
%>
</head>
<body>
<br>
<h3>�𾴵ķÿͣ����ã���ӭ���ĵ�����</h3>
��������ĵ�<font color="red"><%=count.intValue() %></font>λ�ÿͣ�ף����Ŀ��֣�
</body>
</html>