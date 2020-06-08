<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购物车</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/UiFile/CSS/shoppingCarStyle.css">
    <script type="application/javascript" src="${pageContext.request.contextPath}/UiFile/JQ/JQ.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/UiFile/JQ/jquery.color.min.js"></script>
</head>
<body>
    <div id="shoppingCar">
        <form method="post" id="myForm" action="">
            <table>
                <thead>
                    <tr style="height: 50px;">
                        <td>
                            <input type="checkbox" class="ChooseAll">
                            <span>全选</span>
                        </td>
                        <td>商品或服务名称</td>
                        <td>小计</td>
                        <td>数量</td>
                        <td>单价</td>
                        <td>操作</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${shopCars}" var="shopCar" varStatus="loop">
                    	<tr>
                        <td>
                            <input type="checkbox" name="flowerCheched" value="${shopCar.id}">
                        </td>
                        <td class="tdBlock">
                            <span class="goodName"><img src="${flowers[loop.count-1].filePath }" alt="${flowers[loop.count-1].flowerName }"></span>
                            <div class="goodInfo">
                                <p>${flowers[loop.count-1].storeName }</p>
                                <p>${flowers[loop.count-1].flowerName }</p>
                                <p>${flowers[loop.count-1].flowerExpress }</p>
                            </div>
                        </td>
                        <td class="red"><span>￥</span><span class="simple_price"></span></td>
                        <td>
                            <div>
                                <span class="deleter">-</span>
                                <input type="text" name="flowerChose" id="flowerChose" size="3" value="${shopCar.flowerNum}" style="float: left">
                                <span class="adder">+</span>
                            </div>
                        </td>
                        <td class="sumPrice"><span class="sumPrice">${flowers[loop.count-1].flowerUpdataPrice}</span></td>
                        <td><span class="del"><a href="deleteSimpleShopCar?shopCarId=${shopCar.id}">delete</a></span></td>
                    </tr>
                    </c:forEach>
                    <tr></tr>
                </tbody>
            </table>
        </form>
    </div>
<div id="Footer">
    <div class="choseAll">
        <span>全选</span>&nbsp;<input type="checkbox" class="ChooseAll">
    </div>
    <div class="allPrice">
        总价：￥<span id="AllSumPrice">0</span>
    </div>
    <div class="delete">
        <span id="deleteSelect">删除</span>
        <span id="forPrice">结算</span>
    </div>
</div>
<div id="returnTop">
    TOP
</div>
<div id="return">
    return
</div>
</body>
<script type="application/javascript" src="${pageContext.request.contextPath}/UiFile/JQ/shoppingCar.js"></script>
<script type="text/javascript">
	<% if(ActionContext.getContext().get("shopCarForPriceInfo")!=null){
		%>alert("${shopCarForPriceInfo}")<%
		ActionContext.getContext().put("shopCarForPriceInfo",null);
	}%>
</script>
</html>