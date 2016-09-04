<%@ page language="java" contentType="text/html; charset=gb18030"
    pageEncoding="gb18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<title>Insert title here</title>
<script type="text/javascript" src="js/AjaxRequest,js"></script>
<script type="text/javascript">
/*****************错误处理的方法***********************/
  function onerror(){
	alert("您的操作有误!");
}
/**************************实例化Ajax对象的方法****************************/
 function getInfo(){
	var loader = new net.AjaxRequest("getInfo.jsp?nocache="+new Date().getTime(),deal_getInfo,onerror,"GET");
}
/**************************回调函数*********************/
 function deal_getInfo(){
	document.getElementById("showInfo").innerHTML= this.req.responseText;
}
</script>
</head>
<body>

</body>
</html>