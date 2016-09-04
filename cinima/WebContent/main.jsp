<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>FILM EVERYDAY</title>
<link rel="stylesheet" type="text/css" href="./css/style.css" media="screen" />
<script type="text/javascript" src="./js/jquery.core.js"></script>
<script type="text/javascript" src="./js/jquery.superfish.js"></script>
<script type="text/javascript" src="./js/jquery.jcarousel.pack.js"></script>
<script type="text/javascript" src="./js/jquery.easing.js"></script>
<script type="text/javascript" src="./js/jquery.scripts.js"></script>
</head>

<body>
<div id="wrap">
    <div class="top_corner"></div>
    <div id="main_container">
    
        <div id="header">
            <div id="logo"><a href="main.jsp"><img src="images/logo.jpg" alt="" title="" border="0" /></a></div>
            
            <a href="make-a-donation.html" class="make_donation"></a>
            
            <div id="menu">
                <ul>                                                                                            
                    <li><a class="current" href="main.jsp" title="">首页</a></li>
                    <li><a href="movie.jsp" title="">影片</a></li>
                    <li><a href="schedule.jsp" title="">放映安排</a></li>
                    <li><a href="online.jsp" title="">网上影院</a></li>
                    <li><a href="auction.jsp" title="">拍卖大厅</a></li>
                    <li><a href="forum.jsp" title="">说吧</a></li>
                    <li><a href="service.jsp" title="">服务</a></li>
                </ul>
            </div>
            
        
        </div>
        
        
        <div class="middle_banner">               
           
<div class="featured_slider">
      	<!-- begin: sliding featured banner -->
         <div id="featured_border" class="jcarousel-container">
            <div id="featured_wrapper" class="jcarousel-clip">
               <ul id="featured_images" class="jcarousel-list">
                  <li><img src="images/nanjing-slide.jpg" width="965" height="280" alt="" /></li>
                  <li><img src="images/fly-slide.jpg" width="965" height="280" alt="" /></li>
                  <li><img src="images/enemy-slide.jpg" width="965" height="280" alt="" /></li>
                  <li><img src="images/disk-slide.jpg" width="965" height="280" alt="" /></li>
               </ul>
            </div>
            <div id="featured_positioner_desc" class="jcarousel-container">
               <div id="featured_wrapper_desc" class="jcarousel-clip">
                  <ul id="featured_desc" class="jcarousel-list">                 
                     <li>
                        <div>
                           <p>金陵十三钗--正在热映
                           </p>
                        </div>
                     </li> 
                     <li>
                        <div>
                           <p> 龙门飞甲--正在热映
                           </p>
                        </div>
                     </li> 
                     <li>
                        <div>
                           <p> 亲密敌人--正在上映
                           </p>
                        </div>
                     </li>  
                     <li>
                        <div>
                           <p>碟中谍4：幽灵协议--即将上映
                           </p>
                        </div>
                     </li> 
                  </ul>
               </div>

            </div>
            <ul id="featured_buttons" class="clear_fix">
               <li>1</li>
               <li>2</li>
               <li>3</li>
               <li>4</li>
            </ul>
         </div>
         <!-- end: sliding featured banner -->
</div>
          
        
        
        </div><!---------------------------------end of middle banner-------------------------------->
        
        
        <div class="center_content">
        
        
         
        <div class="home_section_left">
            <img src="images/icon1.gif" alt="" title="" class="home_section_icon" border="0">
                            
                <h2 class="home_title">快来看啊！！！</h2>
                <div class="home_subtitle">正在上映</div>
    
                <div class="home_section_thumb">
                <a href="ibuy.jsp"><img src="images/nanjing-on.jpg" alt="" title="" border="0"></a>
                </div>
                <p><span>金陵十三钗：  </span> 张艺谋首次执导战争史诗大片<br>
                <a href="ibuy.jsp"><input type="submit" name="" class="newsletter_submit" value="我要购票" /><a>
                </p>
                <div class="home_section_thumb">
                <img src="images/fly-on.jpg" alt="" title="" border="0">
                </div>
                <p><span>龙门飞甲：   </span> 华语首部IMAX3D武侠巨制<br>
                <input type="submit" name="" class="newsletter_submit" value="我要购票" />
                </p>
                <br><br>
                <a href="" class="more">更多</a>
        <div class="clear"></div>
        </div>
        
        
        <div class="home_section_left">
            <img src="images/icon3.gif" alt="" title="" class="home_section_icon" border="0">
                            
                <h2 class="home_title">快来关注</h2>
                <div class="home_subtitle">最新活动</div>
    
                <div class="home_section_thumb">
                <a href="http://weibo.com/u/1764210591"><img src="images/weibo.gif" alt="" title="" border="0"></a>
                </div>
                <p><span>加关注</span><br>
                                           随时随地享受及时影讯 
                </p>
                <div class="home_section_thumb">
                <a href="auction.jsp"><img src="images/auction.jpg" alt="" title="" border="0"></a>
                </div>
                <p><span>拍一拍</span><br>
                                           龙门飞甲拍摄道具，拍你喜欢
                <br> <br>
                </p>
                <a href="" class="more">更多</a>
        <div class="clear"></div>
        </div>
        
        <div class="home_section_left">
            <img src="images/icon2.gif" alt="" title="" class="home_section_icon" border="0">
                            
                <h2 class="home_title">今日快速购票</h2>
                <div class="home_subtitle">12月19日</div>
    
                <div class="home_section_thumb">
                <img src="images/home_section_thumb3.jpg" alt="" title="" border="0">
                </div>
                <div class="quick_buy">
                	<select>
                		<option value="0">----请选择影院----</option>
                		<option value="1">海淀天天看</option>
                		<option value="2">朝阳天天看</option>
                		<option value="3">东城天天看</option>
                	</select>
                </div>
                <div class="quick_buy">
                	<select>
                		<option value="0">----请选择影片----</option>
                		<option value="1">金陵十三钗</option>
                		<option value="2">龙门飞甲</option>
                		<option value="3">亲密敌人</option>
                	</select>
                </div>
                <div class="quick_buy">
                    <select>
                		<option value="0">----请选择场次----</option>
                		<option value="1">1030</option>
                		<option value="2">1045</option>
                		<option value="3">1130</option>
                		<option value="4">1430</option>
                		<option value="5">1530</option>
                	</select>
                </div>
                <a href="ibuy.jsp"><input type="submit" name="" class="newsletter_submit" value="立即购票" /></a>
        <div class="clear"></div>
        </div>
        
            
            <div class="left_block_wide">
                <h2>即将上映  敬请期待<a href="">>>>></a><a href="" class="more"><img src="images/more.gif" alt="" title="" border="0"></a></h2>
                <table>
                <tr>
               		<td>
                		<a href="#"><img src="images/dream.jpg" alt="" title="" border="0" class="projects" /></a>
                	</td>
                	<td>
                		<a href="#"><img src="images/secret.jpg" alt="" title="" border="0" class="projects" /></a>
                	</td>
                	<td>
                		<a href="#"><img src="images/magic.jpg" alt="" title="" border="0" class="projects" /></a>
                	</td>
                </tr>
                <tr>
                	<td style="font-weight:bold;font-size:14px"> 梦宅诡影        12月29日</td>
                	<td style="font-weight:bold;font-size:14px"> 深度悬迷        12月31日</td>
                	<td style="font-weight:bold;font-size:14px"> 大魔术师        1月12日</td>
                </tr>
                <tr>
                	<td style="font-size:12px">克雷格、薇姿定情之作 </td>
                	<td style="font-size:12px">2011最具悬念与怨念的惊悚电影</td>
                	<td style="ffont-size:12px">两帝一后联袂主演 </td>
                </tr>
                </table>
            </div>
            
            <div class="right_block">
            	<h2>会员登录 <a href="register.jsp">| 注册 </a></h2>
                <p>
                                                  即刻登录，享受会员服务
                </p>
                <form id="newsletter" action="login.action" method="post">
                <table>
                <tr>
                	<td style="font-weight:bold;color:#B52025">name：
                	</td>
                	<td>
                		<input type="text" name="" class="newsletter_input" id="email" name="email"/>
                	</td>
                	<td>
                	</td>
                </tr>
                <tr>
                	<td style="font-weight:bold;color:#B52025">pass：
                	</td>
                	<td>
                		<input type="password" name="" class="newsletter_input" id="password" name="password"/>
                    </td>
                    <td>
                    	<a><input type="submit" name="" class="newsletter_submit" value="GO>>" />
                	</td>
                </tr>
                </table>
                </form>
            </div>
        
        
        
   
        
        <div class="clear"></div>
        </div>
        
        <div class="footer">
        	<div class="footer_links">
                <a class="current" href="main.jsp" title="">首页</a>
                <a href="movie.jsp" title="">影片</a>
                <a href="schedule.jsp" title="">放映安排</a>
                <a href="online.jsp" title="">网上影院</a>
                <a href="auction.jsp" title="">拍卖大厅</a>
                <a href="forum.jsp" title="">说吧</a>
                <a href="service.jsp" title="">服务</a>              
            </div>
        </div>
      
      
    
    </div>
</div>
</body>
</html>
