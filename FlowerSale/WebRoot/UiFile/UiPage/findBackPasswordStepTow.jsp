<%@ page language="java" import="flower.com.entity.User" contentType="text/html; charset=utf-8"
     isELIgnored="false" pageEncoding="utf-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/UiFile/image/logo.png"/>
<script type="application/javascript" src="${pageContext.request.contextPath}/UiFile/JQ/JQ.js"></script>
<script type="application/javascript" src="${pageContext.request.contextPath}/UiFile/JQ/jquery-form.js"></script>
<title>找回密码</title>
 <style>
        html{width: 100%;height: 100%;}
        #findBackPassword{height: 500px;width: 600px;border-radius: 50px;background: lightgray;margin: 0 auto;margin-top: 100px;}
        .title{height: 100px;width: 100%;line-height: 100px;text-align: center;font-size: 25px;}
        .findMain{height: 400px;width: 100%;}
        .findMain table tr{height: 60px;padding-top: 20px;padding-bottom: 20px;}
        .findMain table tr td:nth-child(1){width: 180px;text-align: right}
        .findMain table tr td:nth-child(2){width: 420px;}
        .findMain table tr td:nth-child(2) input[type="text"],input[type="email"]{width: 300px;height: 30px;}
        .step{height: 30px;width: 100%;}
        .step div{width: 33%;height: 100%;float: left}
        .step div a{display:block;width:100%;text-align: center;}
        .red{border-top:4px solid red}
        .darkgray{border-top: 4px solid darkgray;}
    </style>
</head>
<body>
	<jsp:include page="../GlobleFrame/returnFrame.jsp"></jsp:include>
    <div id="findBackPassword">
        <div class="title">找回密码step2</div>
        <div class="findMain">
                <table>
                    <form action="findBackPasswordStepTow" id="getEmailCode" method="post" onsubmit="return dosubmit()">
                        <tr>
                            <td>验证码：</td>
                            <td><input type="text" name="emailCode"></td>
                        </tr>
                        <tr>
                        	<td></td>
                        	<td>
                        		<input type="hidden" name="username" value="${username}">
                        		<input type="hidden" name="emailCheckCode" value="${emailCheckInfo}">
                        		<input type="submit" value="提交"><a href="findBackPasswordStepOne" style="margin-left: 100px;">返回第一步</a>
                        	</td>
                        </tr>
                        
                    </form>
                    <tr>
                        <td colspan="2">
                            <div class="step">
                                <div class="red">
                                    <a>step1</a>
                                </div>
                                <div class="red"><a>step2</a></div>
                                <div class="darkgray"><a>step3</a></div>
                            </div>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
<script type="text/javascript">
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
</html>