<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    注册
</h1>

<div>
    姓名:<input type="text" id="a"><br>
    手机:<input type="text" id="b"><br>
    密码:<input type="password" id="c"><br>
    <button onclick="sure()">注册</button>
    <script>
        function sure(){
            let a = document.getElementById('a').value;
            let b = document.getElementById('b').value;
            let c = document.getElementById('c').value;
            window.location.href = 'reg?a='+a+'&b='+b+'&c='+c;
        }
    </script>


</div>


</body>
</html>
