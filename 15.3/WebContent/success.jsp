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
<div>
<h2>�û�ע����Ϣ</h2>
<ul>
<li>�û�����<s:property value="name"/></li>
<li>���룺<s:property value="password"/></li>
<li>�Ա�<s:if test="sex==0">Ů</s:if><s:else>��</s:else></li>
<li>ʡ��:��<s:property value="province"/></li>
<li>���ã�<s:property value="hobby"/></li>
<li>������<s:property value="description"/></li>
</ul>
</div>
</body>
</html>