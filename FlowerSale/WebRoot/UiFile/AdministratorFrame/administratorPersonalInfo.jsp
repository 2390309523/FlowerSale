<%@ page language="java" contentType="text/html; charset=utf-8"
    isELIgnored="false" pageEncoding="utf-8"%>
        <table class="gridtable">
            <tr>
                <td>welcome：</td><td><img src="${user.headImage} " style="width:50px;height:50px;"></td>
            </tr>
            <tr>
                <td>username:</td><td>${user.username }</td>
            </tr>
            <tr>
                <td>别名：</td><td>${user.dailyName}</td>
            </tr>
            <tr>
                <td>网站身份：</td><td>${user.indentity }</td>
            </tr>
            <tr>
                <td>邮箱：</td><td>${user.email }</td>
            </tr>
            <tr>
                <td>入网时间：</td><td>${user.createTime }</td>
            </tr>
            <tr>
                <td>注册花店的时间：</td><td>${store.storeCreateTime }</td>
            </tr>
        </table>
