<%@ page language="java" contentType="text/html; charset=gb18030"
    pageEncoding="gb18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<title>Insert title here</title>
</head>
<body style="margin:0px;">
<c:set var="typeName" value="���н��� |�����ϸ�|����DJ|ŷ������|�ٶ�����|������|�����ϰ�"/>
<c:import url="navigation.jsp" charEncoding="UTF-8">
      <c:param name="typeList" value="${typeName}"></c:param>
</c:import>
</body>
</html>