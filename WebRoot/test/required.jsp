<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>validate验证框架演示</title>
		<%@include file="/js/validate/validate.jsp"%>
	<body>
		<form name="form1">
			用户名<input type="text" value="" name="n1"/><br>
			密码<input type="text" value="" name="n2"/><br>
			性别 <select name="n3">
					<option value=""></option>
					<option value="male">男</option>
					<option value="female">女</option>
				</select><br>
			备注<textarea name="n4"></textarea><br>
			<input type="button" value="干掉他" onclick="validate()" name="n1">
			
		</form>
	</body>
	<script language="javascript">
		new RequiredValidator().add("n1", "n2", "n3", "n4");
	</script>
</html>
