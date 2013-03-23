var NumRangeValidator = Class.create();
NumRangeValidator.prototype = Object.extend(new NumValidator(), {
	initialize:function()
	{
		this.baseInitialize();
		this.message = validateI18nMsgNumRange;
	},
	/**
	 * 设置最小值,"--"表示无穷小
	 */
	setMin:function(min)
	{
		this.min = min;
		if (min == '--')//无穷小
		{
			if (this.max == "++")
			{
				this.message = validateI18nMsgNumRangeNum;
			}
			else
			{
				this.message = validateI18nMsgNumRangeMin;
				this.messageParams[0] = this.max;
			}
			
		}else
		{
			this.messageParams[0] = min;
		}
	},
	/**
	 * 设置最大值,"++"表示无穷大
	 */
	setMax:function(max)
	{
		this.max = max;
		if (max == '++')
		{
			if (this.min == "--")
			{
				this.message = validateI18nMsgNumRangeNum;
			}
			else
			{
				this.message = validateI18nMsgNumRangeMax;
				this.messageParams[0] = this.min;
			}
		}
		else
		{
			if (this.min == "--")
			{
				this.messageParams[0] = max;
			}
			else
			{
				this.messageParams[1] = max;
			}
			
		}
	},
	set:function(min, max)
	{
		this.setMin(min);
		this.setMax(max);
		return this;
	},
	validate:function(str)
	{
		if (str == null || str == "")
		{
			return true;//不验证为空的串
		}
		if (!this.validateNum(str))//必须为数字,否则验证不通过
		{
			return false;
		}
		try 
		{
			if (this.max == "++" && this.min == "--")
			{
				return true;
			}
			
			
			if (this.max == "++")
			{
				if (eval(str) < eval(this.min))
				{
					return false;
				}else 
				{
					return true;
				}
			}
			
			if (this.min == "--")
			{
				if (eval(str) > eval(this.max))
				{
					return false;
				}else 
				{
					return true;
				}
			}
			
			if (eval(str) > eval(this.max) || eval(str) < eval(this.min))
			{
				return false;
			}
			return true;
		}
		catch (e)
		{
			return false;
		}
	}
});