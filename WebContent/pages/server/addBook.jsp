<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = "/mooc_library";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书添加</title>
</head>
<body>
	<center>
		<h1>图书添加</h1>
		<form action="<%=basePath%>/AddBookServlet" method="post">
			<table width="400px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<td>图书ID</td>
					<td><input type="text" name="id" placeholder="请输入数字" pattern="\d+" required="required"></td>
				</tr>
				<tr>
					<td>图书名</td>
					<td><input type="text" name="bookName"></td>
				</tr>
				<tr>
					<td>图书分类</td>
					<td>
						<select name="categoryName">
							
						</select>
					</td>
				</tr>
				<tr>
					<td>价格</td>
					<td><input type="text" name="price" pattern="\d+(.\d+)?" placeholder="请输入价格" title="请输入正确的价格" required="required"></td>
				</tr>
				<tr>
					<td>描述</td>
					<td><input type="text" name="description" placeholder="请输入描述信息" required="required"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="添加">
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form>
	</center>
	<script type="text/javascript" src="mooc_library/js/jquery-3.3.1.js"></script>
	<script type="text/javascript">
		$(function(){
			$.ajax({
				"url" : "/mooc_library/ToAddBookServlet",
				"type" : "post",
				"dataType" : "json",
				"success" : function(json){
					console.log(json);
					$("select option").remove();
					for( var i=0; i<json.length; i++ ){
						console.log(json[i].categoryName);
						$("select").append("<option id='pre' value='"+json[i].categoryName+"'>" + json[i].categoryName+"</option>");
					}
					
					console.log($("#pre").val());
				}
			})
		})
	</script>
</body>
</html>