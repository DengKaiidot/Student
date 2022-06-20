<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
    <style>
        #frame_{
            width: 500px;
            height: 400px;
            margin: 15% auto;
            border: black solid 2px;
            background-color: #d9d9d9;
        }

        #inner_{
            margin-right: 140px;
            margin-left: 140px;
            margin-top: 100px;
        }
        #h1{
            margin-right: 120px;
            margin-left: 120px;
            margin-top: 30px;
            font-family: 黑体;
            font-size: 30px;
            font-weight: bolder;
        }


    </style>
    <link href="./layui/css/layui.css" rel="stylesheet">

</head>
<body style="background: url(image/qw.jpg);background-size:100% 100% ; background-attachment: fixed">
<div id="frame_">
    <div id="h1">
    学生成绩管理系统
    </div>
    <div id="inner_">
        账号 <input id="u_id" type="text" name="username" lay-verify="title" autocomplete="off" placeholder="请输入您的用户名" class="layui-input"><br><br>
        密码 <input id="u_pwd" type="text" name="username" lay-verify="title" autocomplete="off" placeholder="请输入您的密码" class="layui-input">
        <button id="btn02" type="button" class="layui-btn layui-btn-lg layui-btn-normal">注册</button><button style="margin-left: 20px" id="btn01" type="button" class="layui-btn layui-btn-lg layui-btn-normal">登录</button><br>
        <span id="error" style="color: red">${error}</span>
        <script>
            let btn001 = document.getElementById("btn01");
            let btn002 = document.getElementById("btn02");
            btn001.onclick=function () {
                // 1.获取id查看是否为空
                let id_str = document.getElementById("u_id").value;
                if(id_str==null||id_str==""){
                    document.getElementById("error").innerHTML="账户不能为空！"
                    return;
                }
                let pwd_str=document.getElementById("u_pwd").value;
                if(pwd_str==null||pwd_str==""){
                    document.getElementById("error").innerHTML="密码不能为空！"
                    return;
                }
                //我们就开始访问服务器
                window.location.href = "login?u_id="+id_str+"&u_pwd="+pwd_str;
            }



            btn002.onclick=function () {
                /*
                *
                * 注册：
                * */
                window.open("register.jsp",null,"width=400,height=400,left=500,top=500",true);

            }


        </script>

    </div>


</div>

</body>
</html>
