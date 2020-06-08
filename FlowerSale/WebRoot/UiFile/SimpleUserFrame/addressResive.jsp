<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/UiFile/image/logo.png"  />
<link rel="stylesheet" href="./UiFile/CSS/address.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/UiFile/JQ/JQ.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>地址管理</title>
</head>
<body>
<div class="header" >
	<a href="personalPage" style="float:left;">返回</a>
    <span>收货地址</span>
    <a style="float: right;" id="addNewAddress">新增收货地址</a>
</div>
<div class="address">
	<c:forEach items="${addresses}" var="address" varStatus="loop">
	    <div class="address_list">
	        <div class="list half">
	            <div class="country">收货地址</div>
	            <div class="addressInfo">${address.adressSpecific} </div>
	        </div>
	        <div class="list phone">
	            <div class="country">收货人:</div>
	            <div class="">${address.resiveName }</div>
	        </div>
	        <div class="list phone">
	            <div class="country">电话:</div>
	            <div class="">${address.addressPhone }</div>
	        </div>
	        <div class="del">设置默认：<input type="radio" value="${address.isdefault}" name="isDefault" onchange="setAsDefault('${address.id}')"></div>
	        <div class="del" onclick="deleteCar('${address.id}')"><a>delete</a></div>
	        <div class="del"><a onclick="edit('${address.id}')">Edit</a></div>
	    </div>
	</c:forEach>
</div>


<div id="updataAddress">
    <div class="updataAddressHeader">
        <span>修改购物车</span>
    </div>
    <form method="post" action="updataAddress" id="updataAddressForm">
        <div class="addressUpdataInfo">
            <table>
                <tr>
                    <td>国家</td>
                    <td><input type="text" name="countries"></td>
                </tr>
                <tr>
                    <td>城市</td>
                    <td><input type="text" name="city" ></td>
                </tr>
                <tr>
                    <td>区县</td>
                    <td><input type="text" name="country" ></td>
                </tr>
                <tr>
                    <td>收货人姓名</td>
                    <td><input type="text" name="resiveName" placeholder="默认为${user.dailyName}"></td>
                </tr>
                <tr>
                    <td>收货电话</td>
                    <td><input type="text" name="phone"></td>
                </tr>
                <tr>
                    <td>具体地址</td>
                    <td>
                        <textarea form="updataAddressForm" name="specific" rows="6"></textarea>
                    </td>
                </tr>
                <tr>
                    <td><input type="reset" value="重置"></td>
                    <td>
                        <input type="submit" value="更新">
                        <button id="closeChange">不改了</button>
                    </td>
                </tr>
                <input name="addressId" id="addressId" value="" type="hidden">
            </table>
        </div>
    </form>
</div>

<div id="addAddress">
    <div class="updataAddressHeader">
        <span>新增加收货地址</span>
    </div>
    <form method="post" action="addAddress" id="addAddressForm">
        <div class="addressUpdataInfo">
            <table>
                <tr>
                    <td>国家</td>
                    <td><input type="text" name="countries" required="required"></td>
                </tr>
                <tr>
                    <td>城市</td>
                    <td><input type="text" name="city" required="required"></td>
                </tr>
                <tr>
                    <td>区县</td>
                    <td><input type="text" name="country" required="required"></td>
                </tr>
                <tr>
                    <td>收货人姓名</td>
                    <td><input type="text" name="resiveName" placeholder="默认为${user.dailyName}"></td>
                </tr>
                <tr>
                    <td>收货电话</td>
                    <td><input type="text" name="phone" placeholder="默认为${user.phone}"></td>
                </tr>
                <tr>
                    <td>具体地址</td>
                    <td>
                        <textarea form="addAddressForm" name="specific" rows="6" required="required"></textarea>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="更新"><button onclick="$('#addAddress').hide()">不加了</button>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</div>
</body>
<script src="JS/jquery-3.1.1.min.js" type="application/javascript"></script>
<script>
   $(document).ready(function(){
   	$("input[value='1']").prop("checked",true);
        $("#updataAddress").hide();
        $("#addAddress").hide();
        $("#closeChange").click(function () {
            $("#updataAddress").hide();
        })
        $("#addNewAddress").click(function () {
            $("#addAddress").show();
            $("#updataAddress").hide();
        })
    });
    function edit(data){
        $("#updataAddress").show();
        $("#addressId").val(data);
        $("#addAddress").hide();
    }
    function updataAddressInfo(addressId){
    	
    }
    function deleteCar(addressId){
	    if (confirm("您确定将这个收货地址删除吗？")) {
	        $.post("deleteAddress",{addressId:addressId},function(data)  
			{  
	   			if(data!=null){
	   				window.location.href="#";
	   			}else{
	   				alert("删除失败");
	   			}
			}); 
		}else{}
    }
    function setAsDefault(addressId){
	    $.post("setAsDefault",{addressId:addressId},function(data)  
		{  
	   		if(data!=null){
	   		
	   			window.location.href="#";
	   		}else{
	   			alert("删除失败");
	   		}
		}); 
		
    }
</script>
</html>