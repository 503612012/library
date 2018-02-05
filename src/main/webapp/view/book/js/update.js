$(function() {
	var basePath = getBasePath();
	load();
	
	$("#tab-user-update").Huitab({
		index: 0
	});
	
	$("#form-user-update").validate({
		rules: {
			name: {
				required: true,
				minlength: 1,
				maxlength: 150
			}
		},
		onkeyup: false,
		focusCleanup: true,
		success: "valid",
		submitHandler: function(form) {
			$("#form-user-update").ajaxSubmit();
			var index = parent.layer.getFrameIndex(window.name);
			parent.location.reload(); // 刷新父窗体
			parent.layer.close(index); // 关闭本页面
		}
	});
});

/**
 * 加载更新页面数据
 */
function load() {
	var basePath = getBasePath();
	var userId = getUserId();
	$.ajax({
		url: basePath + "user/findById.html",
		type: "GET",
		data: {"id": userId},
		dataType: "json",
		success: function(result) {
			if (result.code != 200) {
				alert("数据加载失败！");
				return;
			} else {
				var userId = result.data.userId;
				var userName = result.data.name;
				$("#userId").html(userId);
				$("#userName").val(userName);
			}
		}
	});
}
