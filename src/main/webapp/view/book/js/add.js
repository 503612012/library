//@ sourceURL=add.js
$(function() {
	loadBookType();
	
	$("#form-book-add").validate({
		rules: {
			bookName: {
				required: true,
			},
			author: {
				required: true,
			},
			press: {
				required: true,
			},
			price: {
				required: true,
			},
			buyDate: {
				required: true,
			},
			image: {
				required: true,
			},
			version: {
				required: true,
			}
		},
		onkeyup: false,
		focusCleanup: true,
		success: "valid",
		submitHandler: function(form) {
			book_add_submit();
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index); // 关闭本页面
		}
	});
});

/**
 * 加载图书类别
 */
function loadBookType() {
	var basePath = getBasePath();
	$.ajax({
		url: basePath + "bookType/findAll.html",
		type: "GET",
		data: {},
		dataType: "json",
		success: function(result) {
			if (result.code != 200) {
				alert(result.data);
				return;
			}
			var json = result.data;
			var html = "";
			for (var i=0; i<json.length; i++) {
				html += '<option value="' + json[i].id + '">' + json[i].typeName + '</option>';
			}
			$("#bookType").html(html);
		}
	});
}

/**
 * 添加图书
 */
function book_add_submit() {
	var bookName = $("#bookName").val();
	var author = $("#author").val();
	var press = $("#press").val();
	var price = $("#price").val();
	var buyDate = $("#buyDate").val();
	var image = $("#image").val();
	var version = $("#version").val();
	var bookType = $("#bookType").val();
	var remark = $("#remark").val();
	var basePath = getBasePath();
	$.ajax({
		url: basePath + "book/add.html",
		type: "GET",
		data: {
			"bookName": bookName,
			"author": author,
			"press": press,
			"price": price,
			"buyDate": buyDate,
			"image": image,
			"version": version,
			"bookType.id": bookType,
			"remark": remark
		},
		dataType: "json",
		success: function(result) {
			if (result.code != 200) {
				alert(result.data);
				return;
			}
			location.href = basePath + "view/book/list.jsp";
		}
	});
}

/**
 * 上传封面图
 */
function uploadImage() {
	var basePath = getBasePath();
	$("#form-book-add").ajaxSubmit({
        type: 'post', 
        url: basePath + 'book/uploadImage.html', 
        dataType: "json",
        success: function(result) {
        	if (result.code != 200) {
        		alert(result.data);
        		return;
        	}
        	$("#image").attr('value', result.data); 
        }
    }); 
}