var getCookie = function(cookie_name){
	var allcookies = document.cookie;
	var cookie_pos = allcookies.indexOf(cookie_name);
	
	// 如果找到了索引，就代表cookie存在，
	// 反之，就说明不存在。
	if (cookie_pos != -1){
		// 把cookie_pos放在值的开始，只要给值加1即可。
		cookie_pos += cookie_name.length + 1;
		var cookie_end = allcookies.indexOf(";", cookie_pos);
		
		if (cookie_end == -1)		{
			cookie_end = allcookies.length;
		}
		var value = unescape(allcookies.substring(cookie_pos, cookie_end));
	}
	return value;
} 
//设定Cookie值
function SetCookie(name, value)
{
var expdate = new Date();
var argv = SetCookie.arguments;
var argc = SetCookie.arguments.length;
var expires = (argc > 2) ? argv[2] : null;
var path = (argc > 3) ? '/' : '/';
var domain = (argc > 4) ? '.tieyou.com' : '.tieyou.com';
var secure = (argc > 5) ? argv[5] : false;
if(expires!=null) expdate.setTime(expdate.getTime() + ( expires * 1000 ));
document.cookie = name + "=" + escape (value) +((expires == null) ? "" : ("; expires="+ expdate.toGMTString()))
+((path == null) ? "" : ("; path=" + path)) +((domain == null) ? "" : ("; domain=" + domain))
+((secure == true) ? "; secure" : "");
}
// 顶部待查看样式
function move(a) {
    $(".tiaodong")
        .animate({
                top:a.offset_topA
            },
            o.speed,
            o.fx
        );
}
o = {};
o.spead = 100;
o.move  = 0;
o.fx = function(){
  if(o.move==0){
      o.move  = 1;
      a = {
        offset_topA:"3px"
      };
  }else{
      o.move  = 0;
      a = {
        offset_topA:"0px"
      };
  }
  move(a);
}
$(document).ready(function() {
  o.fx();
});
function topProblemNum(num){
	num = num == undefined ? 0 : num;
	num = parseInt(num);//problemNum
	SetCookie('problem_number',num,110);
	if(num > 0){
		$('#problemNum').html(num);
		$('#tiaodong').show();
	}else{
		$('#tiaodong').hide();	
	}	
}
function getProblemNumber(){
	//加载问题个数
	var userId = getCookie('__P_UserId');
	if(userId){
		var num = getCookie('problem_number');//problemNum
		//if(num == undefined){

			//$.getJSON('https://u.tieyou.com/index.php?param=/consult/getProblemNum&callback=?',function(data){
			var url = "https://order.tieyou.com/index.php?param=/ajax/getTiexiaoerResponse&callback=?";
			$.getJSON(url, {User_Id:userId, Order_Channel:0,Terminal:0, Product_Line:1,Server_Name:'GetReplayCount',sign:true},function(data){	
				var jsObject = eval(data);
				num = jsObject.MessageCount;
				topProblemNum(num);	
			})
//		}else{
//			topProblemNum(num);	
//		}
	}	

}
$(function(){
	getProblemNumber();
	setInterval('getProblemNumber()',120000);
})
// 顶部待查看样式
var isTopLogin = false;
$(document).ready(function(){
	$("a").live("click", function(){
		if(typeof $(this).attr("click_id")!='undefined'){
			SetCookie("click_id", $(this).attr("click_id"));
		}
	});

	$("input").live("click", function(){
		if(typeof $(this).attr("click_id")!='undefined'){
			SetCookie("click_id", $(this).attr("click_id"));
		}
	}); 
	
	$(".f_link_source").live("click", function(){
		SetCookie("link_source", $(this).attr("link_source"));
	}); 
	
	var allcookie = document.cookie;
	var uname = getCookie("__P_userName");
	//var uname = getCookie("__P_UserId");
	var type = getCookie("__P_loginType");

	var order_number = getCookie("__order_number");
	var order_state = getCookie("__order_state");
	var sessionID = getCookie("sessionID");
	//alert(uname);
	//console.log(uname);
	if(uname!="" && uname!=undefined){
		isTopLogin = true;
		var target = '';
		if (typeof $('#loginOrder').attr('target') != 'undefined') {
			target = 'target="' + $('#loginOrder').attr('target') + '"';
		}
        if(unescape(uname)=='尊敬的会员'){
            $(".top_login").html("<li id=\"loginmsg\" class=\"user\">欢迎您！&nbsp;&nbsp;"+unescape(uname)+"!</li>");
        }else{
		$(".top_login").html("<li id=\"loginmsg\" class=\"user\">欢迎您！&nbsp;&nbsp;"+unescape(uname)+"!</li><li>|</li><li><a href=\"https://u.tieyou.com/loginOut.html\">退出</a></li>");
        }
		$("#loginOrder").html("<p><a href=\"https://u.tieyou.com/index.php?param=/member/userCenter\" " + target + " >我的铁友</a></p>");
		$("#login_order").html("<p><a href=\"https://u.tieyou.com/order/trainOrderList.html?action=all\" " + target + " >我的订单</a></p>");

		$("#login_windows").hide();
		$("#onlinekefuqq").show();
	}else{
		$("#login_windows").show();
		$("#onlinekefuqq").hide();		
	}
	
	var usercenterfloat = getCookie("userfloat");
	if(usercenterfloat == "close" ){
		$("#user_float").html("");	
	}else{
		$("#user_float").html("<div id=\"top_ad\"><a href=\"https://u.tieyou.com/order/trainOrderList.html\" class=\"top_link\">登陆注册</a><a href=\"javascript:void(null);\" onclick=\"$('#top_ad').hide()\" id=\"top_close\" class=\"top_close\" >关闭</a></div>");			
	}
	$("#top_close").click(function(event) {
		$("#user_float").hide();
		SetCookie("userfloat", "close");	
	}); 
});