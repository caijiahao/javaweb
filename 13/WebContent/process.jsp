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
	form.submit();                       //�ύ��
	timer=window.setInterval("getProgress()",500);         //ÿ��500�����ȡһ���ϴ�����
}

function getProgress(){
	var loader=new net.AjaxRequest("showProgress.jsp?nocache="+new Date().getTime(),deal_p,onerror,"GET");
}

function onerror(){
	alert("�ϴ��ļ�����");
}
function deal_p(){
	var h=this.req.responseText;
    h=h.replace(/\s/g,"");	//ȥ���ַ����е�Unicode�հ׷�
	document.getElementById("progressPercent").style.display="";	//��ʾ�ٷֱ�	
	progressPercent.innerHTML=h+"%";		//��ʾ��ɵİٷֱ�
	document.getElementById("progressBar").style.display="block";	//��ʾ������
	document.getElementById("imgProgress").width=h*(255/100);		//��ʾ��ɵĽ���
}
</script>
<title>Insert title here</title>
</head>
<body>
<form action="UpLoad?action=uploadFile" name="form1" enctype="multipart/form-data" method="post">
��ѡ���ϴ����ļ�: <input name="file" type="file" size="42">
<img src="images/shangchuan.gif" width="61" height="23" onClick="deal(form1)">
<img src="images/chongzhi.gif" width="61" height="23" onClick="form1.reset();">
<div id="progressBar" class="prog_border" align="left"><img src="images/progressBar.jpg" width="0" height=
"13" id="imgProgress"></div>
?<span id="progressPercent" style="width:40px;display:none">0%</span>
</form>
</body>
</html>