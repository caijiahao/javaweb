<%@ page language="java" contentType="text/html; charset=gb18030"
    pageEncoding="gb18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<link href="CSS/style.css" rel="stylesheet">
<script language="javascript" src="JS/AjaxRequest.js"></script>
<script type="text/javascript">
function deal(form){
	form.submit();                       //提交表单
	timer=window.setInterval("getProgress()",500);         //每隔500毫秒获取一次上传进度
}

function getProgress(){
	var loader=new net.AjaxRequest("showProgress.jsp?nocache="+new Date().getTime(),deal_p,onerror,"GET");
}

function onerror(){
	alert("上传文件出错！");
}
function deal_p(){
	var h=this.req.responseText;
    h=h.replace(/\s/g,"");	//去除字符串中的Unicode空白符
	document.getElementById("progressPercent").style.display="";	//显示百分比	
	progressPercent.innerHTML=h+"%";		//显示完成的百分比
	document.getElementById("progressBar").style.display="block";	//显示进度条
	document.getElementById("imgProgress").width=h*(255/100);		//显示完成的进度
}
</script>
<title>Insert title here</title>
</head>
<body>
<form action="UpLoad?action=uploadFile" name="form1" enctype="multipart/form-data" method="post">
请选择上传的文件: <input name="file" type="file" size="42">
<img src="images/shangchuan.gif" width="61" height="23" onClick="deal(form1)">
<img src="images/chongzhi.gif" width="61" height="23" onClick="form1.reset();">
<div id="progressBar" class="prog_border" align="left"><img src="images/progressBar.jpg" width="0" height=
"13" id="imgProgress"></div>
?<span id="progressPercent" style="width:40px;display:none">0%</span>
</form>
</body>
</html>