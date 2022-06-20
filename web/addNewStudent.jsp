<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
    <style >
        #fra{
            width: 500px;
            height: 600px;
            margin: 15% auto;
            background-color: skyblue;
            border: solid silver 2px;
            radius: 5px;
        }
        #a,#b{
            width: 300px;

            margin-left: 70px;
            margin-top: 10px;
        }
        input{
            width: 180px;
            height: 25px;
            border: solid silver 2px;
            font-size: 20px;
        }
        #btn01{
            width: 110px;
            height: 30px;
            margin-left: 150px;
        }


    </style>
    <script>
        window.onload = function s(){
            document.getElementById("btn01").onclick=function x() {
                let name=document.getElementById("a1").value;
                let pwd=document.getElementById("a2").value;
                let phone=document.getElementById("a3").value;
                let a=document.getElementById("a4").value;
                let b=document.getElementById("a5").value;
                let c=document.getElementById("a6").value;
                let d=document.getElementById("a7").value;

                window.location.href = "addStudent?name="+name+"&pwd="+pwd+"&phone="+phone+"&a="+a+"&b="+b+"&c="+c+"&d="+d;
            }
        }



    </script>


</head>
<body>
<div id="fra">
    个人信息<br>
    <div id="a" style="font-size: 20px">
        姓名：&nbsp;<input type="text" id="a1"><br><br>
        密码：&nbsp;<input type="text" id="a2"><br><br>
        电话：&nbsp;<input type="text" id="a3"><br><br>
    </div>
    <hr>
    <br>成绩信息<br>
    <div id="b" style="font-size: 20px">
        语文：&nbsp;<input type="text" id="a4"><br><br>
        数学：&nbsp;<input type="text" id="a5"><br><br>
        英语：&nbsp;<input type="text" id="a6"><br><br>
        理综：&nbsp;<input type="text" id="a7"><br><br>
    </div>
    <button id="btn01">确认添加</button>
</div>

</body>
</html>
