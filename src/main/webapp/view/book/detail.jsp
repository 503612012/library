<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath%>view/book/css/detail.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui/css/H-ui.min.css" />
<script type="text/javascript">
	function getBasePath(){
		return '<%=basePath%>';
	}
</script>
</head>
<body>
<div class="container">
	<table>
		<tr>
			<td class="title">图书编号：</td>
			<td>${book.id}</td>
			<td rowspan="10" class="imgTd">
				<div style="width: 100px">
					<img src="${book.image}">
				</div>
			</td>
		</tr>
		<tr>
			<td class="title">图书名称：</td>
			<td>${book.bookName}</td>
		</tr>
		<tr>
			<td class="title">作&emsp;&emsp;者：</td>
			<td>${book.author}</td>
		</tr>
		<tr>
			<td class="title">出&nbsp;&nbsp;版&nbsp;&nbsp;社：</td>
			<td>${book.press}</td>
		</tr>
		<tr>
			<td class="title">价&emsp;&emsp;格：</td>
			<td>${book.price}</td>
		</tr>
		<tr>
			<td class="title">购买日期：</td>
			<td>${book.buyDate}</td>
		</tr>
		<tr>
			<td class="title">版&emsp;&emsp;本：</td>
			<td>${book.version}</td>
		</tr>
		<tr>
			<td class="title">状&emsp;&emsp;态：</td>
			<td>
				<c:if test="${book.status == 0}">
					<span class="label label-success radius">正常</span>
				</c:if>
				<c:if test="${book.status == 1}">
					<span class="label label-danger radius">已外借</span>
				</c:if>
			</td>
		</tr>
		<tr>
			<td class="title">类&emsp;&emsp;别：</td>
			<td>${book.bookType.typeName}</td>
		</tr>
		<tr>
			<td class="title">备&emsp;&emsp;注：</td>
			<td>${book.remark}</td>
		</tr>
		<c:if test="${user.isAdmin == 0}">
			<tr>
				<td colspan="3">
					<a href="javascript:void();" class="btn btn-primary radius upload-btn">修改</a>
				</td>
			</tr>
		</c:if>
	</table>
</div>
</body>
</html>