<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>validate验证框架演示</title>
		<%@include file="/js/validate/validate.jsp"%>  <!-- 第一步 -->
	<body>
		<form name="form1">
			开始日期<input type="text" value="2005-12-19" name="d1"/>
			结束日期<input type="text" value="2005-12-11" name="d2"/>
			<br>
			开始日期<input type="text" value="2005-12-19" name="d1"/>
			结束日期<input type="text" value="2005-12-12" name="d2"/>
			<br>
			开始日期<input type="text" value="2005-12-19" name="d1"/>
			结束日期<input type="text" value="2005-12-13" name="d2"/>
			<br>
			开始日期<input type="text" value="2005-12-18" name="d1"/>
			<br>
			
			数字1<input type="text" value="2" name="n1"/>
			数字2<input type="text" value="6" name="n2"/>
			<br>
			数字1<input type="text" value="2" name="n1"/>
			数字2<input type="text" value="2" name="n2"/>
			<br>
			大数字<input type="text" value="1" name="n3"/>
			小数字<input type="text" value="2" name="n4"/>
			<br>
			<input type="button" value="干掉他" onclick="validate()">
			
		</form>
	</body>
	
	<!-- 第二步 -->
	<script language="javascript">
		var field2 = new Field("结束日期","d2");
		var fieldn2 = new Field("数字2","n2");
		var fieldn4 = new Field("小数字","n4");
		
		new CompareValidator().add("d1").set('v', '<=', field2);
		//set()函数见CompareValidator.js的注释
		new CompareValidator().add("n1").set('n', '!=', fieldn2);//所有有set函数的验证器,都会预设长度为20的验证器数组,以备用
		new CompareValidator().add("n3").set('n', '>=', fieldn4);
		
	</script>
</html>
