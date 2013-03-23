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
    <title>成绩查询登录</title>
    <script type="text/javascript" src="jquery/jquery.js"></script>
    <link rel="Stylesheet" type="text/css" href="jquery/login.css" />
    <%@include file="/js/validate/validate.jsp"%>
</head>
<script language="javascript">
    new RequiredValidator.add("stuNumber","password");
</script>
<body>
<form action="exTest.do" method="post">
    <div class="message">请输入学号登录</div>
    <table width="258" border="0" align="center" cellpadding="05" cellspacing="0" id="logintable">
        <tr>
            <td width="100">&nbsp;</td>
            <td width="172">&nbsp;</td>
        </tr>
        <tr>
            <td>学号</td>
            <td><label for="stuNumber"></label>
                <input name="stuNumber" type="text" id="stuNumber"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><label for="password"></label>
                <input name="password" type="password" id="password"></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><input type="button" value="提交" onclick="validate()"></td>
        </tr>
    </table>
</form>
</body>
</html>