<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style >
        #fra{
            width: 500px;
            height: 500px;
            margin: 15% auto;
            background-color: skyblue;
            border: solid silver 2px;
            border-radius: 5px;
        }
        #a,#b{
            width: 300px;

            margin-left: 70px;
            margin-top: 20px;
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

      /*  document.getElementById("btn01").addEventListener("click", x)


        let btn01=document.getElementById("btn01");
         function x() {
            let pwd = document.getElementById("a2").value;
            window.location.href="update?upid=${upid}&mainid=${mainid}&pwd="+pwd;
            alert(pwd)
        }*/

      document.getElementById("btn0001").onclick=function () {
          alert(1)
      }



    </script>
</head>
<body>
<div id="fra" >
    个人信息<br>
    <div id="a" style="font-size: 20px;margin-left: 150px;margin-top: 200px">
        <input type="text" id="a1" readonly value="${upid}"><br><br>
        请输入新密码： <input type="text" id="a2"><br><br>
        <button id="btn">确认修改</button>
        <script>
            document.getElementById("btn").onclick=function () {
                let pwd = document.getElementById("a2").value;
                window.location.href="update?upid=${upid}&mainid=${mainid}&pwd="+pwd;
            }
        </script>
    </div>
</div>

</body>
</html>
