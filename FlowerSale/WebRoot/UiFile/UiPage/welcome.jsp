<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="java.util.*,flower.com.entity.User" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/UiFile/image/logo.png"  />
    <title>欢迎光临画手</title>
  </head>
  	<link rel="stylesheet" href="../CSS/index.css">
  	<script type="text/javascript" src="${pageContext.request.contextPath}/UiFile/JQ/JQ.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/UiFile/JQ/jquery.color.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/UiFile/CSS/index.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/UiFile/CSS/headerStyle.css">
<style>
	#prevPage,#nextPage{color: white;position: fixed;height:40px;width:40px;bottom: 0px;background: rgba(255,255,255,.7);font-size: 26px;text-align: center;border-radius:8px;line-height:40px;}
	#nextPage{right:0;}
</style>

  <body style="margin-bottom: 70px;">
  <div id="myStore"></div>
   	<%User user = (User)session.getAttribute("user"); 
   	if(user!=null){
   		if("simple_user".equals(user.getIndentity())){
   			%><jsp:include page="../SimpleUserFrame/userHeaderFrame.jsp"></jsp:include> <%
   		}else if("administrator".equals(user.getIndentity())){
   			%><jsp:include page="../AdministratorFrame/administratorHeader.jsp"></jsp:include> <%
   		}
   			
   	}else{
   		%><jsp:include page="../GlobleFrame/unLoginHeader.jsp"></jsp:include> <%
   	} %>
   	<jsp:include page="../GlobleFrame/flowerPicWall.jsp"></jsp:include>
   	<div id="prevPage">
   		<a href="flowerPrevPage">&lt;</a>
   	</div>
   	<div id="nextPage">
   		<a href="flowerNextPage">&gt;</a>
   	</div>
  </body>
  <script type="text/javascript">
  	$(document).ready(function(){
  		<% if(session.getAttribute("user") != null && ActionContext.getContext().get("loginInfo")!=null){
  			%>alert("${loginInfo}")<%
  			ActionContext.getContext().put("loginInfo", null);
  		}
  		if(ActionContext.getContext().get("myStoreInfo")!=null){
  			%>
  				$("#myStore").load("${pageContext.request.contextPath}/UiFile/AdministratorFrame/administratorStoreLeftFrame.jsp");
  				ActionContext.getContext().put("myStoreInfo",null);
  			<%
  		}
  		%>
  	});
  </script>
</html>
