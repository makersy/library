<%@page import="service.LibServiceImpl"%>
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
<title>注册界面</title>
</head>
<body>
	<center>
		<h1>用户注册</h1>
		<form action="<%=basePath%>/RegistServlet" method="post" onsubmit="return check()">
			<table width="400px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<td>用户名</td>
					<td><input type="text" name="username" id="username" pattern="[\w]{3,12}" required="required" onblur="hadoop()" title="用户名为3-12位字母数字或下划线组合" placeholder="用户名为3-12位字母数字或下划线组合" ></td>
				</tr>
				<tr>
					<td>密&nbsp;码</td>
					<td><input type="password" name="password" pattern="[\d]{6,12}" required="required" title="密码长度为6-12位的纯数字" placeholder="密码长度为6-12位的纯数字"  id="password"></td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td><input type="password" name="checkPWD" placeholder="密码长度为6-12位的纯数字" id="checkPWD"></td>
				</tr>
				<tr>
					<td>手机号码</td>
					<td><input type="text" name="phone" pattern="[\d]{3,}" required="required" title="请输入正确的手机号码格式" placeholder="请输入正确的手机号码格式" ></td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td><input type="email" name="email" placeholder="请输入正确邮箱格式" required="required"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="注册" >
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
			<div id="message" style="color:red;"></div>
		</form>
	</center>
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<script type="text/javascript">
		function check(){
			var pd1=document.getElementById("password").value;
			var pd2=document.getElementById("checkPWD").value;
			if (pd1!=pd2){
				alert("两次密码不一致,请重新输入！");
				return false;
			}
			return true;	
		}
		var hadoop = function(){
            // 异步验证用户是否重复
            
            $.ajax({
                type: "post",
                url: "/mooc_library/UserExist",
                data: "username=" + $("#username").val(),
                success: function(message){
                	var x = parseInt(message);
                    if( x==1 ){
                    	$("#message").html("用户名重复！");
                    }else{
                    	$("#message").html("");
                    }
                }
            });
            
        };
	</script>
</body>
</html>
