/**
 * 
 * @authors 张明臣 (vest0804@gamil.com)
 * @date    2014-11-19 17:39:26
 * @version 1.0
 */     
(function () {
	window.app = {
		open: function(url, ios, callback){
			var _url;
			var unInstallCallBack = function(){
				//判断回调如果不是function 就下载客户端
				if(Object.prototype.toString.call(callback) != "[object Function]"){
					if(app.getUa.weixin){
						//可以直接下载
						if(app.getUa.ios){
							location.href = 'http://itunes.apple.com/cn/app/365ri-li-xin-ban/id642101382?ls=1&mt=8';
						}
						else{
							location.href = "http://a.app.qq.com/o/simple.jsp?pkgname=com.when.coco&g_f=991609";
						}
						// location.href = "http://a.app.qq.com/o/simple.jsp?pkgname=com.when.coco&g_f=991609";
					}
					else{
						if(app.getUa.ios){
							location.href = 'http://itunes.apple.com/cn/app/365ri-li-xin-ban/id642101382?ls=1&mt=8';
						}
						else{
							location.href = "http://d2.365rili.com/coco.apk";
						}
					}
				}else{
					callback();
				}
			};
			if(Object.prototype.toString.call(url)=="[object Object]"){
				if(app.getUa.ios){
					_url = url.ios;
				}
				else if(app.getUa.android){
					_url = url.android;
				}
			}
			else{
				_url = url;
			}

			var openApp = function () {
				var iframe = document.createElement("iframe");
				iframe.style.display = "none";
				iframe.src = _url;
				document.body.appendChild(iframe);
				//保证所有浏览器能打开客户端，个别浏览器不支持iframe
				// window.location.href = _url;	
			};

			/**
			 * 微信内判断
			 * 私有协议
			 */
			if(app.getUa.weixin && (function () {
				// 9以上微信会直接判断为已安装
				var ua = navigator.userAgent.toLowerCase();
				var re = /\(iphone; cpu iphone os ([\d\_]*) like mac os x\)/;
				var rs = ua.match(re);
				if(rs){
					var version = +rs[1].split('_')[0];
					if(version > 8){
						return false;
					}
				}
				return true;
			})()){
				app.getInstallStateInWeixin(
					function () {
						//安卓和某些情况下，此处打开app失败，需要setTimeout
						setTimeout(openApp, 16)
						WeixinJSBridge.invoke('closeWindow',{},function(res){});
					},
					_do
				);
				return false;
			}
			
			/**
			 * 其他环境判断（主要是正常浏览器内）
			 */
			if(window.AliansBridge || app.getUa.coco){
				window.location.href = _url;
				return false;
			}

			function _do () {
				var startTime = new Date().getTime();
				openApp();
				var interval = setTimeout(function () {
					var delay = (new Date().getTime()) - startTime;
					delay < 1020 && unInstallCallBack();
				}, 1000);

				/**
				 * 安卓注销callback， 大部分情况不好使
				 */
				window.onblur = function(){
					interval && clearTimeout(interval);
				};
			}

			_do();
		},
		getInstallStateInWeixin: function (yes, no) {
			var res = {};
			var onBridgeReady = function () {
				WeixinJSBridge.invoke("getInstallState",{
			        "packageUrl":"coco://",
			        "packageName":"com.when.coco"
			    },
			    function(e){
			        if(e.err_msg.indexOf("get_install_state:yes") > -1){
			        	yes && yes();
			        	res.state = 'yes';
			        	return res;
			        }
			        else{
			        	no && no();
			        	res.state = 'no';
			        	return res;
			        }
			    });
			}
			if (typeof WeixinJSBridge === "undefined"){
			    document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
			    res.state = 'notReady';
			    return res;
			}else{
			    onBridgeReady();
			}
		},
		call: function (opt) {
			/**
			 * opt.action
			 * 调用客户端的方法名
			 * 
			 * opt.callBack
			 * 客户端返回值的回调方法
			 * 
			 * opt.param
			 * 需要传递给客户端的参数，必须以数组的方式储存（保持有序提供给安卓），并且单元必须是hash指名形参与实参（ios需要形参），形式如下
			 * [
			 * 	{name: paramName},
			 * 	{value: paramValue}
			 * ]
			 */
			/**
			 * example
			 *  app.call({
					action: 'getEncryptHeaders',
					params: [
						{
							name: 'url',
							value: url
						}
					],
					callBack: function (headers) {
						
					}
				});
			 */
			var action = opt.action || null;
			var	callBack = opt.callback || opt.callBack || function(){};
			var	params = opt.params || [];
			//无方法名
			if(!action){
				throw '没有调用的action';
				return false;
			}

			//参数非数组：由于安卓的参数是有序的，不像ios是自取，所以必须是数组
			if(params && Object.prototype.toString.call(params).toLowerCase() != '[object array]'){
				throw '参数集不是数组';
				return false;
			}

			if(app.getUa.ios){
				//coco基底
				var cocourl = ['coco://365rili.com'];

				//加入action
				cocourl.push('/' + action);

				//生成随机函数名绑定客户端回调伪静态函数
				var staticFnRand = 'fn' + Math.ceil(app.random(1000000, 9999999));
				window[staticFnRand] = function () {
					// 只执行一次，发现里ios会执行2次
					if(window[staticFnRand]._exec > 0) return;
					window[staticFnRand]._exec++;
					//回调，传入所有参数
					callBack(arguments[0]);
					//删除随机方法
					setTimeout(function () {
						delete window[staticFnRand];
						//删除随机变量
						for (var i = 0; i < paramRandNameList.length; i++) {
							delete window[paramRandNameList[i]];
						};
					}, 16)
				};
				window[staticFnRand]._exec = 0;
				cocourl.push('?static=' + staticFnRand);
				/**
				 * 加入参数，生成名仍然是随机名，需要在使用完后清空
				 */
				var paramRandNameList = [];
				var paramRand;
				for (var i = 0; i < params.length; i++) {
					paramRand = 'p' + Math.ceil(app.random(1000000, 9999999));
					//抛出到window方便客户端调用，如
					//window['1000000'] = 'http://www.365rili.com';
					window[paramRand] = params[i]['value'];

					//生成参数表，如
					//&url=p1000000
					cocourl.push('&' + params[i]['name'] + '=' + paramRand);
					//储存随机变量名方便后面销毁
					paramRandNameList.push(paramRand);
				};

				//生成Coco地址
				cocourl = cocourl.join('');
				//调用coco
				window.location.href = cocourl;
			}
			else if(app.getUa.android){
				//处理参数，生成数组
				var args = [];
				for (var i = 0; i < params.length; i++) {
					args.push(params[i]['value']);
				}

				//执行安卓调用，以apply的形式调用，args为需要传递的参数
				var _val = AliansBridge[action].apply(AliansBridge, args);

				//执行前端回调，传入返回值
				callBack(_val);
			}
		},
		coco: (navigator.userAgent.toLowerCase().match(/(android|ios)-coco\|(.+)/gi) || [''])[0],
		version: (function () {
			var data = (navigator.userAgent.toLowerCase().match(/(android|ios)-coco\|(.+)/gi) || [''])[0].split('|');

			if(data.length === 1){
				return 0;
			}

			var ver = data[2].split('.');

			for (var i = 0; i < ver.length; i++) {
				ver[i] || (ver[i] = 0);
			};

			return parseInt(ver.join(''));
		})(),
		random: function(n, m) {
	        return Math.random() * (m - n) + n
	    },
		getUa:(function(){
			//根据useragent判断当前的设备类型
			var sUserAgent = navigator.userAgent.toLowerCase();
			var bIsIpad = sUserAgent.match(/ipad/i) == "ipad"; 
			var bIsIphoneOs = sUserAgent.match(/iphone os/i) == "iphone os";
			var bIsAndroid = sUserAgent.match(/android/i) == "android";
			var bIsWeixin = sUserAgent.match(/micromessenger/i) == "micromessenger";
			var bIsWeibo = sUserAgent.match(/weibo/i) == "weibo";
			var bIsqq = sUserAgent.match(/qq/i) == "qq";
			var bIsIosCoco = sUserAgent.match(/ios-coco/i) == "ios-coco";
			var bIsAndroidCoco = sUserAgent.match(/android-coco/i) == "android-coco";
			return {
				ipad: bIsIpad,
				iphone: bIsIphoneOs,
				android:bIsAndroid,
				weibo: bIsWeibo,
				weixin: bIsWeixin,
				qq: bIsqq,
				ios: bIsIphoneOs || bIsIpad,
				iosCoco: bIsIosCoco,
				androidCoco: bIsAndroidCoco,
				coco: bIsIosCoco || bIsAndroidCoco
			}
		})(),
		showTip: function(calendarType,callback){
			if($('.tips_container').length > 0){
				$('.tips_container').css('display', 'block');
			}else{
				var tip = $('<div class="tips_container">\
					<div class="tips_layer">\
						<h3></h3>\
						<p></p>\
	        			<a href="javascript:;" class="layer_btn">立即使用</a>\
	    			</div>\
	    			<div class="mask"></div>\
	    		   </div>');
				var sTip;
				if(calendarType == "public"){
					sTip = '请使用365日历<br/>为感兴趣的日程添加提醒';
				}else if(calendarType == "group"){
					sTip = '立即使用365客户端<br/>申请加入该群组';
				}else{
					sTip = '快使用365日历记录你的日程吧，从此重要事件不再错过！';
				}
				tip.find('h3').html(sTip);
				$('body').append(tip);
				tip.find(".layer_btn").on("tap", function(){
					if(!callback){
						if(app.getUa.weixin){
							location.href = "http://a.app.qq.com/o/simple.jsp?pkgname=com.when.coco&g_f=991609";
						}else{
							if(app.getUa.ios){
								location.href = 'http://itunes.apple.com/cn/app/365ri-li-xin-ban/id642101382?ls=1&mt=8';
							}
							else{
								location.href = "http://d2.365rili.com/coco.apk";
							}
						}
					}else{
						callback(); 
					}
				});
				
				tip.find(".mask").height($(window).height()).on("tap", function(e){
					$(".tips_container").css("display", "none");
				})
			}
		},
		query: query,
		_hm: function () {
			var hm = document.createElement("script");
			switch(window.location.host){
				case 'qq.365rili.com' : 
					hm.src = "//hm.baidu.com/hm.js?fa28bc85a1c9fdb279ad3129de90c4af";
					break;
				default: 
					hm.src = "//hm.baidu.com/hm.js?ec877777cac7e868396078daa50bad6c";
			}
			document.getElementsByTagName("head")[0].appendChild(hm);
		}
	}
	function  query(name, href) {
	    var reg = new RegExp("(^|\\?|&)" + name + "=([^&^\#]*)(\\s|&|\#|$)", "i");
	    href = href || location.href;
	    if (reg.test(href)) return decodeURIComponent(RegExp.$2.replace(/\+/g, " "));	
	    return "";
	}
	window.Base64 = function() {  
	    // private property
	    _keyStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";  
	   
	    // public method for encoding  
	    this.encode = function (input) {  
	        var output = "";  
	        var chr1, chr2, chr3, enc1, enc2, enc3, enc4;  
	        var i = 0;  
	        input = _utf8_encode(input);  
	        while (i < input.length) {  
	            chr1 = input.charCodeAt(i++);  
	            chr2 = input.charCodeAt(i++);  
	            chr3 = input.charCodeAt(i++);  
	            enc1 = chr1 >> 2;  
	            enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);  
	            enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);  
	            enc4 = chr3 & 63;  
	            if (isNaN(chr2)) {  
	                enc3 = enc4 = 64;  
	            } else if (isNaN(chr3)) {  
	                enc4 = 64;  
	            }  
	            output = output +  
	            _keyStr.charAt(enc1) + _keyStr.charAt(enc2) +  
	            _keyStr.charAt(enc3) + _keyStr.charAt(enc4);  
	        }  
	        return output;  
	    }  
	   
	    // public method for decoding  
	    this.decode = function (input) {  
	        var output = "";  
	        var chr1, chr2, chr3;  
	        var enc1, enc2, enc3, enc4;  
	        var i = 0;  
	        input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");  
	        while (i < input.length) {  
	            enc1 = _keyStr.indexOf(input.charAt(i++));  
	            enc2 = _keyStr.indexOf(input.charAt(i++));  
	            enc3 = _keyStr.indexOf(input.charAt(i++));  
	            enc4 = _keyStr.indexOf(input.charAt(i++));  
	            chr1 = (enc1 << 2) | (enc2 >> 4);  
	            chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);  
	            chr3 = ((enc3 & 3) << 6) | enc4;  
	            output = output + String.fromCharCode(chr1);  
	            if (enc3 != 64) {  
	                output = output + String.fromCharCode(chr2);  
	            }  
	            if (enc4 != 64) {  
	                output = output + String.fromCharCode(chr3);  
	            }  
	        }  
	        output = _utf8_decode(output);  
	        return output;  
	    }  
	   
	    // private method for UTF-8 encoding  
	    _utf8_encode = function (string) {  
	        string = string.replace(/\r\n/g,"\n");  
	        var utftext = "";  
	        for (var n = 0; n < string.length; n++) {  
	            var c = string.charCodeAt(n);  
	            if (c < 128) {  
	                utftext += String.fromCharCode(c);  
	            } else if((c > 127) && (c < 2048)) {  
	                utftext += String.fromCharCode((c >> 6) | 192);  
	                utftext += String.fromCharCode((c & 63) | 128);  
	            } else {  
	                utftext += String.fromCharCode((c >> 12) | 224);  
	                utftext += String.fromCharCode(((c >> 6) & 63) | 128);  
	                utftext += String.fromCharCode((c & 63) | 128);  
	            }  
	   
	        }  
	        return utftext;  
	    }  
	   
	    // private method for UTF-8 decoding  
	    _utf8_decode = function (utftext) {  
	        var string = "";  
	        var i = 0;  
	        var c = c1 = c2 = 0;  
	        while ( i < utftext.length ) {  
	            c = utftext.charCodeAt(i);  
	            if (c < 128) {  
	                string += String.fromCharCode(c);  
	                i++;  
	            } else if((c > 191) && (c < 224)) {  
	                c2 = utftext.charCodeAt(i+1);  
	                string += String.fromCharCode(((c & 31) << 6) | (c2 & 63));  
	                i += 2;  
	            } else {  
	                c2 = utftext.charCodeAt(i+1);  
	                c3 = utftext.charCodeAt(i+2);  
	                string += String.fromCharCode(((c & 15) << 12) | ((c2 & 63) << 6) | (c3 & 63));  
	                i += 3;  
	            }  
	        }  
	        return string;  
	    }  

	}
})()
if(typeof $ !== 'undefined')
	$(app._hm)
else
	app._hm()