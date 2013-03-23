var AlertInvalidProcessor = Class.create();
AlertInvalidProcessor.prototype = Object.extend(new InvalidProcessor(), 
{
	initialize:function(element, field, validator)
	{
		this.invalidInitialize(element, field, validator);
	},
	process:function()
	{
		this.defaultProcess();
		_addClassName_(this.element, classNameOfValidateErrorInput);
        alert(this.validator.getMessage(this.field.label));
	}
});