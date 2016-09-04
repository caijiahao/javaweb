<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册信息</title>
<link href="css/css.css" rel="stylesheet" type="text/css">
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<s:form action="register" method="post" theme="simple">

<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="2" background="images/ny_top_img_bg.gif"><img src="images/ny_top_img.gif" width="650" height="108"></td>
    </tr>
  <tr>
    <td width="75" height="23" bgcolor="#deedf8">&nbsp;</td>
    <td width="958" align="left" bgcolor="#deedf8" class="text_cray1">当前位置:注册信息　</td>
    </tr>
</table>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td background="images/bg_point_write.gif"><table width="835" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="30" colspan="2" align="center">&nbsp;</td>
        </tr>
      <tr>
        <td width="41" height="7" align="center">&nbsp;</td>
        <td width="794" height="30" align="left" valign="top"><span class="text_blod_title">注册信息</span></td>
      </tr>
      <tr>
        <td height="15" colspan="2" align="center"><img src="images/line1.jpg" width="835" height="6"></td>
      </tr>
      <tr>
        <td colspan="2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="5%">&nbsp;</td>
            <td width="95%" align="left" class="text_cray">注：标有 <span class="text_red">*</span> 处，均为必填项</td>
          </tr>
          <tr>
            <td height="15" colspan="2">&nbsp;</td>
            </tr>
          
        </table>
          <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="30" colspan="4" align="left" class="text_red1"><span class="text_title">登录信息</span></td>
                </tr>
          
          <tr>
            <td width="19" align="center" class="text_red">*</td>
                  <td width="98" height="40" align="left" class="text_cray1">登录名：</td>
                  <td width="160" align="left" class="text_cray1">
                  <s:textfield theme="simple" id="username" name="username" cssClass="text_cray"></s:textfield></td>
                  <td width="423" height="35" align="left" class="text_cray">由字母、数字或“_”组成，长度不少于6位，不多于30位</td>
                </tr>
          <tr>
            <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">密码：</td>
                  <td align="left" class="text_cray1"><s:password theme="simple" id="password" name="password" cssClass="text_cray"></s:password></td>
                  <td height="35" align="left" class="text_cray">不少于6位字符</td>
                </tr>
          <tr>
            <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">确认密码：</td>
                  <td align="left" class="text_cray1">
                  <s:password theme="simple" id="password2" name="password2" cssClass="text_cray"></s:password></td>
                  <td height="35" align="left" class="text_cray">请再次输入密码</td>
                </tr>
        </table>
          <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td height="35" colspan="5" align="left" class="text_red1"><span class="text_title">详细信息</span></td>
                </tr>
            
            <tr>
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">真实姓名：</td>
                  <td height="35" colspan="3" align="left">
                  <s:textfield theme="simple" id="realname" name="realname" cssClass="text_cray"/></td>
                </tr>
            <tr>
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">性 别：</td>
                  <td height="35" colspan="3" align="left" class="text_cray1">
                  <s:radio list="#{1:'男',2:'女'}" name="sex" value="1"></s:radio>
                   		</td>
                </tr>
            <tr>
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">省份：</td>
                  <td width="104" height="35" align="left">
                  <s:select name="province" theme="simple" cssClass="text_cray" id="province" list="{'省份'}"></s:select></td>
                  <td width="43" height="35" align="left"  class="text_cray">城市：</td>
                  <td width="436" height="35" align="left" class="text_cray">
                  <s:select name="city" theme="simple" cssClass="text_cray" id="city" list="{'市县'}"></s:select></td>
                </tr>
            <tr>
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">证件类型：</td>
                  <td height="35" colspan="3" align="left">
                  <s:select name="certType" theme="simple" cssClass="text_cray" id="certType" list="#{1:'二代身份证',2:'港澳通行证',3:'台湾通行证',4:'护照'}"/>
         			</td>
                </tr>
            <tr>
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">证件号码：</td>
                  <td height="35" colspan="3" align="left">
                   <s:textfield theme="simple" id="cert" name="cert" cssClass="text_cray"/></td>
                </tr>
            <tr>
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">出生日期：</td>
                  <td height="35" colspan="3" align="left">
                  <s:textfield theme="simple" id="birthday" name="birthday" cssClass="text_cray"/></td>
                </tr>
            
            <tr>
              <td width="19" align="center">&nbsp;</td>
                  <td width="98" height="40" align="left" class="text_cray1">旅客类型：</td>
                  <td height="35" colspan="3" align="left">
                  <s:select name="userType" theme="simple" cssClass="text_cray" id="userType" list="#{1:'成人',2:'儿童',3:'学生',4:'残疾军人、伤残人民警察'}"/>
         		  </td>
                </tr>
            <tr>
              <td height="10" colspan="5" align="center">	</td>
	            </tr>
           <tr>
              <td width="19" align="center">&nbsp;</td>
                  <td width="98" height="30" align="left" class="text_cray1">备注：</td>
                  <td colspan="3" align="left" height="80">
                  <s:textarea name="content" rows="8" cssStyle="width:100%"></s:textarea></td>
                </tr>
            
            
            
            <tr>
              <td align="center">&nbsp;</td>
                  <td height="30" align="left" class="text_cray1"></td>
                  <td height="50" colspan="3" align="left" valign="middle" class="text_cray1">
                  <s:checkbox name="checkAgree" id="checkAgree" cssClass="check" fieldValue="true"></s:checkbox>
                  我已阅读并同意遵守				<a href="/otn/regist/rule;jsessionid=FA97B306AACF75E37DD4D10CFD59994A" class="ft14" target="_blank" shape="rect"> 《中国铁路客户服务中心网站服务条款》</a></td>
                </tr>
          </table> <br>
          <table width="835" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="234">&nbsp;</td>
                  <td width="147" height="30" align="center">
                  <s:submit cssClass="buttj" label="" value="" type="button"/></td>
                  <td width="141" align="center">&nbsp;</td>
                  <td width="147" align="center">
                  <s:reset cssClass="butcz" label="" value="" type="button"/></td>
                  <td width="166" align="center">&nbsp;</td>
                </tr>
              </table></td>
      </tr>
      </table></td>
  </tr>
  <tr><td> </td></tr>
</table><br>

<table width="100%" border="0" cellspacing="0">
<tr>
    <td height="2" background="images/bottom_point.gif"></td>
  </tr>
  <tr>
    <td height="25" align="center" background="images/bottom_ny_bg.gif" class="text_cray">copyright@12306 购票网</td>
  </tr>
</table>
</s:form>
<script type="text/JavaScript" src="js/common.js"></script>
<s:if test="hasFieldErrors()">   
<s:iterator value="fieldErrors">   
<s:iterator value="value">   
    <script language="JavaScript">   
     alert('<s:property/>');   
    </script>      
</s:iterator>     
</s:iterator>    
</s:if>
</body>
</html>
