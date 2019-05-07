<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		String username = (String)request.getParameter("username");
		
		session.setAttribute("loginUser", username);		//模拟登录操作，在session中存入登录用户的用户名
		System.out.println("session attr : "+session.getAttribute("loginUser"));
		System.out.println("username : " + username);
		response.sendRedirect(request.getContextPath()+"/pages/server/server.jsp");//重定向至服务器页面
%>