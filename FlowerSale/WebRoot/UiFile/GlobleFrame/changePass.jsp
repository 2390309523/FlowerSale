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
    <div class="header">${user.dailyName}</div>
    <div class="info">
        <form action="changePassword" id="changePassword" method="post">
            <div class="item list-item">
                <div class="first">请输入密码</div>
                
                <div class="third" style="width: 60% !important"><input type="password" name="password" required/></textarea></div>
            	<div class="third" style="width: 10% !important"><span id="pass"></span></div>
            </div>
             <div class="item list-item">
                <div class="first">请输入更新后的密码</div>
                
                <div class="third" style="width: 60% !important"><input type="password" name="changePassword1" required/></textarea></div>
            </div>
             <div class="item list-item">
                <div class="first">请再次输入更新后的密码</div>
                
                <div class="third" style="width: 60% !important"><input type="password" name="changePassword2" required/></div>
            	<div class="third" style="width: 10% !important"><span id="passCheck"></span></div>
            </div>
            <div class="item" style="height: 50px">
                <input type="submit" id="submit" value="更新" style="height: 100%;width: 100%;border-radius:15px;">
            </div>
            <div></div>
        </form>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/UiFile/JQ/JQ.js"></script>
<script>
$(document).ready(function(){
		$("input[name='password']").mouseout(function(){
            var pass1 = $("input[name='password']").val();
            var pass2 = "${user.password}";
            if(pass1 == pass2){
                $("#pass").html("<a style='color:green'>密码正确</a>");
                $("changePassword").attr('action',"changePassword");
            }else{
                $("#pass").html("<a style='color: red'>密码错误</a>");
                $("changePassword").attr('action',"#");
            }
        });
        $("input[name='changePassword2']").mouseout(function(){
            var pass1 = $("input[name='changePassword1']").val();
            var pass2 = $("input[name='changePassword2']").val();
            if(pass1 == pass2){
                $("#passCheck").html("<a style='color:green'>正确</a>");
            }else{
                $("#passCheck").html("<a style='color: red'>两次密码不一致</a>");
            }
        });
    });
	var commitStatus = false;
	function dosubmit(){
	    if(commitStatus==false){
	     //提交表单后，讲提交状态改为true
	       commitStatus = true;
	       return true;
	    }else{
	       return false;
	    }
	}
</script>
</body>
</html>