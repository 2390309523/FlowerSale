<%@ page language="java" contentType="text/html; charset=utf-8"
    isELIgnored="false" pageEncoding="utf-8"%>
<head>
<link rel="stylesheet" href="../CSS/headerStyle.css">
<script type="text/javascript" src="../JQ/JQ.js"></script>
<script type="text/javascript" src="../JQ/jquery.color.min.js"></script>
</head>
<body>
<header id="administratorPersonal">
    <li><a href="welcome">画手</a></li>
    <ul>
    	<form action="fuzzySearch" method="post">
            <span>search</span>
            <input type="text" name="searchInfo"><input type="submit" value="搜索">
        </form>
    	<li><a href="toShoppingCar">购物车</a></li>
        <li><a href="personalPage"><img alt="${user.dailyName}" src="${user.headImage}"></a></li>
        <li><a href="personalPage">个人中心</a></li>
        <li><a href="outLogin">退出登录</a></li>
    </ul>
</header>
</body>
<script>
    $(document).ready(function(){
        $("header").mouseenter(function(){
              $(this).animate({backgroundColor:'#aaaaaa'},500);
        });
        $("header").mouseleave(function(){
            $(this).animate({backgroundColor:'rgba(0,0,0,0)'},500);
        });
		$("#myShoppingCar").click(function(){
			window.location.href= "toShoppingCar";
		})
    });
</script>
</html>