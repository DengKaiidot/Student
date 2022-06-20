
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主界面</title>
    <style>
        #head_{
            height: 100px;
            width: 100%;
            background-color: slategray;
        }
        #personFile{
            width: 120px;
            height: 50px;
            padding-top: 25px;
            margin-left: 90%;
        }
        #search{
            height: 70px;
            width: 100%;
            background-color: cornflowerblue;
        }
        #inner_s{
            /*width: 200px;
            height: 40px;
            padding-right: 70%;
            padding-top: 50%;*/
            width: 30%;
            padding-top:25px;
            padding-left: 45%;
        }
        #table{
            margin-left: 30%;
            margin-top: 30px;
        }
        td{
            text-align: center;
            height: 20px;
            width: 150px;
            border: black 1px solid;
            padding:1px;

        }

        button{
            width: 60px;
            height: 26px;
            background-color: blanchedalmond;
        }

    </style>

    <script>
        function search() {
            let v=document.getElementById('fileId').value;
            //要搜索的信息就拿回来了
            /*
            *
             * v id  名字
             *
             *
        */
            window.location.href = "show?v="+v+"&id=${user.getU_id()}";
        }


        function add() {
            if("${user.getU_id()}"=="1001"){
                window.open("addNewStudent.jsp",null,"width=700,height=600,left=400,top=200",true);
            }else{
                alert("你无权添加！");
            }


        }

        function goShow(v) {
            window.location.href = "show?v="+v+"&id=${user.getU_id()}";
        }

        function del(v,name) {
            let isdel = confirm("是否删除"+v+"同学？");
            if(isdel){
                window.location.href = "del?v="+v+"&id=${user.getU_id()}";
            }else{
                return;
            }
        }

        function upDate(v) {
            /*
            * v:学生的id
            *
            * 我们先跳到服务器里  从服务器里在跳到修改界面
            * 1.学生的id
            * 2.管理员的id
            *
            * */
            window.location.href = "upTo?stuId="+v+"&admId=${user.getU_id()}";
        }
        function updatePassword(){
            window.location.href = "updatePassword?upId=${user.getU_id()}&admId=${user.getU_id()}";
        }


    </script>

</head>
<body>

<div id="head_">
    <div id="personFile">
        名字:<span style="color: red">${user.getU_name()}</span><br>
        编号:<span style="color: red">${user.getU_id()}</span><br>
        <%--
            本人修改自己的密码
        --%>
        <button onclick="updatePassword()" style="width: 150px">修改密码</button>
    </div>
</div>


<div id="search">
    <div id="inner_s">
        <input  type="text" style="font-size: 20px; height: 26px;width: 190px" id="fileId">
        <script>
            let v = document.getElementById("fileId").value;
        </script>
        <button  style="font-size: 18px; height: 28px;" onclick="search()">查询</button>&nbsp;&nbsp;
        <button  style="font-size: 18px; height: 28px;" onclick="add()">添加</button>
    </div>
</div>

<div>
    <table id="table" style="height: 30px;width: 700px;border: black 1px solid;border-collapse:collapse;">
        <tr >
            <td>学生id</td>
            <td>学生名字</td>
            <td>学生电话</td>
            <td>查看成绩</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${arr}" var="item">
            <c:if test="${item.getRole()==1}">
                <tr>
                    <td>${item.getU_id()}</td>
                    <td>${item.getU_name()}</td>
                    <td>${item.getU_phone()}</td>
                    <td><button style="color: chocolate;width: 100px" onclick="goShow(${item.getU_id()})">查看成绩</button></td>
                    <td><button style="color: chocolate" onclick="upDate(${item.getU_id()})">修改</button>
                        <button style="color: chocolate" onclick="del(${item.getU_id()})">删除</button>
                    </td>
                </tr>
            </c:if>



        </c:forEach>




    </table>
</div>


<div>







</div>




</body>
</html>

