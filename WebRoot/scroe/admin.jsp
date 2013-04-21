<%--
  Created by IntelliJ IDEA.
  User: do
  Date: 13-3-16
  Time: 下午7:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
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
    <script src="/js/autosize.js" type="text/javascript"></script>
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
            $("#importCommon").ajaxForm({
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
                autowidth: false,
                shrinkToFit: true,
                colNames: ['考号', '学号', '姓名', '语文', '数学', '英语', '政治', '历史', '地理', '物理', '化学', '生物', '文综', '理综', '总分', '班级排名', '年级排名', '考试批次'],
                colModel: [
                    {name: 'stuNumber', index: 'stuNumber', width: '90%',searchoptions:{sopt:['eq','bw','ew','cn']},
                        editable:true,editrules:{required:true,number:true}},
                    {name: 'exNumber', index: 'exNumber', width: '90%',searchoptions:{sopt:['eq','bw','ew','cn']},
                        editable:true,editrules:{required:true,number:true}},
                    {name: 'stuName', index: 'stuName', width: '80%',searchoptions:{sopt:['eq','bw','ew','cn']}
                        ,editable:true},
                    {name: 'chinese', index: 'chinese', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']},
                        editable:true,editrules:{required:true,number:true,minValue:0,maxValue:150}},
                    {name: 'maths', index: 'maths', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']},
                        editable:true,editrules:{required:true,number:true,minValue:0,maxValue:150}},
                    {name: 'english', index: 'english', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']},
                        editable:true,editrules:{required:true,number:true,minValue:0,maxValue:150}},
                    {name: 'biology', index: 'biology', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']},
                        editable:true,editrules:{required:true,number:true,minValue:0,maxValue:100}},
                    {name: 'geogrophy', index: 'geogrophy', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']},
                        editable:true,editrules:{required:true,number:true,minValue:0,maxValue:100}},
                    {name: 'chemistry', index: 'chemistry', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']},
                        editable:true,editrules:{required:true,number:true,minValue:0,maxValue:100}},
                    {name: 'politics', index: 'politics', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']},
                        editable:true,editrules:{required:true,number:true,minValue:0,maxValue:100}},
                    {name: 'physics', index: 'physics', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']},
                        editable:true,editrules:{required:true,number:true,minValue:0,maxValue:100}},
                    {name: 'history', index: 'history', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']},
                        editable:true,editrules:{required:true,number:true,minValue:0,maxValue:100}},
                    {name: 'arts', index: 'arts', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']},
                        editable:true,editrules:{required:true,number:true,minValue:0,maxValue:100}},
                    {name: 'science', index: 'science', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']},
                        editable:true,editrules:{required:true,number:true,minValue:0,maxValue:100}},
                    {name: 'totalScore', index: 'totalScore', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']},
                        editable:true,editrules:{required:true,number:true,minValue:0}},
                    {name: 'classRank', index: 'classRank', width: '65%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']},
                        editable:true,editrules:{required:true,number:true,minValue:0}},
                    {name: 'gradeRank', index: 'gradeRank', width: '65%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']},
                        editable:true,editrules:{required:true,number:true,minValue:0}},
                    {name: 'exDes', index: 'exDes',searchoptions:{sopt:['eq','bw','ew','cn']},editable:true}

                ],
                rowNum: 20,       //每页显示数
                rowList: [20, 30, 50],
                viewrecords: true,
                editurl: 'operationAction.do',
                jsonReader: {
                    root: "dataRows",                // 数据行（默认为：rows）
                    page: "curPage",            // 当前页(服务器端返回)
                    total: "totalPages",    // 总页数
                    records: "totalRecords",    // 总记录数
                    id: "id",
                    repeatitems: false                 // 设置成false，在后台设置值的时候，可以乱序。且并非每个值都得设
                },
                prmNames: {
                    rows: "page.pageSize",       //每页显示数理论上对应rowNum
                    page: "curPage",      //当前页（客户端提交）
                    sort: "page.orderBy",
                    order: "page.order",
                    search: "search"
                },

                pager: "#pageGrid"

            });

            $("#queryList").jqGrid('navGrid', '#pageGrid',
                    {del: true, add: false, edit: true},
                    {}, {}, {}, {multipleSearch: true});


            doResize()
        });
    </script>
    <style>
        body {
            font: 70.5% "Trebuchet MS", sans-serif;
        }

        table {
            font: 99% "Trebuchet MS", sans-serif;
        }
    </style>
</head>
<body>
<div id="tabs">


    <ul>
        <li><a href="#tabs-2">成绩查询</a></li>
        <li><a href="#tabs-1">导入成绩</a></li>
        <li><a href="#tabs-3">导入评语</a></li>
    </ul>
    <div id="tabs-1">
        <form method="post" id="importForm" enctype="MULTIPART/FORM-DATA">
            <table>
                <tr>
                    <td>
                        <input type="file" name="attachment" id="attachment"/>
                    </td>

                    <td>
                        <input type="submit" name="fileSub" value="导入"/>
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
    <div id="tabs-3">
        <form method="post" id="importCommon" enctype="MULTIPART/FORM-DATA">
            <table>
                <tr>
                    <td>
                        <input type="file" name="attachment2" id="attachment2"/>
                    </td>

                    <td>
                        <input type="submit" name="fileSub2" value="导入"/>
                        <%--<button id="fileSub"></button>--%>
                    </td>

                </tr>

            </table>

        </form>
    </div>
</div>

</body>
</html>