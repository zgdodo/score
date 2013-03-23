var RequiredValidator = Class.create();
RequiredValidator.prototype = Object.extend(new BaseValidator(), {
	initialize: function()
	{
		this.requiredInitialize();
	},
	requiredInitialize: function()
	{
		this.baseInitialize();
		this.message = validateI18nMsgRequired;
		this.spanNameOfStar = "validatespanNameOfStar";
		this.starElement = "<span>*</span>";
	},
	validate:function(str)
	{
		if (str != null)
		{
			return (_trim_(str) != "");
		}
	},
	/**
	 * 在字段后面加上星号
	 */
	doAfterAdd:function()
	{
		this.clearStar();//先清空星号
		this.addStar();  //再加星号
		return;
	},
	/**
	 * 当注销后做些事情,子类视情况实现该函数,如Required验证器,需要去掉后面的红星号
	 */
	doAfterRemove:function()
	{
		this.clearStar();    //先清空星号
		this.addStar();      //再加星号
		this.clearMessage(); //清空错误消息
		return;
	},
	/**
	 * 添加星号
	 */
	addStar:function()
	{
		for (var i = 0; i < this.fieldArray.length; i++)
		{
			var fieldObj = document.getElementsByName(this.fieldArray[i].name);
			if (fieldObj)
			{
				for (var j = 0; j < fieldObj.length; j++)
				{
					_insertAfter_(fieldObj[j], this.starElement);
					_next_(fieldObj[j], 0).name = this.spanNameOfStar;
					_addClassName_(_next_(fieldObj[j], 0), classNameOfValidateRequiredStar);
				}
			}
		}
	},
	/**
	 * 清空星号
	 */
	clearStar:function()
	{
		var spans = getByNameAndTagName(this.spanNameOfStar, "span");
		if (spans == null)
		{
			return;
		}
		
		for (var i = 0; i < spans.length; i++)
		{
			_removeClassName_(spans[i], classNameOfValidateRequiredStar);
			spans[i].innerHTML = "";
		}
	}
});