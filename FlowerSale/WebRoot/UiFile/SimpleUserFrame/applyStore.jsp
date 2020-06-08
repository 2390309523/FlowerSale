<%@ page language="java" contentType="text/html; charset=utf-8"
    isELIgnored="false" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>商店信息</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/UiFile/CSS/listItem.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/UiFile/JQ/JQ.js"></script>
<title>申请商店</title>
<style type="text/css">
	textarea {width:100% !important;heigth:100px !important;}
</style>
</head>
<body>
<div id="storeInfo">
    <div class="header">${user.dailyName}，商店资格申请(测试版本，没有限制)</div>
    <div class="info">
        <form action="applayStore" id="applayStore" method="post" enctype="multipart/form-data">
            <div class="item list-item">
                <div class="first">请输入商店名字</div>
                <div class="third" style="width: 60% !important"><input type="text" name="storeName" id="storeName" required/></div>
            	<div class="third" style="width: 10% !important"><span id="storeNameCheck"></span></div>
            </div>
            <div class="item simple-item">
                <div class="first">请输入店铺简介</div>
                <div class="second" style="width: 60% !important">
                	<textarea name="storeIntroduce" form="applayStore" style="height:100% !important;"></textarea>
                </div>
            	<div class="third" style="width: 10% !important"><span id="storeIntroduceCheck"></span></div>
            </div>
            <div class="item list-item">
                <div class="first">请输入商店地址</div>
                <div class="third" style="width: 60% !important"><input type="text" name="storeAddress" id="storeAddress" required/></div>
            	<div class="third" style="width: 10% !important"><span id="storeAddressCheck">选择默认收货地址？</span></div>
            </div>
            <div class="item list-item">
                <div class="first">上传店铺头像</div>
                <div class="third" style="width: 60% !important"><input type="file" accept="image/gif,image/jpeg,image/jpg,image/png,image/svg" name="storeIcon" id="storeIcon" required/></div>
            </div>
            <div class="item" style="height: 50px">
                <input type="submit" value="更新" style="height: 100%;width: 100%;border-radius:15px;">
            </div>
        </form>
    </div>
</div>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#storeName").blur(function(){
			var storeName = $(this).val();
			$.ajax({
				type : "POST",
				url:"findStoreIsExist",
				data: {
                    storeName: storeName
                },
				async:false,
			    cache:false,
			    success : function(msg) {
			    	if(msg == "yes"){
			    		$("#storeNameCheck").html("<a style='color:red'>店铺存在</a>");
			    	}else if(storeName.length>0){
			    		$("#storeNameCheck").html("<a style='color:green'>店铺合法</a>");
			    	}else{
			    		$("#storeNameCheck").html("<a>输入此字段</a>");
			    	}
			     },
				});
		});
		$("#storeAddressCheck").click(function(){
			$.ajax({
				type : "POST",
				url : "getDefaultAddress",
				data: {
                    username: "${user.username}"
                },
				async:false,
			    cache:false,
			    success : function(addressInfo) {
			    	
			    	if(addressInfo.length>2){
			    		$("#storeAddress").val(addressInfo);
			    		$("#storeAddressCheck").html("<a style='color:green;'>合法</a>")
			    	}else{
			    		$("#storeAddressCheck").html("<a style='color:red;line-height:12px;'>您还是老老实实填写此字段吧</a>");
			    	}
			     },
				});
		});
		$("textarea[name='storeIntroduce']").blur(function(){
			var length = $(this).val().length;
			if(length>255){
				$("#storeIntroduceCheck").html("<a style='color:red;line-height:30px'>有毒把，写这麽多！不通过，通不过！</a>");
			}else if(length>10 && length<=255){
				$("#storeIntroduceCheck").html("<a style='color:green;line-height:30px'>对了喔！</a>");
			}else{
				$("#storeIntroduceCheck").html("<a style='color:black;line-height:30px;'>你特莫倒数输入大于10个字啊！</a>");
			}
		})
	});
</script>
</html>