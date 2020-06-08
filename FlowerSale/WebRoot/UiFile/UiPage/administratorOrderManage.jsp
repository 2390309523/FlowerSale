<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    isELIgnored="false" pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/UiFile/image/logo.png"  />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/UiFile/CSS/globle_css.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/UiFile/CSS/personalpage.css"/>
    <script src="${pageContext.request.contextPath}/UiFile/JQ/JQ.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>订单管理</title>
<style>
	*{margin:0 auto;text-align: center;}
	#footer{position: fixed;height: 80px;width: 100%;bottom: 0;background-color: darkgray;}
	#footer div{float: left;height: 80px;width: 150px;line-height: 80px;color:white;font-size: 25px;text-align: center;}
	#footer div:hover{background-color: red;}
	#return{position: fixed;top:30px;left: 30px;height:50px;width: 50px;background-color:darkgray;border-raduis:50px;
	text-align: center;line-height: 50px;	}
	#return:hover{background-color:red;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<div class="order_manager">
	<div id="return">return</div>
    <table class="gridtable">

        <form action="" id="myForm">
            <caption style="padding-top:25px;">订单管理</caption>
            <tr>
                <th><input type="checkbox" name="order_check_main">全选</th>
                <th>商品名称</th>
                <!-- <th>图片</th> -->
                <th>商店</th>
                <th>用户</th>
                <th>用户邮箱</th>
                <th>个数</th>
                <th>商品单价</th>
                <th>订单号</th>
                <th>
					<select id="selectOrderType" onchange="toHref()" style="height: 100%;width: 100%;background:none;text-align: center;">
						<option value="all">全部</option>
						<option value="0" >未处理</option>
						<option value="1">已发货</option>
						<option value="2">已删除</option>
					</select>
				</th>
            </tr>
            <tr>
            	<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
            </tr>
            <!--这里用数据库动态渲染-->
            <c:forEach items="${orders}" var="order" varStatus="loop">
            	<tr>
                	<td><input type="checkbox" name="orderCheck" value="${order.id }">选择</td>
                	<td><a href="orderFlowerMainInfo?orderId=${order.id}" style="color !importent;">${order.flower}</a></td>
                	<%-- <td><a href="orderFlowerMainInfo?orderId=${order.id}" style="display:block;height: 20px;width: 20px;"><img src="${flowers[loop.count-1].filePath}"></a></td> --%>
                	<td>${order.store }</td>
                	<td>${users[loop.count-1].username }</td>
                	<td>${users[loop.count-1].email }</td>
                	<td>${order.num }</td>
                	<td>${flowers[loop.count-1].flowerUpdataPrice}</td>
                	<td>${order.id}</td>
                	<td class="stateCode">${order.stateCode }</td>
            	</tr>
            </c:forEach> 
        </form>
    </table>
    <div id="footer">
    	<div id="deleteSelect">删除</div>
    	<div id="forPrice">发货</div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function(){
    	<% if(ActionContext.getContext().get("deleterInfo")!=null){
    		%>alert("${deleterInfo}")<%
    		ActionContext.getContext().put("deleterInfo",null);
    	}
    	if(ActionContext.getContext().get("senderInfo")!=null){
    		%>alert("${senderInfo}")<%
    		ActionContext.getContext().put("senderInfo",null);
    	}%>	
    	for(i = 0 ; i<$(".stateCode").length ;i++){
    		var code = $(".stateCode")[i].innerHTML;
    		if("0" == code) $(".stateCode")[i].innerHTML = "未发货";
    		else if("1" == code) $(".stateCode")[i].innerHTML = "已发货";
    		else $(".stateCode")[i].innerHTML = "订单已经删除，保存30天";
    	}
	    $("#return").click(function(){
	    	window.location.href="personalPage";
	    });
		 $("#deleteSelect").click(function(){
		 if (confirm("您确定将这些订单删除吗？")) {
			    /* $("#myForm").prop('action','deleteOrder');
	        	$("#myForm").submit(); */
	        	var href="deleteOrder?orderCheck=";
	        	var length = $('input[name=orderCheck]:checked').length;
	        	$.each($('input[name=orderCheck]:checkbox:checked'),function(i,dom){
	        		if(i === length - 1){
	        			href+=$(this).val();
	        		}else{
	        			href+=$(this).val()+",";
	        		}
	        			
			  	});
			  	window.location.href=href;
			 }else {
			    
			}  
    	});
	    $("#forPrice").click(function(){
	    if (confirm("您确定要发货这一些订单？")) {
	        	/* $("#myForm").prop('action','orderForSale');
	        	$("#myForm").submit(); */
	        	var href="orderForSale?orderCheck=";
	        	var length = $('input[name=orderCheck]:checked').length;
	        	$.each($('input[name=orderCheck]:checkbox:checked'),function(i,dom){
	        		if(i === length - 1){
	        			href+=$(this).val();
	        		}else{
	        			href+=$(this).val()+",";
	        		}
	        			
			  	});
			  	window.location.href=href;
			 }else {
			    
			}  ;
	    });
        var i = 0;
        $("input[name='order_check_main']").click(function(){
            if(i%2 == 0){
                $("input[name='orderCheck']").each(function(){
                    for(j = 0 ;j < $("input[name='orderCheck']").length;j++){
                        $("input[name='orderCheck']")[j].checked = true;
                    }
                })
                i++;
            }else if(i%2 == 1){
                $("input[name='orderCheck']").each(function(){
                    for(j = 0 ;j < $("input[name='orderCheck']").length;j++){
                        $("input[name='orderCheck']")[j].checked = false;
                    }
                })
                i++;

            }
        });
    });
    function toHref(){
    	var options=$("#selectOrderType>option:selected");
    	var value = options.val();
    	window.location.href="selectOrderType?value="+value;
    }
</script>
</html>