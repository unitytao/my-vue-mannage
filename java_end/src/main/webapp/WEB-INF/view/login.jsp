<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js" ></script>
    <link rel="stylesheet" href="/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/login.css" />
</head>

<body>
    <div class="cen">
        <span class="title">中软人事管理系统</span>
        <input type="text" id="name" class="gro" placeholder="请输入用户名">
        <input type="password" id="pwd" class="gro" placeholder="请输入密码">
        <input type="button" id="submit" class="btn-primary" value="登录">
    </div>
</body>

<script type="text/javascript">
    $(function () {

        $("#submit").click(function () {
            var data = {
                userId: 2,
                ptnId: 1
            };
            $.ajax({
                url: "/user/updatePosition",
                type: "POST",
                dataType: "text",
                data: data,
                success: function (result) {
                    console.log(result);
                    /*if (result == "success") {
                        alert("登录成功");
                    } else{
                        alert("账号或密码不正确");
                    }*/
                },
                error: function (result) {
                    console.log(result);
                }
            });
        });

    })
</script>
</html>
