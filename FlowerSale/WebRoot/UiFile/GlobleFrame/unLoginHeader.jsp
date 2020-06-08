<%@ page language="java" contentType="text/html; charset=utf-8"
    isELIgnored="false" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>unLogin</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/UiFile/JQ/JQ.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/UiFile/JQ/jquery.color.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/UiFile/CSS/headerStyle.css">
</head>
<body>
<header>
	<li><a href="welcome">画手</a></li>
	<ul>
		<li><a href="toLogin">登录</a></li>
		<li><a href="toRegister">注册</a></li>
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

    });
</script>
</html>