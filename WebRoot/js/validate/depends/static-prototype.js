/**
 * 显示错误的方式.alert: 用alert进行提示; text: 在对象后面跟提示信息
 */
var validateErrorMsgDisplayStyle = 'text';
/**
 * 是否一次性将所有错误都显示出来 true :显示所有 false:只显示一个错误
 */
var validateIsDisplayAllError = true;
var validateSpanNameOfErrorMsg = 'validate_spanname_of_error_msg'; // 提示信息所属span元素的name属性值
/**
 * 一些css class变量
 */
var classNameOfValidateErrorMsg = "validate_error_message"; // 提示信息的样式
var classNameOfValidateErrorInput = "validate_error_input"; // 输入有误时,给输入框的样式
var classNameOfValidateRequiredStar = "validate_required_star"; // 必须输入项后面紧跟着一个星号的样式
var Class = {
	create : function() {
		return function() {
			this.initialize.apply(this, arguments);
		}
	}
};
Object.extend = function(destination, source) {
	for ( var property in source) {
		destination[property] = source[property];
	}
	return destination;
}

// ----------------- static method start -------------------------//
/**
 * @param name标签的name属性值
 * @param tagName标签的名字
 *            根据tagName和name属性获取对象 获取不到返回null,否则返回数组
 */
function getByNameAndTagName(name, tagName) {
	var s = document.getElementsByTagName(tagName);
	if (!s) {
		return null;
	}
	var j = 0;
	var ret = new Array();
	for ( var i = 0; i < s.length; i++) {
		if (s[i].name == name) {
			ret[j++] = s[i];
		}
	}
	return j == 0 ? null : ret;
}
/**
 * validate all
 */
function validate() {
	return validatorFactory.validate();
}
/**
 * validate form eg:validateForm('formname1', 'formname2'... );
 */
function validateForm() {
	return validatorFactory.validateForm(arguments);
}
/**
 * cancel validate
 */
function cancelValidate() {
	validatorFactory.removeAll();
}
// --------------------------- 依赖于具体的js框架实现的跨浏览器的代码
/**
 * 将htmlElement插入到srcElement元素后面
 * 
 * @param srcElement
 * @param htmlElement
 */
function _insertAfter_(srcElement, htmlElement) {
	new Insertion.After(srcElement, htmlElement);
}
/**
 * 为element添加className样式
 * 
 * @param element
 *            被操作的元素
 * @param className
 *            样式名
 * @return
 */
function _addClassName_(element, className) {
	element.addClassName(className);
}
/**
 * 为element删除className样式
 * 
 * @param element
 *            被操作的元素
 * @param className
 *            样式名
 * @return
 */
function _removeClassName_(element, className) {
	element.removeClassName(className);
}
/**
 * 返回element后面的的第index个元素
 * 
 * @param element
 *            被操作的元素
 * @param index
 *            从0开始
 * @return
 */
function _next_(element, index) {
	return element.next(index);
}
/**
 * 返回element前面的的第index个元素
 * 
 * @param element
 *            被操作的元素
 * @param index
 *            从0开始
 * @return
 */
function _previous_(element, index) {
	return element.previous(index);
}
/**
 * 删除某一个元素
 * 
 * @param element
 * @return
 */
function _remove_(element) {
	return element.remove();
}

/**
 * 相当于string的trim
 * @param str
 * @return
 */
function _trim_(str) {
	return str.strip();
}