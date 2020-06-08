<%@page import="com.opensymphony.xwork2.ActionContext,flower.com.entity.Store"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    isELIgnored="false" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>更新花卉信息</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/UiFile/CSS/listItem.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/UiFile/JQ/JQ.js"></script>
</head>
<body>
<div id="storeInfo">
    <div class="header">${store.storeName}</div>
    <div class="info">
        <form action="updataFlowerInfo" id="updataFlowerInfo" method="post" enctype="multipart/form-data" onsubmit="return onsubmit()">
            <div class="item list-item">
                <div class="first">花名</div>
                <div class="third"><input type="text" name="flowerName" placeholder="${flower.flowerName }"/></div>
            	<div class="second"><span id="flowerNameInfo"></span></div>
            </div>
            <div class="item list-item">
                <div class="first">单价</div>
                <div class="third"><input type="text" name="flowerPrice" placeholder="${flower.flowerPrice }"/></div>
            </div>
            <div class="item list-item">
                <div class="first">折扣价</div>
                <div class="third"><input type="text" name="flowerUpdataPrice" placeholder="${flower.flowerUpdataPrice }"/></div>
            </div>
            
            <div class="item list-item">
                <div class="first">大致颜色</div>
                <div class="third"><input type="color" name="flowerColor" value="${flower.flowerColor}" id="color" onchange="changeColor()" style="width: 50% !important;"><span id="colorInfo">${flower.flowerColor}</span></div>
            </div>
            
            <div class="item list-item">
                <div class="first">最大可购买</div>
                <div class="third"><input type="text" name="flowerMaxBuy" placeholder="${flower.flowerMaxBuy}"/></div>
            </div>
            <div class="item list-item">
                <div class="first">库存量</div>
                <div class="third"><input type="text" name="flowerStock" placeholder="${flower.flowerStoke }"/></div>
            </div>
            <div class="item list-item">
                <div class="first">花卉科目</div>
                <div class="third"><input type="text" name="flowerType" placeholder="${flower.flowerType }"/></div>
            </div>
             <div class="item list-item">
                <div class="first">英文名</div>
                <div class="third"><input type="text" name="flowerEnglishName" placeholder="${flower.englishName }"/></div>
            </div>
            <div class="item simple-item">
                <div class="first">生长环境</div>
                <div class="third"><textarea form="updataFlowerInfo" name="flowerArea" class="textarea" placeholder="大于10个字，少于100个字"></textarea></div>
            </div>
            <div class="item simple-item">
                <div class="first">花语</div>
                <div class="third"><textarea form="updataFlowerInfo" name="flowerExpress" class="textarea" placeholder="大于10个字，少于100个字"></textarea></div>
            </div>
            <div class="item simple-item">
                <div class="first">简介</div>
                <div class="third"><textarea form="updataFlowerInfo" name="flowerIntroduce" class="textarea" placeholder="大于10个字，少于255个字"></textarea></div>
            </div>    
            <div class="item list-item">
                <div class="first">更新展示图片</div>
                <div class="third"><input type="file" name="picture"></div>
            </div>
          	<div class="item" style="height: 50px">
                <input type="submit" id="submit" value="更新" style="height: 100%;width: 100%;border-radius:15px;">
            </div>
            <input type="hidden" value="${flower.id }" name="flowerId">
        </form>
    </div>
</div>
</body>
</div>
<script type="text/javascript">
$(document).ready(function(){
    	$("input[name='flowerName']").blur(function(){
    		var flowerName = $(this).val();
    		if(flowerName.length  == 0){
    				$("#flowerNameInfo").html("<a style='color:darkgray;'>请输入花卉名字（与您店铺的其他花卉不能重复）</a>");
    		}else{
		    	$.ajax({
		    		url:"getStoreAndFlowerName",
		    		type:"POST",
		    		data:{
		    			flowerName:flowerName
		    		},
		    		success:function(flowerInfo){
		    			if(flowerInfo == "yes"){
		    				$("#flowerNameInfo").html("<a style='color:red;'>花卉名字与您店铺里面的花卉名字重复</a>");
		    			}else{
		    				$("#flowerNameInfo").html("<a style='color:greem;'>名字合法</a>");
		    			}
		    		}
		    	}); 
		    }
    	});
    });
	<% if(ActionContext.getContext().get("addFlowerInfo")!=null){
		%>alert("${addFlowerInfo}")<%
	}%>
    var color = document.getElementById("color"); 
    var colorInfo = document.getElementById("colorInfo");
    colorInfo.style.color = color.value;  
    colorInfo.innerHTML = color.value;
    function changeColor(){ 
        colorInfo.style.color = color.value;
        colorInfo.innerHTML = color.value;
    }
   	var commitStatus = false;
	function dosubmit(){
    if(commitStatus==false){
     //提交表单后，讲提交状态改为true
       commitStatus = true;
       return true;
    }else{
       return false;
    }
};
</script>
