<%@ page language="java" contentType="text/html; charset=utf-8"
    isELIgnored="false" pageEncoding="utf-8"%>
    <table class="gridtable">
        <caption>${store.storeName }</caption>
        <tr>
            <td colspan="2"><img src="${store.storeIconPath }" alt="${store.storeName }"></td>
        </tr>
        <tr>
            <TD>花店销量</TD><td>${store.storeSoleNum }</td>
        </tr>
        <tr>
            <TD>花店地址</TD><td>${store.storeAddress }</td>
        </tr>
        <tr>
            <TD>花店简介</TD><td>${store.storeIntroduce }</td>
        </tr>
    </table>
