<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>validate验证框架演示</title>
		<%@include file="/js/validate/validate.jsp"%>
	<body>
		<form name="form1">
			用户名<input type="text" value="2" name="n1"/>
			邮箱<input type="text" value="3" name="n2"/>
			<br>
			<input type="button" value="干掉他" onclick="validate()">
			
		</form>
	</body>
	<script language="javascript">
		
		new RequiredValidator().add("n1", "n2");
		new EmailValidator().add("n2");
		
		validateErrorMsgDisplayStyle = 'alert';//'text';//要用alert进行提示,只需要调一下这个语句即可(位置只要在<\%@include file="/js/validate/validate.jsp"%>后面即可)
	</script>
</html>
