function isEmail(str) {
	return /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(str);
}

function isMobile(str) {
	return /^1[3458]\d{9}$/.test(str);
}

function isImgCheckCode(str) {
	return /^[0-9a-zA-Z]{4}$/.test(str);
}

function isMobileCheckCode(str) {
	return /^[0-9]{6}$/.test(str);
}

function isPwd(str) {
	return /^\S{6,20}$/.test(str);
}

function isInput(str) {
	return str.length > 0;
}

function checkUserAccount(account) {
	var res = 0;
	$.ajaxSettings.async = false;
	$.getJSON("https://u.tieyou.com/ajax/checkUserAccount.html?account=" + account + "&jsoncallback=?", function(data) {
		if (data != null) {
			res = data['res'];
		}
	});
	$.ajaxSettings.async = true;
	return res;
}

function checkUser(username, password) {
	var res = 0;
	$.ajaxSettings.async = false;
	$.getJSON("https://u.tieyou.com/ajax/checkUser.html?username=" + username + "&password=" + password + "&jsoncallback=?", function(data) {
		if (data != null) {
			res = data['res'];
		}
	});
	$.ajaxSettings.async = true;
	return res;
}

function reloadImgCheckCode(id) {
	$('#' + id).attr('src', 'https://u.tieyou.com/validateimage.html?t=' + new Date().getTime());
}

function countDown(num, sid, hid, str) {
	var hideControl = $('#' + hid);
	var showControl = $('#' + sid);
	var num = parseInt(num);

	if (num <= 0 || isNaN(num)) {
		hideControl.show();
		showControl.hide();
		return;
	}
	
	hideControl.hide();
	
	showControl.attr('disabled', 'disabled').html(str.replace('$num', num)).show();
	
	var timer = setInterval(function() {
		num --;
		if (num <= 0) {
			hideControl.show();
			showControl.hide();
			clearInterval(timer);
		} else {
			showControl.html(str.replace('$num', num));
		}
	}, 1000);
} 

function SetCookie(name, value) {
	var expdate = new Date();
	var argv = SetCookie.arguments;
	var argc = SetCookie.arguments.length;
	var expires = (argc > 2) ? argv[2] : null;
	var path = (argc > 3) ? '/' : '/';
	var domain = (argc > 4) ? '.tieyou.com' : '.tieyou.com';
	var secure = (argc > 5) ? argv[5] : false;
	if(expires!=null) expdate.setTime(expdate.getTime() + ( expires * 72000 ));
	document.cookie = name + "=" + escape (value) +((expires == null) ? "" : ("; expires="+ expdate.toGMTString()))
	+((path == null) ? "" : ("; path=" + path)) +((domain == null) ? "" : ("; domain=" + domain))
	+((secure == true) ? "; secure" : "");
}