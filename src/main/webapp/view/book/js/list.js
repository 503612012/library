$(function() {
	var basePath = getBasePath();
	var table = $('#bookTable').dataTable({
		"aaSorting": [[0, "asc"]], // 默认第几个排序
		"retrieve": true, // 保证只有一个table实例  
		"aoColumnDefs": [{"orderable": false, "aTargets": [0]}], // 制定列不参与排序,
		"ajax": basePath + "book/findAll.html",
		"columns": [{data: 'id'},
		            {data: function(obj) {
		            	var html = '<a class="maincolor" href="javascript:;" ';
		            	html += 'onClick="book_detail(\'' + obj.bookName + '\', \'' + basePath + 'book/findById.html?id=' + obj.id + '\', \'' + obj.id + '\')">' + obj.bookName + '</a>';
		            	return html;
		            }},
		            {data: 'author'},
		            {data: 'press'},
		            {data: 'price'},
		            {data: function(obj) {
		            	return formatDate(obj.buyDate);
		            }},
		            {data: 'version'},
		            {data: function(obj) {
		            	return getStatus(obj.status);
		            }},
		            {data: 'typeName'},
		            {data: 'remark'}]
	});
});

/**
 * 图书详情
 */
function book_detail(title, url, id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

/**
 * 打开添加图书窗口
 */
function book_add(title, url, w, h) {
	layer_show(title, url, w, 267);
}

/**
 * 打开编辑图书窗口
 */
function book_edit(title, url, w, h) {
	layer_show(title, url, w, 257);
}

/**
 * 获取图书状态
 */
function getStatus(status) {
	if (status == 0) {
		return '<span class="label label-success radius">正常</span>';
	} else {
		return '<span class="label label-danger radius">已外借</span>';
	}
}

/**
 * 格式化时间
 */
function formatDate(time) {
	if (time == '忘了') {
		return time;
	}
	var date = new Date(time);
	var year = date.getFullYear();  
	var month = date.getMonth() + 1;  
	if (month < 10) {
		month = "0" + month;
	}
	var day = date.getDate();
	if (day < 10) {
		day = "0" + day;
	}
	var hour = date.getHours();
	var min = date.getMinutes();  
	var result = year + '年' + month + '月' + day + '日  ' + hour + ':' + min;  
	return result;  
}
