<%--
  Created by IntelliJ IDEA.
  User: alexau
  Date: 2019/8/7
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
    <title>购物车</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<h1 align="center" >购物车</h1>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>商品名称</td>
        <td>单价</td>
        <td>数量</td>
        <td>小计</td>
    </tr>

    <c:forEach items="${ois}" var="oi" varStatus="st">
        <tr>
            <td>${oi.product.name}</td>
            <td>${oi.product.price}</td>
            <td>${oi.num}</td>
            <td>${oi.product.price*oi.num}</td>
            <td>
                <form action="deleteOrderItem" method="post" name="delete">
                    <input type="hidden" name="name" value="${oi.product.name}">
                    <input type="submit" name="delete" value="删除" >
                </form>
            </td>
        </tr>
    </c:forEach>

    <c:if test="${!empty ois}">
        <tr>
            <td colspan="4" align="right">
                <a href="createOrder">生成订单</a>
            </td>
        </tr>
    </c:if>
</table>