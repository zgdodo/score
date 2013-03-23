<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>validate验证框架演示</title>
		<%@include file="/js/validate/validate.jsp"%>
	<body>
		<form name="form1">
			用户名<input type="text" value="2" name="n1"/><br>
			密码<input type="password" value="3" name="n2"/>
			<br>
			<input type="button" value="干掉他" onclick="validate()">
			
		</form>
	</body>
	<script language="javascript">
		new RegexValidator().set(new RegExp("^[a-z]{0,5}$"), "只能输入a-z,且长度为0-5").add("n1");
		new RegexValidator().set(new RegExp("^[A-Z]{0,5}$"), "只能输入A-Z,且长度为0-5").add("n2");
	</script>
</html>
