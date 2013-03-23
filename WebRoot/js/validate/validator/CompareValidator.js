var CompareValidator = Class.create();
CompareValidator.prototype = Object.extend(new BaseValidator(), {
	initialize:function()
	{
		this.compareInitialize();
	},
	compareInitialize:function()
	{
		this.baseInitialize();
		
	},
	/**
	 * @param compareType 比较类型 'n':数字比较; 'v':字符串比较
	 * @param operator 比较符,可以为'<','<=','==','!=','>','>='
	 * @param field 被比较的字段
	 * 举例:
	 * var field1 = new Field("用户名", "loginName");
	 * new CompareValidator().set('n','>',field1);//要求添加此验证器的字段必须大于field1的值
	 */
	set:function(compareType, operator, field)
	{
		this.compareType = compareType;
		this.operator = operator;
		this.comparedField = field;
		
		this.messageParams[0] = validateOperatorLabelMap[this.operator];
		this.messageParams[1] = field.label;
		
		if (compareType == 'n')
		{
			this.message = validateI18nNumCompare;
		}
		else if (compareType == 'v')
		{
			this.message = validateI18nStringCompare;
		}
		else 
		{
			alert("验证框架使用错误:CompareValidator的比较类型不支持'" + compareType + "'");
		}
		return this;
	},
	validateByFilter:function(filter)
    {
        var ret = true;
        for (var i = 0; i < this.fieldArray.length; i++)
        {
            var elements = document.getElementsByName(this.fieldArray[i].name);
            if (elements)
            {
                for (var j = 0; j < elements.length; j++)
                {
                    /**不需要验证或者验证通过则继续下一个元素的处理*/
                    if ( (!filter.filter(elements[j])) || (this.validate(elements[j].value, j)) )
                    {
                        continue;
                    }
                    else
                    {
                        this.processInvalid(elements[j], this.fieldArray[i]);
                        ret = false;
                        if (!validateIsDisplayAllError)
                        {
                            return false;
                        }
                    }
                }
            }
        }
        return ret;
    },
	validate:function(str, index)
	{
		if (str == null || str == "")
		{
			return true;
		}
		var elements = document.getElementsByName(this.comparedField.name);
		var comparedValue = (elements[index]) ? elements[index].value : elements[0].value;//"";//elements[index].value;

		if (comparedValue == null || comparedValue == "")
		{
			return true;
		}
		this.messageParams[2] = comparedValue;
		var s = null;
		if (this.compareType == "n")//是数字比较
		{
			var numV = new NumValidator();
			if ( (!numV.validate(str)) || (!numV.validate(comparedValue)) )//不是数字则验证不通过
			{
				return false;
			}
			
			s = str + this.operator + comparedValue;
		}
		else if (this.compareType == "v")//是字符串比较
		{
			s = "\"" + str + "\"" + this.operator + "\"" + comparedValue + "\"";
		}
		return eval(s) == true;
	}
});