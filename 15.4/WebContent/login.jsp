<%@ page language="java" contentType="text/html; charset=gb18030"
    pageEncoding="gb18030"%>
      <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<title>Insert title here</title>
</head>
<body>
<s:form action="userAction" method="post">
<s:textfield name="username" label="�û���" required="true"></s:textfield>
<s:password name="password" label="����" required="true"></s:password>
<s:submit key="submit" value="��¼"></s:submit>
</s:form>
</body>
</html>