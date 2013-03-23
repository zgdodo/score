var Field = Class.create();
Field.prototype = {
	initialize:function(label, name)
	{
		this.label = label;
		this.name = name;
	},
	add:function()
	{
		if (arguments)
		{
			for (var i = 0; i < arguments.length; i++)
			{
				arguments[i].add(this);
			}
		}
	},
	remove:function()
	{
		if (arguments)
		{
			for (var i = 0; i < arguments.length; i++)
			{
				arguments[i].remove(this);
			}
		}
	}
};