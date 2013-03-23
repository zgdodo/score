var InvalidProcessorFactory = Class.create();
InvalidProcessorFactory.prototype =
{
	initialize:function()
	{},
	create:function(element, field, validator)
	{
		if (validateErrorMsgDisplayStyle == 'alert')
		{
			return new AlertInvalidProcessor(element, field, validator);
		}
		else
		{
			return new TextInvalidProcessor(element, field, validator);
		}
	}
};