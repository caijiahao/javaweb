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
<h2>�û�ע��</h2>
<s:form action="userAction" method="post">
  <s:textfield name="name" label="�û���" required="true" requiredposition="left"></s:textfield>
  <s:password name="password" label="����" required="true" requiredposition="left"></s:password>
  <s:radio name="sex" list="#{1:'��',0:'Ů' }" label="�Ա�" required="true" requiredposition="left"></s:radio>
  <s:select list="{'��ѡ��ʡ��','����','�㶫','ɽ��','����'}" name="province" label="ʡ��"></s:select>
  <s:checkboxlist list="{'����','��ë��','ƹ����','����'}" name="hobby" label="����"></s:checkboxlist>
  <s:textarea name="description" cols="30" rows="5" label="����"></s:textarea>
  <s:submit value="ע��"></s:submit>
  <s:reset value="����"></s:reset>
</s:form>
</body>
</html>