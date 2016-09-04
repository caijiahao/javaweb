<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script language="javascript" type="text/javascript">
var interval = 1000;
function ShowCountDown(year,month,day,divname){
	var now =new Date();
	var endDate = new Date(year,month-1,day);
	var leftTime = endDate.getTime()-now.getTime();
	var leftsecond = parseInt(leftTime/1000);
	var  day1 = Math.floor(leftsecond/(60*60*24));
	var hour=Math.floor((leftsecond-day1*24*60*60)/3600); 
	var minute=Math.floor((leftsecond-day1*24*60*60-hour*3600)/60); 
	var second=Math.floor(leftsecond-day1*24*60*60-hour*3600-minute*60); 
	var cc= document.getElementById(divname);
	cc.innerHTML ="½Å±¾Ö®¼Ò¾àÀëÌáÊ¾"+year+"Äê"+month+"ÔÂ"+day+"ÈÕ»¹ÓÐ:"+day1+"Ìì"+hour+"Ð¡Ê±"+minute+"·Ö"+second+"Ãë";
	
}
window.setInterval(function(){ShowCountDown(2017,4,20,'divdown1');},interval);
</script>
</head>
<body>
<div id="divdown1"></div> 
</body>
</html>