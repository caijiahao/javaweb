<%@ page language="java" contentType="text/html; charset=gb18030"
    pageEncoding="gb18030"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<title>Insert title here</title>
</head>
<body>
<ul>
<li>����request ��Χ�ڵı��� username </li>
<br>
<c:set var="username" value="���տƼ�" scope="request"></c:set>
<c:out value="username��ֵΪ:${username}"></c:out>
<li>����UserInfo�����name����</li>
<jsp:useBean class="com.wgh.UserInfo" id="userInfo"></jsp:useBean>
<c:set target="${userInfo}" property="name">fuck</c:set>    <!-- �м�������Ǹ�ֵ������ -->
<br>
<c:out value="UserInfo ��  name ����ֵΪ:${userInfo.name}"></c:out>
<li>����request��Χ�ڵı���username</li>
<br>
<c:set var="username" value="���տƼ�" scope="request"></c:set>
username ��ֵΪ��<c:out value="${username}"></c:out>
<li>�Ƴ�request��Χ�ڵı���username</li>
<br>
<c:remove var="username" scope="request"></c:remove>
username��ֵΪ��<c:out value="${username}" default="��"></c:out>
</ul>
</body>
</html>