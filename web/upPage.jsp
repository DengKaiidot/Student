<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    #a{
        width: 70%;
        height: 600px;
        background-color: lemonchiffon;
        margin-left: 240px;
        margin-top: 50px;
        position: absolute;
    }
    #b{
        margin-left: 300px;
        margin-top: 100px;

    }
    input{
        margin-top: 15px;
        margin-left: 70px;
        font-size: 30px;
        color: red;
        font-family: 华文新魏;
    }
    button{
        background-color: azure;
        width: 100px;height: 25px;
        font-size: 20px;
        font-family: 华文新魏;
        margin-left: 110px
    }
    span{
        margin-left: 100px;
        color: red;
    }


</style>
<script>
    function goMainPage() {
        //goMainPage admId
        window.location.href = "goMainPage?admId=${admId}"
    }
    function sureUp() {
        /*
        * 我们去访问服务器要拿的参数
        * 1.灵魂：就是管理员的id 1  admId:
        * 2.处理对象： 学生  stuId:
        * 3.成绩：a b c d  4
        *
        * */
        let a=document.getElementById("a1").value;
        let b=document.getElementById("a2").value;
        let c=document.getElementById("a3").value;
        let d=document.getElementById("a4").value;
        window.location.href = "upStu?admId=${admId}&stuId=${stuId}&a="+a+"&b="+b+"&c="+c+"&d="+d;
    }
</script>


<body>
<div id ="a">

    <%--
        admId  stuId
    --%>

    <div style="font-size: 40px;margin-top: 40px;margin-left: 70px">成绩修改界面</div>
    <span>被修改者${stuId}</span><br>
    <span>修改者:&nbsp;${admId}</span><br>
        <button onclick="updatePassword()" style="width: 150px">修改密码</button>
        <script>
            function updatePassword(){
                window.location.href = "updatePassword?upId=${stuId}&admId=${admId}";
            }
        </script>
    <div id = "b">

        <c:if test="${role==1}">

            语文:&nbsp;&nbsp;<input type="text" id="a1"><br>
            <br>
            数学:&nbsp;&nbsp;<input type="text" id="a2"><br>
            <br>
            英语:&nbsp;&nbsp;<input type="text" id="a3"><br>
            <br>
            理综:&nbsp;&nbsp;<input type="text" id="a4"><br>
            <br>
            <button onclick="sureUp()">确认修改</button>
        </c:if>

        <button onclick="goMainPage()">回主界面</button>&nbsp;&nbsp;

    </div>
</div>


</div>



</body>
</html>
