/**
 * @author Tanyaowu
 * @version 1.0
 * @date 2008-07-25
 */
var BaseValidator = Class.create();
BaseValidator.prototype=
{
    initialize:function()
    {
        this.baseInitialize();
    },
    baseInitialize:function()
    {
        this.fieldArray = new Array();
        this.message = "";
        this.messageParams = new Array();
        this.isInFactory = false;//本验证器是否已经在验证器工厂中了.false:不在工厂中;true:已在工厂中.
    },
    /**子类实现这个方法,用于验证串
     * @param: str 需要被验证的串
     * @return: true:验证通过; false:验证未通过
     */
    validate:function(str)
    {
        return true;
    },
    /**当添加后做些事情,子类视情况实现该函数,如Required验证器,需要在字段后面加上红色的星号
     */
    doAfterAdd:function()
    {
        return;
    },
    /**当移除后做些事情,子类视情况实现该函数,如Required验证器,需要去掉后面的红星号
     */
    doAfterRemove:function()
    {
        this.clearMessage();
        return;
    },
    validateAll:function()
    {
        return this.validateByFilter(new DefaultFilter(null));
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
                    if ( (!filter.filter(elements[j])) || (this.validate(elements[j].value)) )
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
    /**只验证formNames指定的form
     * @param formName 表单名字
     */
    validateForm:function(formNames)
    {
    	return this.validateByFilter(new FormFilter(formNames));
    },
    /** 移除字段
     * 用法:xx.remove("name1", "name2", "name3"...);
     */
    remove:function()
    {
        for (var i = 0; i < arguments.length; i++)
        {
            for (var j = 0; j < this.fieldArray.length; j++)
            {
                if (this.fieldArray[j].name == arguments[i])
                {
                    this.fieldArray[j].name = '';
                }
            }
        }
        this.doAfterRemove();
        return this;
    },
    /**移除所有字段
     * 用法:xxValidator.removeAll();
     */
    removeAll: function()
    {
        for (var j = 0; j < this.fieldArray.length; j++)
        {
            this.fieldArray[j].name = '';
        }
        this.doAfterRemove();
        return this;
    },
    /**将要验证的字段加到验证器中
     * 用法:xx.add("name1", "name2", "name3"...);
     */
    add:function()
    {
        var startIndex = this.fieldArray.length;
        for (var i = 0; i < arguments.length; i++)
        {
            if (this.checkUnique(arguments[i]))
            {
                this.fieldArray[i + startIndex] = new Field("", arguments[i]);
            }
        }
        this.doAfterAdd();
        
        if (!this.isInFactory)//必要时添加验证器到工厂中
        {
        	validatorFactory.add(this);
        	this.isInFactory = true;
        }
        return this;
    },
    /**检查字段的唯一性
     * @return true: 表示已注册的字段中不存在相同name的,此时可以往验证器中加此name的字段; 
     *         false:与true相反
     */
    checkUnique:function(name)
    {
        for (var i = 0; i < this.fieldArray.length; i++)
        {
        	if (this.fieldArray[i].name == name)
            {
                return false;
            }
        }
        return true;
    },
    /**处理没有验证通过的对象,例如对这个对象进行选中,将焦点转到该对象,修改该对象的样式等
     */
    processInvalid:function(element, field)
    {
       	var invalidProcessor = new InvalidProcessorFactory().create(element, field, this);
        invalidProcessor.process();
    },
    /**获取提示给用户的信息
     * @param label
     */
    getMessage:function(label)
    {
        var retMessage = this.message.replace("{0}", label);
        for (var i = 1; i <= this.messageParams.length; i++)
        {
            var paraIndex = "{" + i + "}";    //{n}
            retMessage = retMessage.replace(paraIndex, this.messageParams[i - 1]);
        }
        return retMessage;
    },
    /** 清空页面上的提示信息
     */
    clearMessage:function()
    {
        var spans = getByNameAndTagName(validateSpanNameOfErrorMsg, "span");
        if (spans == null)
        {
            return;
        }
        for (var i = 0; i < spans.length; i++)
        {
        	_removeClassName_(_previous_(spans[i], 0), classNameOfValidateErrorInput);
        	_remove_(spans[i]);
        }
    }
};