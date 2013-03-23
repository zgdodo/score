var IntValidator = Class.create();
IntValidator.prototype = Object.extend(new NumValidator(), {
	initialize:function()
	{
		this.baseInitialize();
		this.message = validateI18nMsgInt;
	},
	validate:function(str)
	{
		return this.validateInt(str);
	},
	validateInt:function(str)
	{
		if (str == null || str == "")
		{
			return true;//不验证为空的串
		}
		try 
		{
			if (this.validateNum(str))
			{
				var test = (str % 10) + " ";
				if (test.indexOf(".") == -1)
				{
					return true;
				}
				else 
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		catch (e)
		{
			return false;
		}
	}
});