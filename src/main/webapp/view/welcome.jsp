<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	List<Map<String, Object>> list = (List<Map<String, Object>>) request.getSession().getAttribute("list");
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/style.css" />
<script type="text/javascript">
	function getBasePath(){
		return '<%=basePath%>';
	}
</script>
<title>我的桌面</title>
</head>
<body>
	<div class="page-container">
		<p class="f-20 text-success">
			WELCOME SKYER'S LIBRARY <span class="f-14">v1.0</span>
		</p>
		<table class="table table-border table-bordered table-bg">
			<thead>
				<tr>
					<th colspan="${fn:length(list) + 2}" scope="col">信息统计</th>
				</tr>
				<tr class="text-c">
					<th>统计</th>
					<th>总数</th>
					<c:forEach items="${list}" var="bean">
						<th>${bean.typeName}</th>
					</c:forEach>
				</tr>
			</thead>
			<tbody>
				<tr class="text-c">
					<td>总数</td>
					<%
						long totalCount = 0;
						for (int i=0; i<list.size(); i++) {
							totalCount += (long) list.get(i).get("num");
						}
					%>	
					<td>
						<%=totalCount%>
					</td>
					<c:forEach items="${list}" var="bean">
						<td>${bean.num}</td>
					</c:forEach>
				</tr>
			</tbody>
		</table>
	</div>
	<div>
		<div id="myChart" style="min-width:700px;height:400px"></div>
	</div>
	<footer class="footer mt-20">
		<div class="container">
			<p>
				Copyright &copy;2017-2027 SKYER'S LIBRARY v1.0 All Rights Reserved.<br>
			</p>
		</div>
	</footer>
	<script type="text/javascript" src="<%=basePath%>lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>lib/echarts/3.4.0/echarts.common.min.js"></script>
	<script type="text/javascript">
	 // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('myChart'));
	var basePath = getBasePath();
	var typeName = [];
	var typeNum = [];
	$.ajax({
		url: basePath + 'book/getChartsInfo.html',
		type: 'GET',
		data: {},
		dataType: "json",
		success: function(result) {
			if (result.code != 200) {
				alert(result.data);
				return;
			}
			var data = result.data;
			for (var i=0; i<data.length; i++) {
				typeName.push(data[i].typeName);
				typeNum.push(data[i].num);
			}
			var option = {
		        title: {
		            text: '类别统计',
		            left: 'center'
		        },
		        tooltip: {},
		        xAxis: {
		            data: typeName
		        },
		        yAxis: {
		        	show: true,
		        	type: 'value',
		        	name: '个数（本）'
		        },
		        series: [{
		        	name: '个数（本）',
		        	type: 'bar',
		        	data: typeNum,
		        	itemStyle: {  
                        normal: {  
                            label: {  
                                show: true,
                                textStyle: {  
                                    fontWeight:'bolder',  
                                    fontSize : '12',  
                                    fontFamily : '微软雅黑',  
                                }  
                            }  
                        }  
                    }
		        }]
		    };
		    myChart.setOption(option);
		}
	});
	</script>
</body>
</html>