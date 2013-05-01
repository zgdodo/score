<%--
  Created by IntelliJ IDEA.
  User: do
  Date: 13-3-2
  Time: 下午12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title></title>

    <link href="/style/jquery-ui-1.9.2.custom.min.css" rel="stylesheet"/>
    <link href="/style/ui.jqgrid.css" rel="stylesheet"/>
    <script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.9.2.custom.min.js"></script>
    <script type="text/javascript" src="/js/jquery.form.js"></script>
    <script src="/js/grid.locale-cn.js" type="text/javascript"></script>
    <script src="/js/jquery.jqGrid.min.js" type="text/javascript"></script>
    <script src="/js/autosize.js" type="text/javascript"></script>
</head>
<script>

    $(document).ready(function () {

        $("#tabs").tabs();

        $("#queryList").jqGrid({
            url: 'queryAction.do',
            datatype: "json",
            autowidth: false,
            shrinkToFit: true,
            colNames: ['考号', '学号', '姓名', '语文', '数学', '英语', '政治', '历史', '地理', '物理', '化学', '生物', '文综', '理综', '总分', '班级排名', '年级排名', '考试批次'],
            colModel: [
                {name: 'stuNumber', index: 'stuNumber', width: '90%',search:false},
                {name: 'exNumber', index: 'exNumber', width: '90%',search:false},
                {name: 'stuName', index: 'stuName', width: '80%',search:false},
                {name: 'chinese', index: 'chinese', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']}},
                {name: 'maths', index: 'maths', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']}},
                {name: 'english', index: 'english', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']}},
                {name: 'biology', index: 'biology', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']}},
                {name: 'geogrophy', index: 'geogrophy', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']}},
                {name: 'chemistry', index: 'chemistry', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']}},
                {name: 'politics', index: 'politics', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']}},
                {name: 'physics', index: 'physics', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']}},
                {name: 'history', index: 'history', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']}},
                {name: 'arts', index: 'arts', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']}},
                {name: 'science', index: 'science', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']}},
                {name: 'totalScore', index: 'totalScore', width: '60%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']}},
                {name: 'classRank', index: 'classRank', width: '65%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']}},
                {name: 'gradeRank', index: 'gradeRank', width: '65%',searchoptions:{sopt:['eq','ne','lt','le','gt','ge']}},
                {name: 'exDes', index: 'exDes',searchoptions:{sopt:['eq','bw','ew','cn']}}

            ],
            rowNum: 20,       //每页显示数
            rowList: [20, 30, 50],
            viewrecords: true,
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
                {del: false, add: false, edit: false},
                {}, {}, {}, {multipleSearch: true});
        //         ---------评价查询分割线-------------
        $("#commonList").jqGrid({
            url: 'commentAction.do',
            datatype: "json",
            autowidth: false,
            shrinkToFit: true,
            colNames: [ '学号', '近期表现', '老师评价', '评价时间'],
            colModel: [
                {name: 'stuNumber', index: 'stuNumber', width: '50%',search:false},
                {name: 'behaviour', index: 'behaviour', width: '100%', searchoptions: {sopt: ['eq', 'bw', 'ew', 'cn']}
                   },
                {name: 'evaluation', index: 'evaluation', width: '100%', searchoptions: {sopt: ['eq', 'bw', 'ew', 'cn']}
                   },
                {name: 'CTime', index: 'CTime', width: '50%', formatter: 'date', formatoptions: {srcformat: "Y-m-d", newformat: "Y-m-d"},
                    searchoptions: {sopt: ['eq', 'lt', 'le', 'gt','ge']}}

            ],
            rowNum: 20,       //每页显示数
            rowList: [20, 30, 50],
            viewrecords: true,
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
            pager: "#commPageGrid"
        });
        $("#commonList").jqGrid('navGrid', '#commPageGrid',
                {del: false, add: false, edit: false},{},{},{},
                {multipleSearch: true});


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
        <li><a href="#tabs-1">近期评语</a></li>
    </ul>
    <div id="tabs-1">
        <table id="commonList"></table>
        <div id="commPageGrid"></div>
    </div>
    <div id="tabs-2">

        <table id="queryList"></table>
        <div id="pageGrid"></div>

    </div>
</div>

</body>
</html>