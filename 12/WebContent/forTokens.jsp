<%@ page language="java" contentType="text/html; charset=gb18030"
    pageEncoding="gb18030"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<title>Insert title here</title>
</head>
<body>
<c:set var="sourceStr" value="Java Web�����򿪷��������䣻����ģ���ȫ��Java:ʵ����ȫ��ѧ�ֲ�"></c:set>
<b>ԭ�ַ�����</b><c:out value="${sourceStr}"></c:out>
<br><b>�ָ����ַ�����</b><br>
<c:forTokens items="${sourceStr}" delims="��" var="item">
${item}<br>
</c:forTokens>
</html>