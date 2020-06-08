<%@ page language="java" contentType="text/html;  charset=utf-8"
   isELIgnored="false" pageEncoding="utf-8"%>
   
<!-- 获取用户当前登录信息 -->
<table class="gridtable">
    <tr>
        <th>用户ip</th><th>登入时间</th><th>客户端类型</th><th>操作</th>
    </tr>
    <tr>
        <td><%=request.getLocalAddr() %></td><td>${user.updataTime}</td><td>window7</td><td>updataTime</td>
    </tr>

</table>