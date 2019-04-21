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
<title>图书后台管理登录界面</title>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	var flag = ${param.flag };
	if( "1"==flag ){
		alert("您尚未登录呢，或者账号在异地登录了哦");
	}else if( "2"==flag ){
		alert("密码错误哦");
	}else if( "3"==flag ){
		alert("用户名错误哦");
	}
</script>
</head>
<body>
	<center>
		<h1>登录 | <a href="<%=basePath%>/pages/admin/regist.jsp">注册</a></h1>
		<form action="<%=basePath%>/LoginServlet" method="post">
			<table width="350px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<td>用户名</td>
					<td><input type="text" name="username" pattern="[\w]{3,12}" required="required" title="用户名为3-12位字母数字或下划线组合" placeholder="用户名为3-12位字母数字或下划线组合" ></td>
				</tr>
				<tr>
					<td>密&nbsp;码</td>
					<td><input type="password" name="password" pattern="[\d]{6,12}" required="required" title="长度为6-12位的纯数字" placeholder="长度为6-12位的纯数字" ></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="登录">
						<input type="reset" value="取消">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>