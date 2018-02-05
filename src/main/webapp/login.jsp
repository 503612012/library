<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>SKYER'S LIBRARY</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<%=basePath%>assets/css/reset.css">
<link rel="stylesheet" href="<%=basePath%>assets/css/supersized.css">
<link rel="stylesheet" href="<%=basePath%>assets/css/style.css">
<script type="text/javascript">
	function getBasePath() {
		return '<%=basePath%>';
	}
</script>
<script src="<%=basePath%>assets/js/jquery-1.8.2.min.js"></script>
<script src="<%=basePath%>assets/js/supersized.3.2.7.min.js"></script>
<script src="<%=basePath%>assets/js/supersized-init.js"></script>
<script src="<%=basePath%>assets/js/scripts.js"></script>
<script src="<%=basePath%>lib/login.js"></script>
</head>
<body>
	<div class="page-container">
		<h1>WELCOME SKYER'S LIBRARY</h1>
		<input type="text" id="uname" class="username" placeholder="请输入您的用户名！"> 
		<input type="password" id="pwd" class="password" placeholder="请输入您的用户密码！">
		<button type="submit" id="submitBtn" class="submit_button" style="margin-left: 17px">登录</button>
	</div>
</body>
</html>
