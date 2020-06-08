<%@ page language="java" contentType="text/html; charset=utf-8"
    isELIgnored="false" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--需要index.css的支持-->
<div class="main_box" >
    <div class="back" >
        <ul class="polaroids">  <!--这里用后台动态渲染-->
	        <c:forEach items="${flowers}" var="flower" varStatus="id">
	             <li><a href="flowerInfo?flowerId=${flower.id} " title="${flower.flowerName}:${flower.flowerUpdataPrice}￥" style="background-color:${flower.flowerColor};"> <img src="${flower.filePath}" alt="${flower.flowerName}" /> </a> </li>
	        </c:forEach>
        </ul>
    </div>
</div>