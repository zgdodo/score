<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>validate验证框架演示</title>
		<%@include file="/js/validate/validate.jsp"%>
	<body>
		<form name="form1">
			日期1<input type="text" value="" name="d1"/>
			日期2<input type="text" value="" name="d2"/>
			<br>
			日期1<input type="text" value="" name="d1"/>
			日期2<input type="text" value="" name="d2"/>
		</form>
		<br>
		<form name="form2">
			日期1<input type="text" value="" name="d1"/>
			日期2<input type="text" value="" name="d2"/>
			<br>
			日期1<input type="text" value="" name="d1"/>
			日期2<input type="text" value="" name="d2"/>
		</form>
		<br>
		<form name="form3">
			数字1<input type="text" value="2" name="n1"/>
			数字2<input type="text" value="3" name="n2"/>
			<br>
			数字1<input type="text" value="2" name="n1"/>
			数字2<input type="text" value="3" name="n2"/>
		</form>
		<br>
		无form的字段:<br>
		数字1<input type="text" value="2" name="n1"/>
		数字2<input type="text" value="3" name="n2"/>
		
		<br>
		<input type="button" value="干掉form1" onclick="validateForm('form1')">
		<input type="button" value="干掉form2" onclick="validateForm('form2')">
		<input type="button" value="干掉form3" onclick="validateForm('form3')">
		<input type="button" value="干掉form2和form3" onclick="validateForm('form2', 'form3')">
		<input type="button" value="干掉form1和form3" onclick="validateForm('form1', 'form3')">
		<input type="button" value="干掉所有" onclick="validate()">
	</body>
	<script language="javascript">
		var field2 = new Field("日期2","d2");
		var fieldn2 = new Field("数字2","n2");
		
		new RequiredValidator().add("d1", "d2");

		new CompareValidator().add("d1").set('v', '>', field2);
		new CompareValidator().add("n1").set('n', '>', fieldn2);
	</script>
</html>
