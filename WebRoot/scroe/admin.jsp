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

    <link href="/style/jquery-ui-1.9.2.custom.min.css" rel="stylesheet"/>
    <link href="/style/ui.jqgrid.css" rel="stylesheet"/>
    <script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.9.2.custom.min.js"></script>
    <script type="text/javascript" src="/js/jquery.form.js"></script>
    <script src="/js/grid.locale-cn.js" type="text/javascript"></script>
    <script src="/js/jquery.jqGrid.min.js" type="text/javascript"></script>
    <script src="/js/scroe.js" type="text/javascript"></script>
    <script>

        $(document).ready(function () {
            $("#tabs").tabs();
            $("#importForm").ajaxForm({
                url: "importExcel.do",
                beforeSubmit: check,
                success: function (data) {
                    alert("本次导入excel总条数：" + data.allSto + ",其中更新：" +
                            data.updateStu + "条,录入：" + data.saveStu + "条,错误：" +
                            data.errStu + "条");
                }
            });
            function check() {
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

            $("#queryList").jqGrid({
                url: 'queryAction.do',
                datatype: "json",
                height: 255,
                colNames: ['考号', '学号', '姓名', '语文', '数学', '英语', '政治', '历史', '地理', '物理', '化学', '生物', '文综', '理综', '总分', '班级排名', '年级排名', '考试批次'],
                colModel: [
                    {name: 'stuNumber', index: 'stuNumber', width:'100'},
                    {name: 'exNumber', index: 'exNumber', width:'100'},
                    {name: 'stuName', index: 'stuName', width:'100'},
                    {name: 'Chinese', index: 'chinese', width:'50'},
                    {name: 'maths', index: 'maths' ,width:'50'},
                    {name: 'English', index: 'english',width:'50'},
                    {name: 'biology', index: 'biology',width:'50'},
                    {name: 'geogrophy', index: 'geogrophy',width:'50'},
                    {name: 'chemistry', index: 'chemistry',width:'50'},
                    {name: 'politics', index: 'politics',width:'50'},
                    {name: 'physics', index: 'physics',width:'50'},
                    {name: 'history', index: 'history',width:'50'},
                    {name: 'arts', index: 'arts',width:'50'},
                    {name: 'science', index: 'science',width:'50'},
                    {name: 'totalScore', index: 'totalScore',width:'50'},
                    {name: 'classRank', index: 'classRank',width:'50'},
                    {name: 'gradeRank', index: 'gradeRank',width:'50'},
                    {name: 'exDes', index: 'exDes',width:'150'}

                ],
                rowNum: 10,
                rowList: [20, 30, 50],
                jsonReader: {
                    root: "dataRows",                // 数据行（默认为：rows）
                    page: "curPage",            // 当前页
                    total: "totalPages",    // 总页数
                    records: "totalRecords",    // 总记录数
                    id: "id",
                    repeatitems: false                 // 设置成false，在后台设置值的时候，可以乱序。且并非每个值都得设
                },
                prmNames: {
                    rows: "page.pageSize",
                    page: "page.curPageNo",
                    sort: "page.orderBy",
                    order: "page.order"
                },
                pager: "#pageGrid",
                caption: "学生成绩列表"
            });
            $("#queryList").jqGrid('navGrid', '#pageGrid',
                    {del: false, add: false, edit: false},
                    {}, {}, {}, {multipleSearch: true});
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
<div id="tabs">


    <ul>
        <li><a href="#tabs-1">导入 excel</a></li>
        <li><a href="#tabs-2">成绩查询</a></li>
    </ul>
    <div id="tabs-1">
        <form method="post" id="importForm" enctype="MULTIPART/FORM-DATA">
            <table>
                <tr>
                    <td>
                        <input type="file" name="attachment" id="attachment"/>
                    </td>

                    <td>
                            <input type="submit" name="fileSub" value="导入" />
                        <%--<button id="fileSub"></button>--%>
                    </td>

                </tr>

            </table>

        </form>
    </div>
    <div id="tabs-2">

        <table id="queryList"></table>
        <div id="pageGrid"></div>

    </div>
</div>

</body>
</html>