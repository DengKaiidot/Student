<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>成绩查询</title>
    <link href="./layui/css/layui.css" rel="stylesheet">
</head>
<body style="background: url(image/qw.jpg) no-repeat fixed;background-origin:content-box;background-size:cover;">
<div class="layui-form">
    <table class="layui-table" bgcolor="white" >
        <colgroup>
            <col width="100">
            <col width="100">
            <col width="100">
            <col width="100">
            <col width="100">
        </colgroup>
        <thead>
        <tr>
            <th>科目</th>
            <th>语文</th>
            <th>数学</th>
            <th>外语</th>
            <th>理综</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>分数</td>
            <td align="center"><c:forEach items="${arr}" var="item" begin="0" end="0">
                ${item.getB()}
            </c:forEach></td>
            <td align="center"><c:forEach items="${arr}" var="item" begin="1" end="1">
                ${item.getB()}
            </c:forEach></td>
            <td align="center"><c:forEach items="${arr}" var="item" begin="2" end="2">
                ${item.getB()}
            </c:forEach></td>
            <td align="center"><c:forEach items="${arr}" var="item" begin="3" end="3">
                ${item.getB()}
            </c:forEach></td>
        </tr>
        </tbody>
    </table>
</div>
<%--
<c:forEach items="${arr}" var="item">
    科目:${item.getA()}&nbsp;&nbsp;&nbsp;成绩:${item.getB()}<br>
</c:forEach>
--%>

</body>
</html>
