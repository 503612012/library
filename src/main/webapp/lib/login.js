$(function() {
	document.onkeydown = function(event) {
	    var e = event || window.event;
	    if (e && e.keyCode == 13) { //回车键的键值为13
	    	doLogin();
	    }
	}
	
	$("#submitBtn").bind("click", function() {
		doLogin();
	});
});

function doLogin() {
	var basePath = getBasePath();
	var uname = $("#uname").val();
	if (uname == null || uname == "") {
		alert("用户名不能为空！");
		return;
	}
	var pwd = $("#pwd").val();
	if (pwd == null || pwd == "") {
		alert("密码不能为空！");
		return;
	}
	$.ajax({
		url: basePath + "user/login.html",
		type: "POST",
		data: {"userName": uname, "password": pwd},
		dataType: "json",
		success: function(result) {
			if (result.code != 200) {
				alert(result.data);
				return;
			}
			location.href = basePath + "view/index.jsp";
		}
	});
}