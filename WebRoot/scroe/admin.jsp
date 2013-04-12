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
    <script src="/js/scroe.js" type="text/javascript"></script>
    <script>
        var t = document.documentElement.clientWidth; //在页面初始化加载的时候，事先取得当前页面的可见区域宽度，留备后用。
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
                autowidth: false,
                shrinkToFit: true,
                colNames: ['考号', '学号', '姓名', '语文', '数学', '英语', '政治', '历史', '地理', '物理', '化学', '生物', '文综', '理综', '总分', '班级排名', '年级排名', '考试批次'],
                colModel: [
                    {name: 'stuNumber', index: 'stuNumber'},
                    {name: 'exNumber', index: 'exNumber'},
                    {name: 'stuName', index: 'stuName'},
                    {name: 'Chinese', index: 'chinese'},
                    {name: 'maths', index: 'maths' },
                    {name: 'English', index: 'english'},
                    {name: 'biology', index: 'biology'},
                    {name: 'geogrophy', index: 'geogrophy'},
                    {name: 'chemistry', index: 'chemistry'},
                    {name: 'politics', index: 'politics'},
                    {name: 'physics', index: 'physics'},
                    {name: 'history', index: 'history'},
                    {name: 'arts', index: 'arts'},
                    {name: 'science', index: 'science'},
                    {name: 'totalScore', index: 'totalScore'},
                    {name: 'classRank', index: 'classRank'},
                    {name: 'gradeRank', index: 'gradeRank'},
                    {name: 'exDes', index: 'exDes'}

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

                pager: "#pageGrid"

            });

            $("#queryList").jqGrid('navGrid', '#pageGrid',
                    {del: false, add: false, edit: false},
                    {}, {}, {}, {multipleSearch: true});


            doResize()
        });
        //            自适应宽度
        //每次窗口大小调整的时候都会自动执行此方法，配合doResize()方法可以动态调整jqGrid的高和宽
        $(window).resize(function () {
            if (t != document.documentElement.clientWidth) { //还记得一开始初始化的时候就记录下来的那个t变量吗？
                t = document.documentElement.clientWidth; //重新给t变量赋值
                doResize(); //继续调整宽高度
            }
        });

        function doResize() {
            var ss = getPageSize();
            //将jqGrid窗口的宽度设置为ss.WinW-20，高度设置为ss.WinH-93
            //这里的20和93是真实宽高度的修正值，你可以自己去试一下找到最合适你的那个数值
            $("#queryList").jqGrid('setGridWidth', ss.WinW - 70)
        }

        function getPageSize() {
            var winW, winH;//当前窗口的有效可视宽度和高度

            if (window.innerHeight) { //所有非IE浏览器
                winW = window.innerWidth;
                winH = $(window).height();
            } else if (document.documentElement && document.documentElement.clientHeight) { //IE 6 Strict Mode
                winW = document.documentElement.clientWidth;
                winH = document.documentElement.clientHeight;
            } else if (document.body) { //其他浏览器
                winW = document.body.clientWidth;
                winH = document.body.clientHeight;
            }
            return {
                WinW: winW, //真正反馈的宽度
                WinH: winH //真正反馈的高度
            };
        }
        ;

    </script>
    <style>
        body {
            font: 70.5% "Trebuchet MS", sans-serif;
        }

        table {
            font: 90% "Trebuchet MS", sans-serif;
        }
    </style>
</head>
<body>
<div id="tabs">


    <ul>
        <li><a href="#tabs-2">成绩查询</a></li>
        <li><a href="#tabs-1">导入 excel</a></li>
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
</div>

</body>
</html>