var InvalidProcessor = Class.create();
InvalidProcessor.prototype = Object.extend(new Processor(), 
{
	initialize:function(element, field, validator)
	{
		this.invalidInitialize(element, field, validator);
	},
	invalidInitialize:function(element, field, validator)
	{
		this.element = element;
		this.field = field;
		this.validator = validator;
	},
	process:function()
	{
		this.defaultProcess();
	},
	defaultProcess:function()
	{
		if (this.element.style.display == 'none')//对于不可见的元素,不处理
        {
            return;
        }
        try
	    {
	        this.element.select(true);
	    }
	    catch (e)
	    {}
	    try
	    {
	        this.element.focus(true);
	    } 
	    catch (e)
	    {}
	}
});