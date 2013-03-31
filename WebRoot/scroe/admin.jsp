<%--
  Created by IntelliJ IDEA.
  User: do
  Date: 13-3-16
  Time: 下午7:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理页面</title>

    <link href="/style/jquery-ui-1.9.2.custom.min.css" rel="stylesheet">
    <script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.9.2.custom.min.js"></script>
    <script type="text/javascript" src="/js/jquery.form.js"></script>
    <script>

        $(document).ready(function () {
            $("#tabs").tabs();
            $("fileSub").button();
            $("#importForm").ajaxForm({
                url:"importExcel.do",
                beforeSubmit:check,
                success:function(data) {
                    alert("本次导入excel总条数："+data.allSto+",其中更新："+
                    data.updateStu+"条,录入："+data.saveStu+"条,错误："+
                    data.errStu+ "条");
                }
            });
            function check () {
                var filePath = $("input[name='attachment']").val();
                if (filePath == undefined || $.trim(filePath) == "") {
                    alert("请选择上传文件");
                    return false;
                }
                var extStart = filePath.lastIndexOf(".");
                var ext = filePath.substring(extStart, filePath.length).toUpperCase();
                if (ext != ".XLS" && ext != ".XLSX") {
                    alert("只能上传excel");
                    return false;

                }
                return true;
            }
        });
    </script>
    <style>
        body {
            font: 70.5% "Trebuchet MS", sans-serif;
            margin: 50px;
        }

        table {
            font: 90% "Trebuchet MS", sans-serif;
            margin: 50px;
        }
    </style>
</head>
<body>
<form method="post" id="importForm"  enctype="MULTIPART/FORM-DATA" >
    <div id="tabs">

        <ul>
            <li><a href="#tabs-1">导入 excel</a></li>
            <li><a href="#tabs-2">成绩查询</a></li>
        </ul>
        <div id="tabs-1">
            <table>
                <tr>
                    <td>
                        <input type="file" name="attachment" id="attachment"/>
                    </td>

                    <td>
                        <%--<input type="button" name="fileSub" id="fileSub" value="导入"/>--%>
                         <button id="fileSub">导入</button>
                    </td>

                </tr>

            </table>
        </div>
        <div id="tabs-2">
            loading.....
        </div>
    </div>
</form>
</body>
</html>