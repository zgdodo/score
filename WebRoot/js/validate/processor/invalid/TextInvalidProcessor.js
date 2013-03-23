var TextInvalidProcessor = Class.create();
TextInvalidProcessor.prototype = Object.extend(new InvalidProcessor(), 
{
	initialize:function(element, field, validator)
	{
		this.invalidInitialize(element, field, validator);
	},
	process:function()
	{
		this.defaultProcess();
		var s = "<span>" + this.validator.getMessage(this.field.label) + "</span>";
		_insertAfter_(this.element, s);
        _next_(this.element, 0).name = validateSpanNameOfErrorMsg;
        _addClassName_(_next_(this.element, 0), classNameOfValidateErrorMsg);
        _addClassName_(this.element, classNameOfValidateErrorInput);
	}
});