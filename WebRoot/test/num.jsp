<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>validate验证框架演示</title>
		<%@include file="/js/validate/validate.jsp"%>
	<body>
		<form name="form1">
			数字1<input type="text" value="dd" name="n1"/>
			数字2<input type="text" value="3" name="n2"/>
			<br>
			数字1<input type="text" value="2" name="n1"/>
			数字2<input type="text" value="dd" name="n2"/>
			<br>
			<input type="button" value="干掉他" onclick="validate()">
			
		</form>
	</body>
	<script language="javascript">
		new NumValidator().add("n1", "n2");
	</script>
</html>
