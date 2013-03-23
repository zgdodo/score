<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>validate验证框架演示</title>
		<%@include file="/js/validate/validate.jsp"%>
	<body>
		<form name="form1">
			年龄<input type="text" value="2000" name="n1"/>
			<br>
			人口数<input type="text" value="-3" name="n2"/>
			<br>
			海底的海拨<input type="text" value="2" name="n3"/>
			<br>
			天有多高,地有多深<input type="text" value="rr" name="n4"/>
			<br>
			<input type="button" value="干掉他" onclick="validate()">
			
		</form>
	</body>
	<script language="javascript">
		new NumRangeValidator().set(0, 1000).add("n1");
		new NumRangeValidator().set(0, '++').add("n2");//'++'表示无穷大
		new NumRangeValidator().set('--', 0).add("n3");//'--'表示无穷小
		new NumRangeValidator().set('--', '++').add("n4");
	</script>
</html>
