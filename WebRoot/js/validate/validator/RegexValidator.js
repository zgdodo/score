var RegexValidator = Class.create();
RegexValidator.prototype = Object.extend(new BaseValidator(), {
	initialize:function()
	{
		this.regexInitialize();
	},
	regexInitialize:function()
	{
		this.baseInitialize();
		this.message = validateI18nMsgRegex;
	},
	set:function(regex, message)
	{
		this.regex = regex;
		this.messageParams[0] = message;
		return this;
	},
	validate:function(str)
	{
		return this.regex.test(str);
	}
});