<%@ page language="java" contentType="text/html; charset=utf-8"
    isELIgnored="false" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/UiFile/CSS/globle_css.css">
    <script src="${pageContext.request.contextPath}/UiFile/JQ/JQ.js"></script>
</head>
<body>

    <div id="showStore">
        &gt;
    </div>
    <div id="store_left">
        <div class="title">
            <div>${store.storeName}</div>
            <div>X</div>
        </div>
        <div class="mainInfo">
            <div class="store_icon" style="background-image: url('${store.storeIconPath}');background-size: cover"><img src="${store.storeIconPath}"></div>
            <div class="store_sole_num">
                <p>销量
                    ${store.storeSoleNum}</p>
                <p>创建时间：${store.storeCreateTime}</p>
                <p>商店地点：${store.storeAddress}</p>
            </div>
            <div class="store_introduce">
                <p>商店简介：${store.storeIntroduce}</p>
            </div>
        </div>
    </div>
</body>
<script>
    $(document).ready(function(){

        $("#store_left>.title>div:nth-child(2)").click(function () {
            $("#store_left").animate({'left':'-400px'},1500);
            $("#showStore").show();
        })
        $("#showStore").click(function(){
            $("#showStore").hide();
            $("#store_left").animate({'left':'0px'},1500);
        })
    })
</script>
</html>