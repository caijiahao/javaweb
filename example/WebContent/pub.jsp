<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<form action="pub_do.jsp" method="post">
<table width="600" border="0">
<tr>
 <th scope="col">���ŷ���ϵͳ</th>
 </tr>
 <tr>
   <td><div align="center">���ű��⣺
       <input name="title" type="text" size="60"/>
   </div>
   </td>
   </tr>
   <tr>
   <td><hr size="2"/></td>
   </tr>
   <tr>
     <td><div align="center">��������</div></td>
     </tr>
     <tr>
       <td><div align="center">
       <textarea name="content" cols="65" rows="15"></textarea>
       </div></td>
     </tr>
     <tr>
       <td><hr size="2"/></td>
     </tr>
     <tr>
       <td><div align="center">
       <input type="submit" name="Submit" value="����"/>
       </div></td>
</table>
</form>
</body>
</html>