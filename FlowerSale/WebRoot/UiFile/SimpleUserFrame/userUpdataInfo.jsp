<%@ page language="java" contentType="text/html; charset=utf-8"
    isELIgnored="false" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>商店信息</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/UiFile/CSS/listItem.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/UiFile/JQ/JQ.js"></script>
 
    <div class="info" >
        <form action="changeSimpleUserInfo" id="changeSimpleUserInfo" method="post" onsubmit="return dosubmit()" enctype="multipart/form-data">
        	<div class="item img_item">
                <div class="first" style="margin-top:70px;">头像</div>
                <div class="second" style="line-height:100px !important;"><img src="${user.headImage }" alt="${user.dailyName }"></div>
                <div class="third"><input type="file" name="headImage" style="margin-top:70px;"></div>
            </div>
            <div class="item list-item">
                <div class="first">别名</div>
                <div class="second">${user.dailyName}</div>
                <div class="third"><input type="text" name="daliyName"></div>
            </div>
            <div class="item list-item">
                <div class="first">网站身份</div>
                <div class="second">${user.indentity}</div>
            </div>
            <div class="item list-item">
                <div class="first">邮箱</div>
                <div class="second">${user.email}</div>
                <div class="third"><input type="email" name="email"></div>
            </div>
            <div class="item list-item">
                <div class="first">电话号码</div>
                <div class="second">${user.phone}</div>
                <div class="third"><input type="text" name="phoneNumber"></div>
            </div>
            <div class="item list-item">
                <div class="first">用户创建时间</div>
                <div class="second">${user.createTime }</div>
            </div>
            <div class="item list-item">
                <div class="first">最近一次登录</div>
                <div class="second">${user.updataTime}</div>
            </div>
            <div class="item" style="height: 50px">
                <input type="submit" id="submit" value="更新" style="height: 100%;width: 100%;border-radius:15px;">
            </div>
            <div></div>
        </form>
    </div>
</div>

</form>
<script>
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