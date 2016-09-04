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
<li>定义request 范围内的变量 username </li>
<br>
<c:set var="username" value="明日科技" scope="request"></c:set>
<c:out value="username的值为:${username}"></c:out>
<li>设置UserInfo对象的name属性</li>
<jsp:useBean class="com.wgh.UserInfo" id="userInfo"></jsp:useBean>
<c:set target="${userInfo}" property="name">fuck</c:set>    <!-- 中间的内容是赋值的内容 -->
<br>
<c:out value="UserInfo 的  name 属性值为:${userInfo.name}"></c:out>
<li>定义request范围内的变量username</li>
<br>
<c:set var="username" value="明日科技" scope="request"></c:set>
username 的值为：<c:out value="${username}"></c:out>
<li>移除request范围内的变量username</li>
<br>
<c:remove var="username" scope="request"></c:remove>
username的值为：<c:out value="${username}" default="空"></c:out>
</ul>
</body>
</html>