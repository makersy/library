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
<title>图书分类添加</title>
</head>
<body>
	<center>
		<h1>图书分类添加</h1>
		<form action="<%=basePath%>/CategoryServlet" method="post">
			<table width="400px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<td>分类ID</td>
					<td><input type="text" name="id" required="required"></td>
				</tr>
				<tr>
					<td>名&nbsp;字</td>
					<td><input type="text" name="categoryName" required="required"></td>
				</tr>
				<tr>
					<td>描&nbsp;述</td>
					<td><input type="text" name="description" required="required"></td>
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
</body>
</html>