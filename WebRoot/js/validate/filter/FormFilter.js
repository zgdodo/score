var FormFilter = Class.create();
FormFilter.prototype = Object.extend(new DefaultFilter(), 
{
	initialize:function(params)
	{
		this.defaultInitialize(params);
	},
	filter:function(element)
	{
		try 
		{
			for (var i = 0; i < this.params.length; i++)
			{
				if (element.form.name == this.params[i])
				{
					return true;
				}
			}
			return false;
		}
		catch (e)
		{
			return false;
		}
	}
});