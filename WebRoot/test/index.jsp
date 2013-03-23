<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>talent validate</title>
		<style type="text/css">
<!--
    body {
        margin:0;
        padding:0;
        font-family: "arial";
		font-size: 12px;
}

img {
border: none;
}

/*- Menu Tabs 1--------------------------- */

    #tabs1 {
      float:left;
      width:100%;
          background:#F4F7FB;
      font-size:12px;
      line-height:normal;
          border-bottom:1px solid #BCD2E6;
      }
    #tabs1 ul {
          margin:0;
          padding:10px 10px 0 50px;
          list-style:none;
      }
    #tabs1 li {
      display:inline;
      margin:0;
      padding:0;
      }
    #tabs1 a {
      float:left;
      background:url("/img/tableft1.gif") no-repeat left top;
      margin:0;
      padding:0 0 0 4px;
      text-decoration:none;
      }
    #tabs1 a span {
      float:left;
      display:block;
      background:url("/img/tabright1.gif") no-repeat right top;
      padding:5px 15px 4px 6px;
      color:#627EB7;
      }
    /* Commented Backslash Hack hides rule from IE5-Mac \*/
    #tabs1 a span {float:none;}
    /* End IE5-Mac hack */
    #tabs a:hover span {
      color:#627EB7;
      }
    #tabs1 a:hover {
      background-position:0% -42px;
      }
    #tabs1 a:hover span {
      background-position:100% -42px;
      }

      #tabs1 #current a {
              background-position:0% -42px;
      }
      #tabs1 #current a span {
              background-position:100% -42px;
      }
-->
div.icon
{
	border:1px solid blue;
	text-align:center;
	width:120px;
	height:40px;
	margin:2px;
	cursor:hand;
	text-decoration:none;
}
div.icon a:hover
{
	border:1px solid red;
	background-color:#98FB98;
}

</style>
	</head>

	<body>

		<div id="tabs1">
			<ul>
				<!-- CSS Tabs -->
				<li title="必输">
					<a href="javascript:show('required')"><span>RequiredValidator</span>
					</a>
				</li>
				<li title="正则表达式">
					<a href="javascript:show('regex')"><span>RegexValidator</span>
					</a>
				</li>
				<li title="邮箱">
					<a href="javascript:show('email')"><span>EmailValidator</span>
					</a>
				</li>
				<li title="日期时间">
					<a href="javascript:show('datetime')"><span>DatetimeValidator</span>
					</a>
				</li>
				<li title="数字">
					<a href="javascript:show('num')"><span>NumValidator</span>
					</a>
				</li>
				<li title="整数">
					<a href="javascript:show('int')"><span>IntValidator</span>
					</a>
				</li>
				<li title="数字范围">
					<a href="javascript:show('numRange')"><span>NumRangeValidator</span>
					</a>
				</li>
				<li title="字符串比较">
					<a href="javascript:show('compare')"><span>CompareValidator</span>
					</a>
				</li>
				
				<li title="用alert进行信息提示">
					<a href="javascript:show('alert')"><span>用alert进行信息提示</span>
					</a>
				</li>
				<li title="根据表单验证">
					<a href="javascript:show('formFilter')"><span>根据表单验证</span>
					</a>
				</li>
				<li title="每次只提示一个信息">
					<a href="javascript:show('single')"><span>每次只提示一个信息</span>
					</a>
				</li>
				<li title="灵活取消某些验证">
					<a href="javascript:show('remove')"><span>灵活取消某些验证</span>
					</a>
				</li>
			</ul>
		</div>

		<div style="padding:1px;margin:1px;border:1px solid blue;width:100%">
			<iframe id="iframe_id" src=""
				style="padding:1px;margin:1px;border:1px solid blue;width:100%;height:450"></iframe>
		</div>


	</body>
	<script language="javascript">
		function show(file)
		{
			document.getElementById("iframe_id").src = file + ".jsp";
		}
	</script>
</html>
