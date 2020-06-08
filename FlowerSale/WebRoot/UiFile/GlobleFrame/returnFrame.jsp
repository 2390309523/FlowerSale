<%@ page language="java" contentType="text/html; charset=utf-8"
    isELIgnored="false" pageEncoding="utf-8"%>
<html lang="en">
<head>

    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/UiFile/css/globle_css.css">
    <script type="application/javascript" src="${pageContext.request.contextPath}/UiFile/js/JQ.js"></script>
</head>
<body>
<header class="return_frame">
    <div>return</div>
</header>
</body>
<script>
    $(document).ready(function(){
        $(".return_frame>div").click(function(){
            window.location.href = "welcome";
        })
    })
</script>
</html>