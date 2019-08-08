<%--
  Created by IntelliJ IDEA.
  User: alexau
  Date: 2019/8/7
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:if test="${!empty user}">
    <div align="center">
        当前用户: ${user.name}
    </div>
</c:if>

<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>名称</td>
        <td>价格</td>
        <td>购买</td>
    </tr>
    <c:forEach items="${products}" var="product" varStatus="st">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>

                <form action="addOrderItem" method="post" name="add">

                    数量<input type="text" value="1" name="num" size="3">
                    <input type="hidden" name="pid" value="${product.id}">
                    <input type="submit" name="add" value="加入购物车">
                </form>
            </td>
        </tr>
    </c:forEach>

</table>
<div  align="center">
    <form action="listOrderItem" method="post" name="check">
        <input  name="check" value="查看购物车" type="submit">
    </form>
</div>