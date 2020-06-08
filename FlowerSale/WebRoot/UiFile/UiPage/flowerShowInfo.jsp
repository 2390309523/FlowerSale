<%@page import="com.opensymphony.xwork2.ActionContext,flower.com.entity.Flower,flower.com.entity.User"%>
<%@ page language="java" import="flower.com.entity.User" contentType="text/html; charset=utf-8"
     isELIgnored="false" pageEncoding="utf-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/UiFile/image/logo.png"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/UiFile/CSS/headerStyle.css">
<title>花卉详情</title>
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
<body class="bgdark">
<div class="flower_centerBlock">
    <div id="slideImage">
        <div>
            <ul>
                <c:forEach items="${flowerFiles}" var="file" varStatus="id">
	             	<li><img src=" ${file.filePath}" alt="${flower.flowerName}"></li>
	        	</c:forEach>
                 
            </ul>
        </div>
        <span id="slideLeft">&lt;</span>
        <span id="slideRight">&gt;</span>
    </div>
    </div>
    <div class="flower_main_info">
        <div class="introduce">
            ${flower.flowerName}
        </div>
        <div class="price">
            <div class="line" style="width:100%;"><span class="disuse">原价：</span><h3 class="disuse">￥${flower.flowerPrice}</h3></div><br>
            <div class="line" style="width:100%;"><span>促销价：</span><h2>${flower.flowerUpdataPrice}</h2><span style="margin-left:30px;">库存：${flower.flowerStoke }</span></div>
            <div class="line" style="width:100%;">活动时间：今天到以后</div>
        </div>
        <div class="flower_express">
            花语：${flower.flowerExpress }
        </div>
        <form action="shopCaraddAction" method="post">
            <div class="buy_flower">
                <div class="buy_block">
                    <span class="adder" id="reduction">-</span><input type="text" name="buynum" size="2" value="1"><span class="adder" id="add">+</span>
                </div>
                <div class="show_price">
                    <span id="showPrice" style="overflow: hidden;">￥${flower.flowerUpdataPrice} </span>
                </div>
            </div>
            <div class="sub">
                <input type="button" value="购买">
                <input type="button" value="加入购物车" class="left_width red">
            </div>
        </form>

    </div>
<div class="flower_introduce">
    <div class="title">
        ${flower.flowerName}
    </div>
    <div class="info">
        ${flower.flowerIntroduce}<br><a href="flowerInfoDetailed?flowerId=${flower.id}" style="background:white;">了解更多---></a>
        <%
        	if(user!=null){
        		ActionContext context = ActionContext.getContext();
        		Flower flower = (Flower)context.get("flower");
        		if("administrator".equals(user.getIndentity()) && user.getStoreName().equals(flower.getStoreName())){
        		%><span onclick="updataFlower()" style="float:right;background:darkgray;">
        			更新花卉信息
        		</span><%
        	}
        	}
        	
         %>
    </div>
</div>



</body>
<script>

    $(document).ready(function(){
        var liLenth = $("#slideImage>div>ul>li").length;
        var i = 0;
        var add = $("#add");
        var reduction = $("#reduction");
        var showPrice = $("#showPrice");
        var timer  = setInterval(function(){
            if(i>=liLenth){
                i = 0;
            }
            slideImage(i);
            i++;
        },2000);
        $("#slideImage").mouseover(function(){
            clearInterval(timer);
        });
        $("#slideImage").mouseout(function(){
            timer =setInterval(function(){
                if(i>=liLenth){
                    i = 0;
                }
                slideImage(i);
                i++;
            },2000);
        });
         $("#slideLeft").click(function(){
            if(i>=liLenth-1){
                i=-1;
            }
            i++;
            slideImage(i);


        });
        $("#slideRight").click(function(){
            if(i<=0){
                i=liLenth;
            }
            i--;
            slideImage(i);	
        });
        add.click(function(){
            var num = parseInt($("input[name='buynum']")[0].value);
            if(num>=100 && num<=parseInt("${flower.flowerStoke}")){
                $("input[name='buynum']")[0].value = ""+num;
                showPrice.html("￥"+((num)*parseFloat("${flower.flowerUpdataPrice}")).toFixed(2));
            }else{
                $("input[name='buynum']")[0].value = ""+(num+1);
                showPrice.html("￥"+((num+1)*parseFloat("${flower.flowerUpdataPrice}")).toFixed(2));
            }


        });
        reduction.click(function(){
            var num = parseInt($("input[name='buynum']")[0].value);
            if(num<=1 && num<=parseInt("${flower.flowerStoke}")){
                $("input[name='buynum']")[0].value = ""+num;
                showPrice.html("￥"+((num)*parseFloat("${flower.flowerUpdataPrice}")).toFixed(2));
            }else{
                $("input[name='buynum']")[0].value = ""+(num-1);
                showPrice.html("￥"+((num-1)*parseFloat("${flower.flowerUpdataPrice}")).toFixed(2));
            }
            /*这里是price*/
            $("input[name='buynum']")[0].mouseout(function(){
                var num = parseInt($("input[name='buynum']")[0].value);
                showPrice.html("￥"+(num)*10);
            });
        });
        $("input[value='购买']").click(function(){
            <% if(session.getAttribute("user") == null){
        		%> alert("您还没有登录，登录先？");
        			window.location.href = "toLogin";
        		<%
        	} else{
        	  %>
        		window.location.href = "addToOrder?flowerNum="+$("input[name='buynum']")[0].value+"&flowerId=${flower.id}";
        	<%}%>
        });
        $("input[value='加入购物车']").click(function(){
        	<% if(session.getAttribute("user") == null){
        		%> alert("您还没有登录，登录先？");
        			window.location.href = "toLogin";
        		<%
        	} else{
        	%>
        		window.location.href = "addToShopCar?flowerNum="+$("input[name='buynum']")[0].value+"&flowerId=${flower.id}";
        	<%}%>
        });
        <%if(ActionContext.getContext().get("addInfo")!=null){
        	%>alert("${addInfo}")<%
        }%>
    })
    function slideImage(index){
        $("#slideImage>div").animate({'marginLeft':-400*index+'px'},1000);
    };
   function updataFlower(){
   		window.location.href = "toUpdataFlower?flowerId=${flower.id}";
   };
</script>
</body>
</html>