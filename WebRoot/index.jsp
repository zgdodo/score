<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>产品自动补全</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<script type="text/javascript" src="jquery/jquery.js"></script>
	<script type="text/javascript" src="jquery/jquery.autocomplete.js"></script>
	<link rel="Stylesheet" type="text/css" href="jquery/jquery.autocomplete.css" />
	<script type="text/javascript">
		var v_product_Store ;
		//var months = ['1', '2', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
		$().ready(function() {
			$("#productName").autocomplete("findStoreProdctListNameForJson.do", {  //当用户输入关键字的时候 ，通过 url的方式调用action的findStoreProdctListNameForJson方法
				minChars: 1,  //最小显示条数
				max: 12,  //最大显示条数
				autoFill: false,
				dataType : "json",  //指定数据类型的渲染方式
				extraParams: 
		        {   
		             productName: function() 
		              { 
		               return $("#productName").val();    //url的参数传递
		              }   
		           },

				 //进行对返回数据的格式处理
        			 parse: function(data) 
         			{
		             var rows = [];
		               for(var i=0; i<data.length; i++)
		           		 {	
			                 rows[rows.length] = {
			                   data:data[i],
			                   value:data[i],
			                  //result里面显示的是要返回到列表里面的值  
			                   result:data[i]
			                 };
		               }           
	               	return rows;
	           	},
				formatItem: function(item) {
					//没有特殊的要求,直接返回了
                  		return item;
				}
			});
		
		});
	</script>		
		
  </head>
  
  <body>
	  <div>
	  	 产品名: <input type="text" id="productName" />
	  </div>
  </body>
</html>
