<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生界面</title>
</head>
<style>
    #a{
        width: 70%;
        height: 600px;
        background-color: skyblue;
        margin-left: 240px;
        margin-top: 20px;
        position: absolute;
    }
    #b{
        margin-left: 300px;
        margin-top: 30px;

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
    function goLogin() {
        //goMainPage admId
        window.location.href = "goLogin"
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

    <div style="font-size: 40px;margin-top: 40px;margin-left: 70px">学生成绩界面</div>
    <span>id:&nbsp;${user.getU_id()}</span><br>
    <span>欢迎&nbsp;${user.getU_name()}&nbsp;同学查看成绩</span><br>
    <button onclick="updatePassword()" style="width: 150px">修改密码</button>
    <script>
        function updatePassword(){
            window.location.href = "updatePassword?upId=${user.getU_id()}&admId=${user.getU_id()}";
        }
    </script>
    <div id = "b">
        ${user.getU_name()}&nbsp;:你的的成绩如下  请继续努力<br>

            <c:forEach items="${arr}" var="item">
                ${item.getA()}&nbsp;:&nbsp;<input type="text" id="a1" value="${item.getB()}" readonly><br><br>
            </c:forEach>



<%--
        计算机网:&nbsp;&nbsp;<input type="text" id="a1" readonly><br>
        <br>
        软件工程:&nbsp;&nbsp;<input type="text" id="a2" readonly><br>
        <br>
        软件测试:&nbsp;&nbsp;<input type="text" id="a3" readonly><br>
        <br>
        机器学习:&nbsp;&nbsp;<input type="text" id="a4" readonly><br>
        <br>
        <button onclick="goLogin()">退出</button>&nbsp;&nbsp;--%>
    </div>
</div>


</div>



</body>
</html>
