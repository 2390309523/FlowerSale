<%@ page language="java" import="flower.com.entity.User" contentType="text/html; charset=utf-8"
     isELIgnored="false" pageEncoding="utf-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/UiFile/image/logo.png"  />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/UiFile/CSS/headerStyle.css">
<title>${flower.flowerName }详情</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/UiFile/CSS/globle_css.css">
    <script type="application/javascript" src="${pageContext.request.contextPath}/UiFile/JQ/JQ.js"></script>
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
</head>
<body>

<div id="flowerMain" style="padding-top:100px;">
    <table style="background-image: url('${flower.filePath}');background-repeat:no-repeat ;background-size:cover;">
        <caption>${flower.flowerName}</caption>
        <tr><td>英文名：</td><td>${flower.englishName}</td></tr>
        <tr><td>店铺：</td><td>${flower.storeName }</td></tr>
        <tr><td>价格：</td><td>${flower.flowerPrice}</td></tr>
        <tr><td>折扣价：</td><td>${flower.flowerUpdataPrice}</td></tr>
        <tr><td>产地：</td><td>${flower.flowerArea}</td></tr>
        <tr><td>种类：</td><td>${flower.flowerType}</td></tr>
        <tr><td>库存量：</td><td>${flower.flowerStoke}</td></tr>
        <tr><td>花语：</td><td>${flower.flowerExpress}</td></tr>
        <tr><td>简介：</td><td>${flower.flowerIntroduce}</td></tr>
    </table>
</div>
</body>
</html>