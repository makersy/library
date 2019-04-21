<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()
			+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书查询</title>
</head>
<body>
	<center>
		<h1>图书查询</h1>
		<p>
			图书ID：<input type="text" name="bookId">
			图书名：<input type="text" name="bookName">
			分类：<input type="text" name="categoryName">
			<input type="submit" value="查询" id="search">
		</p>
		<hr>
		<table width="800px" cellspacing="0px" cellpadding="0px" border="1px">
			<thead>
				<tr>
					<th>图书ID</th>
					<th>书名</th>
					<th>分类</th>
					<th>价格</th>
					<th>描述</th>
				</tr>
			</thead>
			<tbody id="cont">

			</tbody>
		</table>
	</center>
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<script type="text/javascript">
	//页面就绪函数，显示所有书籍
	$(function(){
		$.ajax({
			"type" : "post",
			"url" : "/mooc_library/ShowAllBookServlet",
			"data" : "",
			"dataType" : "json",
			"success" : function(json){
				$("#cont tr").remove();
				for( var i=0; i<json.length; i++ ){
					$("#cont").append("<tr><td>"+json[i].bookID+"</td><td>"+json[i].bookName+"</td><td>"
							+json[i].categoryName+"</td><td>"+json[i].bookPrice+"</td><td>"+
							json[i].description+"</td></tr>");
				}
			}
		})
	})
	//点击查询按钮的函数
	$("#search").click(function(){
			var id = $("input[name=bookId]").val();
			var bookName = $("input[name=bookName]").val();
			var categoryName = $("input[name=categoryName]").val();
			$.ajax({
				"type" : "post",
				"url" : "/mooc_library/SelectBook",
				"data" : {"id" : id, "bookName" : bookName, "categoryName" : categoryName},
				"dataType" : "json",
				"success" : function(json){
					$("#cont tr").remove();
					for( var i=0; i<json.length; i++ ){
						$("#cont").append("<tr><td>"+json[i].bookID+"</td><td>"+json[i].bookName+"</td><td>"
								+json[i].categoryName+"</td><td>"+json[i].bookPrice+"</td><td>"+
								json[i].description+"</td></tr>");
					}
				}
			})
	});
	</script>
</body>
</html>