<%@ page pageEncoding="utf-8"%>
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/js/validate/css/validate.css" />
<!-- the order of the following imports can not be changed -->
<script language="javascript">
	var validateI18nMsgRequired = "{0}不允许为空!";
	var validateI18nMsgEmail = "{0}不是一个合法的邮箱!";
	var validateI18nMsgInt = "{0}必须为整数!";

	var validateI18nMsgDatetime = "{0}不是一个合法的日期时间! 正确的格式为{1}";

	var validateI18nMsgNumRange = "{0}必须为数字,且在{1}和{2}之间!";
	var validateI18nMsgNumRangeNum = "{0}必须为数字!";
	var validateI18nMsgNumRangeMin = "{0}必须为数字,且小于等于{1}!";
	var validateI18nMsgNumRangeMax = "{0}必须为数字,且大于等于{1}!";

	var validateI18nMsgNum = "{0}必须为数字!";
	var validateI18nMsgRegex = "{0}不合法!{1}";
	var validateI18nStringCompare = "{0}必须{1}{2}[{3}]!";
	var validateI18nNumCompare = "{0}必须为数字,且{1}{2}[{3}]!";

	var validateOperatorLabelMap = new Array();
	validateOperatorLabelMap["<"] = "小于";
	validateOperatorLabelMap["<="] = "小于或等于";
	validateOperatorLabelMap["=="] = "等于";
	validateOperatorLabelMap["!="] = "不等于";
	validateOperatorLabelMap[">"] = "大于";
	validateOperatorLabelMap[">="] = "大于或等于";
</script>

<script src="<%=request.getContextPath()%>/js/validate/depends/jquery.js" language="javascript"></script>
<script src="<%=request.getContextPath()%>/js/validate/depends/static-jquery.js" language="javascript"></script>

<script src="<%=request.getContextPath()%>/js/validate/processor/Processor.js" language="javascript"></script>
<script src="<%=request.getContextPath()%>/js/validate/processor/invalid/InvalidProcessor.js" language="javascript"></script>
<script src="<%=request.getContextPath()%>/js/validate/processor/invalid/TextInvalidProcessor.js" language="javascript"></script>
<script src="<%=request.getContextPath()%>/js/validate/processor/invalid/AlertInvalidProcessor.js" language="javascript"></script>
<script src="<%=request.getContextPath()%>/js/validate/processor/invalid/InvalidProcessorFactory.js" language="javascript"></script>

<script src="<%=request.getContextPath()%>/js/validate/validator/BaseValidator.js" language="javascript"></script>
<script src="<%=request.getContextPath()%>/js/validate/validator/Field.js" language="javascript"></script>

<script src="<%=request.getContextPath()%>/js/validate/filter/DefaultFilter.js" language="javascript"></script>
<script src="<%=request.getContextPath()%>/js/validate/filter/FormFilter.js" language="javascript"></script>

<script src="<%=request.getContextPath()%>/js/validate/validator/RegexValidator.js" language="javascript"></script>
<script src="<%=request.getContextPath()%>/js/validate/validator/RequiredValidator.js" language="javascript"></script>
<script src="<%=request.getContextPath()%>/js/validate/validator/EmailValidator.js" language="javascript"></script>
<script src="<%=request.getContextPath()%>/js/validate/validator/DatetimeValidator.js" language="javascript"></script>
<script src="<%=request.getContextPath()%>/js/validate/validator/NumValidator.js" language="javascript"></script>
<script src="<%=request.getContextPath()%>/js/validate/validator/IntValidator.js" language="javascript"></script>
<script src="<%=request.getContextPath()%>/js/validate/validator/NumRangeValidator.js" language="javascript"></script>
<script src="<%=request.getContextPath()%>/js/validate/validator/CompareValidator.js" language="javascript"></script>

<script src="<%=request.getContextPath()%>/js/validate/validator/ValidatorFactory.js" language="javascript"></script>