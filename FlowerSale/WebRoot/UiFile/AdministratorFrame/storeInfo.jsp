<%@page import="com.opensymphony.xwork2.ActionContext,flower.com.entity.Store"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    isELIgnored="false" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>商店信息</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/UiFile/CSS/listItem.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/UiFile/JQ/JQ.js"></script>
</head>
<body>
<div id="storeInfo">
    <div class="header">${store.storeName}</div>
    <div class="info">
        <form action="updataStoreInfo" id="updataStoreInfo" method="post" enctype="multipart/form-data">
            <div class="item simple-item">
                <div class="first">花店简介</div>
                <div class="second">${store.storeIntroduce }</div>
                <div class="third"><textarea form="updataStoreInfo" name="storeIntroduce" class="textarea" placeholder="大于10个字小于255个字，否则无效"></textarea></div>
            </div>
            <div class="item simple-item">
                <div class="first">花店地址</div>
                <div class="second" style="line-height:100px !important;">${store.storeAddress}</div>
                <div class="third"><textarea form="updataStoreInfo" name="storeAddress" placeholder="大于10个字小于255个字，否则无效" class="textarea"></textarea></div>
            </div>
            <div class="item list-item">
                <div class="first">创建时间</div>
                <div class="second">${store.storeCreateTime}</div>
            </div>
            <div class="item img_item">
                <div class="first" style="margin-top:70px;">花店logo</div>
                <div class="second" style="line-height:100px !important;"><img src="${store.storeIconPath }" alt="${store.storeName }"></div>
                <div class="third"><input type="file" accept="image/gif,image/jpeg,image/jpg,image/png,image/svg" name="storeIcon" style="margin-top:70px;"></div>
            </div>
            <div class="item" style="height: 50px">
                <input type="submit" id="submit" value="更新" style="height: 100%;width: 100%;border-radius:15px;">
            </div>
            <div></div>
        </form>
    </div>
</div>
</body>

</html>