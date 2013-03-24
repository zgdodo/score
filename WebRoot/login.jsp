<%--
  Created by IntelliJ IDEA.
  User: do
  Date: 13-2-21
  Time: 上午10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>欢迎使用成绩查询系统</title>
    <meta name="author" content="Codrops"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="/js/jquery.form.js"></script>
    <script src="js/modernizr.custom.63321.js"></script>
    <!--[if lte IE 7]>
    <style>.main {
        display: none;
    }

    .support-note .note-ie {
        display: block;
    }</style>
    <![endif]-->
    <style>
        @import url(http://fonts.googleapis.com/css?family=Ubuntu:400,700);

        body {
            background: #563c55 url(img/blurred.jpg) no-repeat center top;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            background-size: cover;
        }

        .container > header h1,
        .container > header h2 {
            color: #fff;
            text-shadow: 0 1px 1px rgba(0, 0, 0, 0.7);
        }
    </style>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#loginForm").ajaxForm({
                url: "stuLogin.do",
                beforeSubmit: validate,
                success: showResponse
            });

            function validate(formData, jqForm, options) {
                var form = jqForm[0];
                if (!form.stuNumber.value || !form.password.value) {
                    alert('请输入信息再登陆');
                    return false;
                }
            }

            function showResponse(data) {
                if (data.error != undefined) {
                    alert(data.error);
                } else {
                    window.location.href = data.url;
                }
            }
        })
    </script>
</head>
<body>
<div class="container">

    <header>
        <div class="support-note">
            <span class="note-ie">Sorry, only modern browsers.</span>
        </div>

    </header>

    <section class="main">
        <form class="form-3" method="post" id="loginForm">
            <p class="clearfix">
                <label for="stuNumber">学号</label>
                <input type="text" name="stuNumber" id="stuNumber" placeholder="请输入学号">
            </p>

            <p class="clearfix">
                <label for="password">密码</label>
                <input type="password" name="password" id="password" placeholder="请输入密码">
            </p>

            <p class="clearfix">
                <input type="checkbox" name="remember" id="remember">
                <label for="remember">Remember me</label>
            </p>

            <p class="clearfix">
                <input type="submit" name="submit" value="Sign in">
            </p>
        </form>
    </section>

</div>

</body>
</html>