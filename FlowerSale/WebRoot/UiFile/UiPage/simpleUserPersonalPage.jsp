<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${user.dailyName}</title>
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/UiFile/image/logo.png"  />
<link rel="stylesheet" href="${pageContext.request.contextPath}/UiFile/CSS/globle_css.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/UiFile/CSS/personalpage.css"/>
    <script src="${pageContext.request.contextPath}/UiFile/JQ/JQ.js"></script>
    <%-- <script type="text/javascript" src="${pageContext.request.contextPath}/UiFile/JQ/submit.js"></script> --%>
</head>
<body>
<header>
    <span><a href="outLogin">安全退出</a></span>
</header>
<div class="personal_choose">
    <ul>
        <li class="split"><a href="welcome">花卉管理销售</a></li>
        <li class="split">${user.username}</li>
        <li id="userPersonalInfo">个人资料</li>
        <li id="changePassword">修改密码</li>
        <li id="currently_logged">当前登录</li>
        <li id="myShoppingCar" onclick="window.location.href='toShoppingCar'">我的购物车</li>
        <li id="orderManager" onclick="window.location.href='userToOrderManager'">我的订单</li>
        <li id="applyMyStore">申请成为店主</li>
        <li id="myAddress">管理我的收货地址</li>
    </ul>
</div>
<div id="clickDemo">
    	<div id="personalShowInfo">您好，尊敬的会员${user.username}</div>
</div>

<script>
    $(document).ready(function(){
    	var demo = "";
    	$("#changePassword").click(function(){
    		demo="${pageContext.request.contextPath}/UiFile/GlobleFrame/changePass.jsp";
    		loadInfo(demo);
    	});
    	$("#currently_logged").click(function(){
    		demo="${pageContext.request.contextPath}/UiFile/GlobleFrame/currentLogin.jsp";
    		loadInfo(demo);
    	});
    	$("#userPersonalInfo").click(function(){
    		demo="${pageContext.request.contextPath}/UiFile/SimpleUserFrame/userUpdataInfo.jsp";
    		loadInfo(demo);
    	});
    	$("#applyMyStore").click(function(){
    		demo="${pageContext.request.contextPath}/UiFile/SimpleUserFrame/applyStore.jsp";
    		loadInfo(demo);
    	});
    	$("#myAddress").click(function(){
    		window.location.href="myAddress";
    	});
    		<% if(ActionContext.getContext().get("myAddressInfo")!=null){
    			%>
    				demo="${pageContext.request.contextPath}/UiFile/SimpleUserFrame/addressResive.jsp";
    				loadInfo(demo);
    			<%
    			ActionContext.getContext().put("myAddressInfo",null);
    		}%>
    	
    });
	function loadInfo(demo){
		var $personalShowInfo = $("#personalShowInfo");
		$("#clickDemo").load(demo);
		$personalShowInfo.hide();
	}
</script>
</body>
</html>