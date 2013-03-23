var DatetimeValidator = Class.create();
DatetimeValidator.prototype = Object.extend(new BaseValidator(), {

    initialize:function()
    {
        this.datetimeInitialize();
    },
    datetimeInitialize:function()
    {
        this.baseInitialize();
        this.message = validateI18nMsgDatetime;
    },
    set:function(pattern)
    {
    	this.pattern = pattern;
    	this.messageParams[0] = pattern;
    	return this;
    },
    /**
     * 说明:日期的验证代码是直接摘自validation-framework.js,略作修改,非本人所写
     */
    validate:function(value)
    {
        if (value == null || value == "")
        {
           return true;//不验证为空的串
        }
        
        var datePattern = this.pattern;//params[0];
        var MONTH = "mm";
        var DAY = "dd";
        var YEAR = "yyyy";
        var orderMonth = datePattern.indexOf(MONTH);
        var orderDay = datePattern.indexOf(DAY);
        var orderYear = datePattern.indexOf(YEAR);
        var bValid = true;
        var dateRegexp = null;
        
        if ((orderDay < orderYear && orderDay > orderMonth)) {
            var iDelim1 = orderMonth + MONTH.length;
               var iDelim2 = orderDay + DAY.length;
               var delim1 = datePattern.substring(iDelim1, iDelim1 + 1);
               var delim2 = datePattern.substring(iDelim2, iDelim2 + 1);
               if (iDelim1 == orderDay && iDelim2 == orderYear) {
                dateRegexp = new RegExp("^(\\d{2})(\\d{2})(\\d{4})$");
               } else if (iDelim1 == orderDay) {
                dateRegexp = new RegExp("^(\\d{2})(\\d{2})[" + delim2 + "](\\d{4})$");
               } else if (iDelim2 == orderYear) {
                dateRegexp = new RegExp("^(\\d{2})[" + delim1 + "](\\d{2})(\\d{4})$");
               } else {
                dateRegexp = new RegExp("^(\\d{2})[" + delim1 + "](\\d{2})[" + delim2 + "](\\d{4})$");
               }
        
               var matched = dateRegexp.exec(value);
               if(matched != null) {
                if (!this.isValidDate(matched[2], matched[1], matched[3])) {
                       bValid =  false;
                }
               } else {
                   bValid =  false;
               }
           } else if ((orderMonth < orderYear && orderMonth > orderDay)) { 
            var iDelim1 = orderDay + DAY.length;
               var iDelim2 = orderMonth + MONTH.length;
               var delim1 = datePattern.substring(iDelim1, iDelim1 + 1);
               var delim2 = datePattern.substring(iDelim2, iDelim2 + 1);
               if (iDelim1 == orderMonth && iDelim2 == orderYear) {
                dateRegexp = new RegExp("^(\\d{2})(\\d{2})(\\d{4})$");
               } else if (iDelim1 == orderMonth) {
                dateRegexp = new RegExp("^(\\d{2})(\\d{2})[" + delim2 + "](\\d{4})$");
               } else if (iDelim2 == orderYear) {
                dateRegexp = new RegExp("^(\\d{2})[" + delim1 + "](\\d{2})(\\d{4})$");
               } else {
                dateRegexp = new RegExp("^(\\d{2})[" + delim1 + "](\\d{2})[" + delim2 + "](\\d{4})$");
               }
               var matched = dateRegexp.exec(value);
            if(matched != null) {
                if (!this.isValidDate(matched[1], matched[2], matched[3])) {
                    bValid = false;
                   }
               } else {
                bValid = false;
               }
           } else if ((orderMonth > orderYear && orderMonth < orderDay)) {
            var iDelim1 = orderYear + YEAR.length;
               var iDelim2 = orderMonth + MONTH.length;
               var delim1 = datePattern.substring(iDelim1, iDelim1 + 1);
        
               var delim2 = datePattern.substring(iDelim2, iDelim2 + 1);
               if (iDelim1 == orderMonth && iDelim2 == orderDay) {
                dateRegexp = new RegExp("^(\\d{4})(\\d{2})(\\d{2})$");
               } else if (iDelim1 == orderMonth) {
                dateRegexp = new RegExp("^(\\d{4})(\\d{2})[" + delim2 + "](\\d{2})$");
               } else if (iDelim2 == orderDay) {
                dateRegexp = new RegExp("^(\\d{4})[" + delim1 + "](\\d{2})(\\d{2})$");
               } else {
                dateRegexp = new RegExp("^(\\d{4})[" + delim1 + "](\\d{2})[" + delim2 + "](\\d{2})$");
               }
            var matched = dateRegexp.exec(value);
               if(matched != null) {
                if (!this.isValidDate(matched[3], matched[2], matched[1])) {
                       bValid =  false;
                   }
               } else {
                   bValid =  false;
               }
           } else {
               bValid =  false;
           }
        return bValid;
    },
    isValidDate:function(day, month, year)
    {
		if (month < 1 || month > 12) 
		{
			return false;
		}
		if (day < 1 || day > 31)
		{
			return false;
		}
		if ((month == 4 || month == 6 || month == 9 || month == 11) &&(day == 31))
		{
			return false;
		}
		if (month == 2) 
		{
			var leap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
			if (day>29 || (day == 29 && !leap))
			{
				return false;
			} 
	    }
		return true;
	}
});