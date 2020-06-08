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
        <li id="administrator_personal_info">个人资料</li>
        <li id="administrator_change_password">修改密码</li>
        <li id="administrator_currently_logged">当前登录</li>
        <li id="administrator_change_info">修改资料</li>
        <li id="administrator_store_addFlower">增加商品</li>
        <li id="administrator_orderManager">店铺订单管理</li>
        <li id="storeInfo">商店信息管理</li>
        <li id="administrator_storeInfo">进店</li>
        <li id="myShoppingCar" onclick="window.location.href='toShoppingCar'">我的购物车</li>
        <li id="orderManager" onclick="window.location.href='userToOrderManager'">我的订单</li>
    </ul>
</div>
<div id="clickDemo">
<%if(ActionContext.getContext().get("toUpdataFlowerInfo")!=null){
    		%>
    		<jsp:include page="../AdministratorFrame/updataFlowerInfo.jsp"></jsp:include>	
    		<%ActionContext.getContext().put("toUpdataFlowerInfo",null);
    	}%>
</div>

<script>
    $(document).ready(function(){
    var demo = "${pageContext.request.contextPath}/UiFile/AdministratorFrame/administratorPersonalInfo.jsp";
    	<% if(ActionContext.getContext().get("updataUserInfo")!=null){
    		%>alert("${updataUserInfo}");<%
    		ActionContext.getContext().put("updataUserInfo",null);
    	} 
    	if(ActionContext.getContext().get("updataStoreInfo")!=null){
    		%>alert("${updataStoreInfo}")<%
    		ActionContext.getContext().put("updataStoreInfo", null);
    	}%>
    	pointFormat: '<span style="color:{series.color}">{series.name}: <b>\${point.y:,.0f}</b><br>';
        
        $("#administrator_personal_info").click(function(){
            demo = "${pageContext.request.contextPath}/UiFile/AdministratorFrame/administratorPersonalInfo.jsp";
            $("#clickDemo").load(demo);
        });
        $("#administrator_change_password").click(function(){
            demo = "${pageContext.request.contextPath}/UiFile/GlobleFrame/changePass.jsp";
            $("#clickDemo").load(demo);
        });
        $("#administrator_currently_logged").click(function(){
            demo = "${pageContext.request.contextPath}/UiFile/GlobleFrame/currentLogin.jsp";
            $("#clickDemo").load(demo);
        });
        $("#administrator_change_info").click(function(){
            demo = "${pageContext.request.contextPath}/UiFile/AdministratorFrame/administratorUpdataInfo.jsp";
            $("#clickDemo").load(demo);
        });
        $("#administrator_store_addFlower").click(function(){
            demo = "${pageContext.request.contextPath}/UiFile/AdministratorFrame/administratorAddFlower.jsp";
            $("#clickDemo").load(demo);
        });
        $("#administrator_orderManager").click(function(){      
            window.location.href = "orderManager";
        });
        $("#administrator_storeInfo").click(function(){
            window.location.href="myStore";
        });
        $("#storeInfo").click(function(){
        	demo = "${pageContext.request.contextPath}/UiFile/AdministratorFrame/storeInfo.jsp";
            $("#clickDemo").load(demo);
        });
    });

</script>
</body>
</html>