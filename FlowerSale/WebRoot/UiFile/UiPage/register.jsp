<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/UiFile/CSS/register.css">
    <title>注册</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Badge Signup Form template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
	<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/UiFile/image/logo.png"  />
    <!-- Custom Theme files -->
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!-- //Custom Theme files -->

</head>
<body>
    <!-- main -->
    <div class="w3layouts-main">
        <h1>用户注册</h1>
        <div class="agilesign-form">
            <div class="agileits-top">
                <form action="register" method="post">
                    <div class="styled-input w3ls-text">
                        <input type="text" name="username" required="" />
                        <label>Username</label>
                        <span></span>
                    </div>
                    
                    <div class="styled-input w3ls-text">
                        <input type="password" name="password" required="">
                        <label>Password</label>
                        <span></span>
                    </div>
                    <div class="styled-input w3ls-text">
                        <input type="password" name="passwordAgain" required=""/>
                        <label>Password Again</label>
                        <span></span>
                    </div>
             		<div class="styled-input w3ls-text">
                        <input type="text" name="email" required="" />
                        <label>Email</label>
                        <span></span>
                    </div>
                    <div class="wthree-text">
                        <p>
                            <input type="checkbox" id="brand" name="checkUser"/>
                            <label for="brand"><span></span>同意用户协议,点击注册表示同意</label>
                        </p>
                    </div>
                    <div class="agileits-bottom">
                        <input type="submit" value="REGISRER">
                    </div>
                </form>
            </div>
            <div class="w3agile-btm">
                <p>已经有账号 ? <a href="toLogin"> 登录</a> <a href="welcome">返回主页面>></a></p>
            </div>
        </div>
    </div>
    <div class="copyright">
        <p>@版权所有，侵权必究<a href="welcome">drow hand</a></p>
    </div>
    <!-- //copyright -->
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/UiFile/JQ/JQ.js"></script>
<script type="text/javascript">
	window.onload = function(){
		<% if(ActionContext.getContext().get("registerInfo")!=null){
			%>alert("${registerInfo}")<%
		}%>
		$("input[name='username']").blur(function(){
			var username=$(this).val();
			$.ajax({
				type : "POST",
				url:"checkUsername",
				data: {
                    username: username
                },
				async:false,
			    cache:false,
			    success : function(info) {
			    	if(info == "yes"){
			    		alert("用户名存在，请重新输入！");
			    		$("input[name='username']").val(""); 
			    	}else{
			    		$("#storeNameCheck").html("<a>输入此字段</a>");
			    	}
			     },
			});
			$("input[name='email']").blur(function(){
				var email = $(this).val();
				$.ajax({
					type:"POST",
					url:"checkEmail",
					data:{
						email:email
					},
					async:false,
			    	cache:false,
					success : function(info) {
						if(info == "yes"){
							alert("邮箱已经被占用了！");
							$("input[name='email']").val("");
						}else{
						}
					}
				})
			});
		});
	};
</script>
</html>