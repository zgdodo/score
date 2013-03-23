<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>validate验证框架演示</title>
		<%@include file="/js/validate/validate.jsp"%>
	<body>
		<form name="form1">
			用户名<input type="text" value="" name="n1"/><br>
			邮箱<input type="text" value="" name="n2"/><br>
			
			<input type="button" value="取消必输验证" onclick="requiredValidator.remove('n1', 'n2');"/><!-- 所有验证器都有remove()函数 -->
			<input type="button" value="添加必输验证" onclick="requiredValidator.add('n1', 'n2');"/><!-- 所有验证器都可以通过add()函数来添加要验证的字段 -->
			<br><input type="button" value="干掉他" onclick="validate()"/>
		</form>
	</body>
	<script language="javascript">
		var requiredValidator = new RequiredValidator();
		requiredValidator.add("n1", "n2");
		new EmailValidator().add("n2");
	</script>
</html>
