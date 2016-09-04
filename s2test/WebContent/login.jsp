<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@ page language="java" contentType="text/html; charset=UTF-8"
	    	pageEncoding="UTF-8"%>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录界面</title>
		<link href="css/css.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<form name="login_form" method="post" action="loginAction">
			<table width="933" border="0" align="center" cellpadding="0" cellspacing="0" 
		   				style="margin:120px;">
		  		<tr>
		    		<td height="412" valign="top" background="images/bg_img1.jpg">
		    			<table height="300" border="0" cellspacing="0">
		      				<tr>
		        				<td width="538">&nbsp;</td>
		        				<td height="130" colspan="6">&nbsp;</td>
		      				</tr>
		      				<tr>
						        <td rowspan="9">&nbsp;</td>
						        <td width="98" height="20" align="right">
						        	<img src="images/text_yh.gif" width="60" height="18">
						        </td>
						        <td width="16">&nbsp;</td>
						        <td width="136">
						        	<input name="user.userName" type="text" id="username" size="18" />
						        </td>
						        <td width="55">&nbsp;</td>
						        <td width="44">&nbsp;</td>
						        <td width="32">&nbsp;</td>
		      				</tr>
					     	<tr>
						        <td height="20" align="right">&nbsp;</td>
						        <td>&nbsp;</td>
						        <td>&nbsp;</td>
						        <td>&nbsp;</td>
						        <td>&nbsp;</td>
						        <td>&nbsp;</td>
					      	</tr>
						 	<tr>
						    	<td height="20" align="right">
						    		<img src="images/text_password.gif" width="60" height="18">
						    	</td>
						        <td>&nbsp;</td>
						        <td><input name="user.passWord" type="password" id="password" size="18" /></td>
						        <td>&nbsp;</td>
						        <td>&nbsp;</td>
						        <td>&nbsp;</td>
							</tr>
		      				<tr>
						        <td height="20" align="right">&nbsp;</td>
						        <td>&nbsp;</td>
						        <td>&nbsp;</td>
						        <td>&nbsp;</td>
						        <td>&nbsp;</td>
						        <td>&nbsp;</td>
		      				</tr>
		      				<tr>
						    	<td height="20">&nbsp;</td>
						        <td>&nbsp;</td>
						        <td colspan="2">&nbsp;</td>
						        <td>&nbsp;</td>
						        <td>&nbsp;</td>
						    </tr>
		      				<tr>
						        <td height="20">&nbsp;</td>
						        <td>&nbsp;</td>
						        <td colspan="2">
						        	<table width="200" border="0" cellspacing="0">
						          		<tr>
						            		<td width="78">
						            			<input type="submit"  class="butlogin" value=""/>
						            		</td>
						            		<td>&nbsp;</td>
						            		<td width="78"><input type="button"  class="butcz" onClick=""></td>
						          		</tr>
						        	</table>
						        </td>
						        <td>&nbsp;</td>
						        <td>&nbsp;</td>
		      				</tr>
		      				<tr>
						        <td height="20">&nbsp;</td>
						        <td>&nbsp;</td>
						        <td>&nbsp;</td>
						        <td>&nbsp;</td>
						        <td>&nbsp;</td>
						        <td>&nbsp;</td>
		      				</tr>
		    			</table>
		   			</td>
		  		</tr>
			</table>
		</form>
	</body>
</html>