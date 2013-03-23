var DefaultFilter = Class.create();
DefaultFilter.prototype = 
{
	initialize:function(params)
	{
		this.defaultInitialize(params);
	},
	defaultInitialize:function(params)
	{
		this.params = params;
	},
	/**
	 * @return true:表示需要验证,false:表示被过滤了,不需要验证.
	 */
	filter:function(element)
	{
		return true;//默认都需要验证
	}
};