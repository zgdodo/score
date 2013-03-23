/*--------------- 各种验证器 start ------------------*/
/**
 * 必须输入
 */
new RequiredValidator().add("name1", "name2");

/**
 * 邮箱
 */
new EmailValidator().add("name1", "name2");

/**
 * 比较器.set的第二个参数可以为[<,>,<=,>=,==,!=],第一个参数可以是[n,v]
 */
new CompareValidator().add("name1").set('v', '<=', new Field("字符串A", "name3"));// 字符串比较是'v',varchar的简写

/**
 * 日期
 */
new DatetimeValidator().set("yyyy/mm/dd").add("name1", "name2");

/**
 * 整数
 */
new IntValidator().add("name1", "name2");

/**
 * 数字
 */
new NumValidator().add("name1", "name2");

/**
 * 数字范围
 */
new NumRangeValidator().set(0, 1000).add("name1", "name2"); // 0到1000之间,包括0和1000
new NumRangeValidator().set(0, '++').add("name1", "name2"); // '++'表示无穷大
new NumRangeValidator().set('--', 0).add("name1", "name2"); // '--'表示无穷小
new NumRangeValidator().set('--', '++').add("name1", "name2");// 相当于数字验证

/**
 * 正则表达式
 */
new RegexValidator().set(new RegExp("^[A-Z]{0,5}$"), "只能输入A-Z,且长度为0-5").add(
		"name1", "name2");

/*--------------- 各种验证器 end ------------------*/

/**
 * 默认为'text',要用alert进行提示,只需要调一下这个语句即可 此语句的位置只要在
 * <\%@include file="/js/validate/validate.jsp"%>后面即可
 */
validateErrorMsgDisplayStyle = 'alert';

/**
 * 如果要验证某个表单,这样使用
 */
validateForm('form2', 'form3');

/**
 * 移除字段(以邮箱验证器为例)
 * 对于可能有移除操作的验证器,必须先定义一个变量来保存验证器,不能直接用new XxValidator().add();
 */
var emailValidator = new EmailValidator();
emailValidator.add("name1", "name2");
//... 
emailValidator.remove("name1", "name2");
