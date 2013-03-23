var ValidatorFactory = Class.create();
ValidatorFactory.prototype = {
	initialize : function() {
		this.validatorArray = new Array();
	},
	/**
	 * 移除所有验证器
	 */
	removeAll : function() {
		for ( var i = 0; i < this.validatorArray.length; i++) {
			this.validatorArray[i].removeAll();
		}
	},
	/**
	 * 用法:validatorFactory.add(validator1, validator2,validator3... ...
	 * validatorx);
	 */
	add : function() {
		var startIndex = this.validatorArray.length;
		for ( var i = 0; i < arguments.length; i++) {
			this.validatorArray[i + startIndex] = arguments[i];
		}
	},
	validate : function() {
		return this.validateByFilter(new DefaultFilter(null));
	},
	validateByFilter : function(filter) {
		var ret = true;
		var baseValidator = new BaseValidator();
		baseValidator.clearMessage();
		for ( var i = 0; i < this.validatorArray.length; i++) {
			if (!this.validatorArray[i].validateByFilter(filter)) {
				ret = false;
				if (!validateIsDisplayAllError) {
					return false;
				}
			}
		}
		return ret;
	},
	validateForm : function(formNames) {
		return this.validateByFilter(new FormFilter(formNames));
	}
};
var validatorFactory = new ValidatorFactory();