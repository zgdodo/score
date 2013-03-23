var NumValidator = Class.create();
NumValidator.prototype = Object.extend(new BaseValidator(), {
	initialize:function()
	{
		this.baseInitialize();
		this.message = validateI18nMsgNum;
	},
	validate:function(str)
	{
		return this.validateNum(str);
	},
	validateNum:function(str)
	{
		if (str == null || str == "")
		{
			return true;//不验证为空的串
		}
		try 
		{
			var test = (eval('str >= 0 || str <= 0'));
			return test;
		}
		catch (e)
		{
			return false;
		}
		return true;
	}
});