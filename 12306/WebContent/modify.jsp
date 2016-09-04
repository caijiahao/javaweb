<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息修改</title>
<link rel="stylesheet" type="text/css" href="个人信息-我的铁友-铁友旅行网_files/base.css">
<link rel="stylesheet" type="text/css" href="个人信息-我的铁友-铁友旅行网_files/user20130319.css">
<script src="./个人信息-我的铁友-铁友旅行网_files/hm.js"></script><script type="text/javascript" src="./个人信息-我的铁友-铁友旅行网_files/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="个人信息-我的铁友-铁友旅行网_files/global.js"></script>
<script type="text/javascript" src="个人信息-我的铁友-铁友旅行网_files/loginInfoUtf8_qianyi.js"></script>
</head>
<body>
<div class="top">
	<div class="w960_2">
		<ul class="top_login" id="top_login"><li id="loginmsg" class="user">欢迎您！&nbsp;&nbsp;<s:property value="#session.user.username"/>!</li><li>|</li><li><a href="https://u.tieyou.com/loginOut.html">退出</a></li></ul>
		<ul class="top_help">
            <li class="top_menu_down_ty">
                <span><a rel="nofollow" href="https://u.tieyou.com/passport/login.html" id="loginOrder"><p><a href="https://u.tieyou.com/index.php?param=/member/userCenter" target="">我的12306</a></p></a></span>
                <div class="toporder">
                    <dl>
                        <dt><a href="https://u.tieyou.com/passport/login.html" target="_blank">12306订单</a></dt>
                        <dt><a href="https://u.tieyou.com/passport/login.html&searchOrder&isVistor=Y" target="_blank">访客订单</a></dt>
                    </dl>
                </div>
            </li>

			<li>|</li>
			<li id="order">
				<span class="ico_kf"><a id="user_kefuurl" href="#">客服中心</a></span>
			</li>
			<li onclick="javascript:window.location.href=''" id="tiaodong" style="display:none;cursor:pointer"><strong class="tip_num tiaodong" style="top: 0.861331px;"><em id="problemNum">0</em></strong></li>
			<li>|</li>
			<li class="top_menu_down">
				<span><a href="http://www.tieyou.com/help/help.html">网站导航</a></span>
				<div class="top_tip2">
					<dl>
						<dt>火车票</dt>
						<dd>
							<a href="#" target="_blank">火车时刻表</a>
							<a href="#" target="_blank">火车票余票查询</a>
							<a href="#" target="_blank">火车车次查询</a>
							<a href="#" target="_blank">火车票预售期</a>
							<a href="#" target="_blank">火车票价查询</a>
							<a href="#" target="_blank">铁路网上订票官网</a>
							<a href="#" target="_blank">火车票查询</a>
							<a href="#" target="_blank">火车票代售点</a>
							<a href="#" target="_blank">动车</a>
							<a href="#" target="_blank">高铁</a>
							<a href="#" target="_blank">欧洲火车通票</a>
							<a href="#" target="_blank">手机订火车票</a>
						</dd>
					</dl>
					<dl>
						<dt>旅行服务</dt>
						<dd>
							<a href="#" target="_blank">携程网酒店预订</a>
							<a href="#" target="_blank">酒店团购</a>
							<a href="#" target="_blank">机票查询</a>
							<a href="#" target="_blank">旅游网站大全</a>
							<a href="#" target="_blank">铁友知道</a>
							<a href="#" target="_blank">天气预报查询一周</a>
						</dd>
					</dl>
					<dl>
						<dt>铁友热点</dt>
						<dd>
							<a href="#" target="_blank">高铁网上订票</a>
							<a href="#" target="_blank">火车票网上订票官网</a>
							<a href="#" target="_blank">取票</a>
							<a href="#" target="_blank">动车时刻表</a>
							<a href="#" target="_blank">哈大高铁</a>
							<a href="#" target="_blank">石武高铁</a>
							<a href="#" target="_blank">京广高铁</a>
							<a href="#" target="_blank">京沈高铁</a>
							<a href="#" target="_blank">郑武高铁</a>
							<a href="#" target="_blank">荆州火车站</a>
							<a href="#" target="_blank">12306</a>
							<a href="#" target="_blank">7天连锁酒店官网</a>
							<a href="#" target="_blank">如家快捷酒店</a>
							<a href="#" target="_blank">汉庭快捷酒店</a>
							<a href="#" target="_blank">布丁酒店</a>
							<a href="#" target="_blank">电话订票</a>
							<a href="#" target="_blank">春运火车票</a>
							<a href="#" target="_blank">火车票退票</a>
							<a href="#" target="_blank">学生证买火车票</a>
							<a href="#" target="_blank">虹桥火车站</a>
							<a href="#" target="_blank">Trainticketbooking</a>
						</dd>
					</dl>
				</div>
			</li>


			<li>|</li>
          <li id="navigation" class="top_menu_down_gq">
           	<span><a class="gq_yg" href="http://english.ctrip.com/trains/" target="_blank" rel="nofollow"></a></span>
            <div class="guoqiList">
                <dl>
                    <dt><a class="gq_jp" href="http://jp.ctrip.com/trains/" target="_blank" rel="nofollow"></a></dt>
                    <dt><a class="gq_kr" href="http://kr.ctrip.com/trains/" target="_blank" rel="nofollow"></a></dt>
                    <dt><a class="gq_fr" href="http://fr.ctrip.com/trains/" target="_blank" rel="nofollow"></a></dt>
                    <dt><a class="gq_de" href="http://de.ctrip.com/trains/" target="_blank" rel="nofollow"></a></dt>
                    <dt><a class="gq_es" href="http://es.ctrip.com/trains/" target="_blank" rel="nofollow"></a></dt>
                    <dt><a class="gq_ru" href="http://ru.ctrip.com/trains/" target="_blank" rel="nofollow"></a></dt>
                </dl>
            </div>
          </li>

		</ul>

		<div class="kefu_ico" id="kefu_ico" style="">
	<li class="dingdan"><a href="https://u.tieyou.com/index.php?param=/consult/userCenter&act=searchOrder">订单状态</a></li>
	<li class="kefu">
		<a rel="nofollow" id="userleft_kefuurl" target="_blank" class="kefu_btn" href="https://u.tieyou.com/index.php?param=/consult/zixunIndex&act=myconsult&pageID=tieyouZ&Product_Line=1">在线客服</a>

	</li>
	<li class="kefu2">
		<a href="javascript://" id="yiban" class="yiban kefu_btn_click">一般问题咨询</a>
		<a href="javascript://" id="tuipiao" class="tuipiao kefu_btn_click">退票问题咨询</a>
		<a href="javascript:void(0)" class="kefu_up" onclick="KefuShow()">收起</a>
	</li>
	<li class="tuipiao">
		<a rel="nofollow" href="#">退票改签</a>
	</li>
	<li class="shoucang" id="shoucang"><a href="javascript:void(0)">收藏12306</a></li>
	<div class="topTip" id="shoucangTip" style="display: none;"><p>你的浏览器不支持自动加收藏<br>请按Ctrl+d加入收藏</p></div>
</div>
	</div>
</div>
<div class="w960 header">
	<h1>
    	<a id="firstA" title="铁友网" href="http://www.tieyou.com/">携程旗下网站 铁友旅行网</a>
		<a title="火车票" href="http://www.tieyou.com/">火车票</a>
	</h1>
		<ul class="head_rit_btn">
    	<li class="top_zxtp"><a href="#">在线退票</a></li>
        <li class="top_zxkf"><a target="_blank" id="usernotice_kefuurl" href="#">咨询客服</a></li>
    </ul>
		<div class="head_ad">
	</div>
</div>
<script>
	$(function() {
		$('.top_menu_down').mouseover(function() {
			$(this).removeClass('top_menu_down').addClass('top_menu_up');
		}).mouseout(function(){
			$(this).removeClass('top_menu_up').addClass('top_menu_down');
		});
        $('.top_menu_down_ty').mouseover(function() {
            $(this).removeClass('top_menu_down_ty').addClass('top_menu_up_ty');
        }).mouseout(function(){
                    $(this).removeClass('top_menu_up_ty').addClass('top_menu_down_ty');
        });
    })
</script><div class="w960 user_bg">
	<!--左侧菜单 star-->
	<script type="text/javascript">
	var timeout         = 0;
	var closetimer		= 0;
	var ddmenuitem      = 0;
	
	function mopen(id)
	{	
		mcancelclosetime();
	
		if(ddmenuitem) ddmenuitem.style.visibility = 'hidden';
	
		ddmenuitem = document.getElementById(id);
		ddmenuitem.style.visibility = 'visible';
		ddmenuitem.style.display = "block";
	}
	function mclose()
	{
		if (ddmenuitem) {
			ddmenuitem.style.visibility = 'hidden';
			ddmenuitem.style.display = "none";
		}
	}
	
	function mclosetime()
	{
		closetimer = window.setTimeout(mclose, timeout);
	}
	
	function mcancelclosetime()
	{
		if(closetimer)
		{
			window.clearTimeout(closetimer);
			closetimer = null;
		}
	}
	
	document.onclick = mclose; 
</script>
<div class="w150 fl">
	<dl class="l_menu">
		<dt>
			<a><img src="./个人信息-我的铁友-铁友旅行网_files/avatar0.png"></a>
            <a href="#" title="更换头像" class="avatar_edit">更换头像</a>		</dt>
		<dd class="user_rlst">
			<ol>
				<li><a class="uesr_name" id="user_nick_name" href="#"><s:property value="#session.user.username"/></a></li>
                                <li class="user_lv" style="display:none;"><a href="http://kefu.tieyou.com/wenti/1219" onmouseover="" onmouseout="mclosetime();" target="_blank" id="level_name"></a></li>
				<li onmouseover="" onmouseout="mclosetime();" style="display:none;">积分<strong style="cursor:pointer;" onclick="location.href=''" id="member_integral"></strong></li>
			                </ol>
            			<div class="tq_txt2" id="hyjf" style="display:none;">
            </div>
            <div class="tq_txt2" id="hydj" style="display:none;">
            </div>
            		</dd>

        <dd class="clear"><a target="_blank" href="http://kefu.tieyou.com/wenti/1221">如何获取积分？</a></dd>
        		<dd class="tq_ico" id="level_privilege" style="display:none;">
				<label>我的特权</label>
				<p>
					<a class="ico_vip" id="ico_tq1" onmouseover="" onmouseout="mclosetime();"></a>
					<a class="ico_quan" id="ico_tq2" onmouseover="" onmouseout="mclosetime();"></a>
					<a class="ico_img1" id="ico_tq3" onmouseover="" onmouseout="mclosetime();"></a>
					<a class="ico_zk" id="ico_tq4" onmouseover="" onmouseout="mclosetime();"></a>
					</p><div class="tq_txt1" id="tq1">
                	</div>
					<div class="tq_txt1" id="tq2">
                	</div>
					<div class="tq_txt1" id="tq3">
                	</div>
					<div class="tq_txt1" id="tq4">
                	</div>
				<p></p>
			</dd>
		<dd>

		</dd><dd>

			<ol class="rit_nav">

				<li class="ico6" style="cursor:pointer;"><a style="cursor:pointer;" href="#">我的12306</a></li>

                <li class="ico1"><a>我的订单</a></li>
				<li class="nav_z">
					<a href="https://u.tieyou.com/order/trainOrderList.html">火车订单</a>

                        <a href="https://u.tieyou.com/order/busOrderList.html">汽车订单</a>
                        <a href="https://u.tieyou.com/order/hotelOrderList.html">酒店订单</a>
                        
				</li>

				<li class="ico2"><a href="#">我的积分</a></li>
				<li class="ico4"><a>我的优惠券</a></li>
				<li class="nav_z">
					<a href="#">铁友现金券</a>
					<a href="#">站外优惠券</a>
				</li>

				<li class="ico5">
					<a href="#" id="myZixun">我的咨询</a>
					<script>
						$('#myZixun').click(function(){
							SetCookie('__P_ConsultId', null);
						});
					</script>
				</li>

			</ol>

			<ul class="info_list">
				<li><a href="./个人信息-我的铁友-铁友旅行网_files/个人信息-我的铁友-铁友旅行网.html" class="now">个人设置</a></li>
			</ul>

		</dd>
        	</dl>
</div>




	<!--右侧内容 star-->
	<div class="w800 fr">
		<div class="user_box">
			<div class="user_tab mt_5">
	<ul class="r_tab_ul">
		<li class="now"><a href="./个人信息-我的铁友-铁友旅行网_files/个人信息-我的铁友-铁友旅行网.html">个人信息</a></li>
		<!-- <li><a href="https://u.tieyou.com/account/bindAccount.html">手机</a></li>
				<li><a href="https://u.tieyou.com/member/modifyPassword.html">修改密码</a></li>
		<li><a href="https://u.tieyou.com/signjoint/share.html">分享设置</a></li>
		<li><a href="https://u.tieyou.com/member/avatar.html">头像设置</a></li> -->
		<!--<li ><a href="/member/bond12306Info.html">认证信息</a></li>-->
	</ul>
</div>			<div class="r_bot_line"></div>
			<div class="dd_line2">
            	<s:form method="post" action="saveInfo" id="memberInfoForm">
            	<input type="hidden" name="token" value="f7305989a4a231ffbc80e25f1b12c80e">
            	<ul class="xinxi_ul">
            		<li>
                    	<label class="fl"><b>*</b>您的真实姓名</label>
                        <p class="fl"><input class="fl xinxiTxt_bg inpTxt_w1" type="text" id="realname" name="realname" value="<s:property value="#session.user.realname"/>">请如实填写您的真实姓名，以方便我们跟您联系。</p>
                    </li>
                    <li>
                    	<label class="fl">性别</label>
                       	<p class="fl">
                        	<input type="radio" id="sex1" name="sex" value="1" <s:if test="#session.user.sex==1" >checked="checked"</s:if>><label>男</label>
                        	<input type="radio" id="sex2" name="sex" value="0" <s:if test="#session.user.sex==0" >checked="checked"</s:if>><label>女</label>
                        </p>
                    </li>
                    <li>
                    	<label class="fl">证件类型</label>
                       	<p class="fl">
                        	<s:select name="certType" theme="simple" type="text" id="certType" list="#{1:'二代身份证',2:'港澳通行证',3:'台湾通行证',4:'护照'}" value="<s:property value='#session.user.certificateType'/>"/>
                        </p>
                    </li>
                    <li>
                    	<label class="fl"><b>*</b>证件号码</label>
                        <p class="fl"><input class="fl xinxiTxt_bg inpTxt_w1" type="text" id="cert" name="cert" value="<s:property value="#session.user.certificateNumber"/>">请如实填写您的真实证件号。</p>
                    </li>
                    <li>
                    	<label class="fl">旅客类型</label>
                       	<p class="fl">
                        	<s:select name="touristType" theme="simple" cssClass="text_cray" id="touristType" list="#{1:'成人',2:'儿童',3:'学生',4:'残疾军人、伤残人民警察'}" value="<s:property value='#session.user.certificateType'/>"/>
                        </p>
                    </li>
                    <li>
                    	<label class="fl"><b>*</b>详细地址</label>
                        <p class="fl">
                       	<textarea class="fl xinxiTxt_bg" name="streetexplicit" id="streetexplicit"><s:property value="#session.user.address"/></textarea>
                        </p>
                    </li>
                   <%--  <li>
                    	<label class="fl"><b>*</b>您的电话号码</label>  
                        <p class="fl">
                        	<input class="fl xinxiTxt_bg inpTxt_w2" id="tel1" maxlength="4" type="text" name="tel1" value="">
                            <span class="fl">-</span>
                            <input class="fl xinxiTxt_bg inpTxt_w1" id="tel2" maxlength="15" type="text" name="tel2" value="">
                            <span class="fl">-</span>
                            <input class="fl xinxiTxt_bg inpTxt_w2" type="text" name="tel3" value="" maxlength="8">
                            区号-电话号码-分机
                        </p>
                    </li>   --%>
                     <%-- <li>
                    	<label class="fl"><b>*</b>您的地址</label>  
                        <p class="fl">
                        	<input class="fl xinxiTxt_bg inpTxt_w2" id="tel1" maxlength="4" type="text" name="province" value="">
                            <span class="fl">-</span>
                            <input class="fl xinxiTxt_bg inpTxt_w1" id="tel2" maxlength="15" type="text" name="city" value="">
                        </p>
                    </li>     --%>
                    <li>
                       <label class="fl"><b>*</b>原密码</label>
                        <p class="fl">
                        <input class="fl xinxiTxt_bg inpTxt_w1" type="password" id="sourcepassword" name="sourcepassword" value="">填写你的原密码。
                        </p>
                    </li> 
                 
                    <li>
                    <label class="fl"><b>*</b>新密码</label>
                     <p class="fl">
                        <input class="fl xinxiTxt_bg inpTxt_w1" type="password" id="newPassword" name="newPassword" value="">填写你的新密码。
                        </p>
                    </li>                                                                          
            	</ul>
                <div class="xinxi_btn">
                	<!-- <input type="submit" id="postreg" value="修改"> -->
                	<s:submit value="修改"></s:submit>
                </div>            	
            	</s:form>
	        </div>
		</div>
	</div>
	<!--右侧内容 end-->
</div>


<!--无票推荐手机客户端下载-->
<div id="wapunload" style="display:none;">
	<div class="shadow"></div>
    <div class="tipWin tip_app">
        <a href="javascript:void(0);" class="tipWin_close"></a>
        <dl>
        	<dt>下载铁友火车票超级版</dt>
        	<dd class="fl">
        		<label>短信获取下载链接</label>
        		<input type="text" value="输入手机号码" class="txt190" id="wh_txt190">
        		<div class="warn_box">
        			<p class="red" id="phonefomat" style="display:none">手机号码格式有误</p>
        			<p class="green" id="psuccfomat" style="display:none">短信已发送，<span id="daojishi"></span>秒后重新发送</p>
        		</div>
        		<input type="button" value="免费发送" class="btn_send" id="btn_send_12306"><!--不可按时用“btn_send_off”-->
        		<div class="app_arr">
        			手机扫描二维码下载
        		</div>
        	</dd>
        	<dd class="fr">
        		<img src="./个人信息-我的铁友-铁友旅行网_files/user_ewm.gif">
        	</dd>
        </dl>
        <br class="clear">
    </div>
</div>  
<div class="w960 copyright">
	<p>
		<a target="_blank" href="#">关于我们</a> |
		<a target="_blank" href="#">免责声明</a> | 
		<a target="_blank" href="#">常见问题</a> |
		<a target="_blank" href="#">服务说明</a> | 
		<a target="_blank" href="#">申请加盟</a> |  
		<a target="_blank" href="#">友情链接</a> | 
		<a target="_blank" href="#">人才招聘</a> | 
		<a target="_blank" href="#">联系我们</a> | 
		<a onclick="" class="weibo" target="_blank" href="#">关注铁友网</a>
		|<a href="#" rel="nofollow" target="_blank">保险代理</a>
	</p>
	Copyright&nbsp;<a title="火车票" href="#">www.tieyou.com</a>&nbsp;2009-2013&nbsp;沪ICP备09057645号-2
</div>
<div id="Vidown_extension_alhnopeoagjmjfgcbnokcnagkecgdcdh" style="display: none;"></div>
</body>
</html>