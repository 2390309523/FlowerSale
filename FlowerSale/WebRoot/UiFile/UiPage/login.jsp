<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta>
    <title>用户登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/UiFile/CSS/login.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/UiFile/JQ/JQ.js"></script>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/UiFile/image/logo.png"  />
</head>
<body>
<div id="login">
    <div class="left">
        <div class="lineCenter">
            <img src="${pageContext.request.contextPath}/UiFile/image/logo.png">
        </div>
    </div>
    <div class="right">
        <div class="login_info">用户登录</div>
        <div class="login_box">
            <form action="login" method="post">
                <table>
                    <tr>
                        <td>username:</td>
                        <td><input type="text" placeholder="username/email" name="username" required/></td>
                    </tr>
                    <tr>
                        <td>password:</td>
                        <td><input type="password" placeholder="password" name="password" required/></td>
                    </tr>
                    <tr>
                    	<td><a>user:</a><input type="radio" name="identity" checked="checked" value="simple_user"></td>
                    	<td><a>administrator:</a><input type="radio" name="identity" value="administrator"></td>
                    </tr>
                </table>
                <div class="login_submit">
                    <input type="submit" value="LOGIN"/>
                </div>
            </form>
        </div>
        <div class="login_href">
                <span ><a href="toRegister">没有账号？点这里</a></span>
                <span ><a href="welcome">back>></a><a href="findBackPasswordStepOne" style="margin-left:50px;">找回密码>></a></span>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		<% if(ActionContext.getContext().get("loginInfo")!=null && session.getAttribute("user") == null){
			%>alert("${loginInfo}")<%
		} %>
	});
</script>
</html>