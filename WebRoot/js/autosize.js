var t = document.documentElement.clientWidth; //在页面初始化加载的时候，事先取得当前页面的可见区域宽度，留备后用。

function doResize() {
    var ss = getPageSize();
    //将jqGrid窗口的宽度设置为ss.WinW-20，高度设置为ss.WinH-93
    //这里的20和93是真实宽高度的修正值，你可以自己去试一下找到最合适你的那个数值
    $("#queryList").jqGrid('setGridWidth', ss.WinW - 70).jqGrid('setGridHeight', ss.WinH - 150);
    $("#commonList").jqGrid('setGridWidth', ss.WinW - 70).jqGrid('setGridHeight', ss.WinH - 150);
}
//
//function getPageSize() {
//    var winW, winH;//当前窗口的有效可视宽度和高度
//
//    if (window.innerHeight) { //所有非IE浏览器
//        winW = window.innerWidth;
//        winH = $(window).height();
//    } else if (document.documentElement && document.documentElement.clientHeight) { //IE 6 Strict Mode
//        winW = document.documentElement.clientWidth;
//        winH = document.documentElement.clientHeight;
//    } else if (document.body) { //其他浏览器
//        winW = document.body.clientWidth;
//        winH = document.body.clientHeight;
//    }
//    return {
//        WinW: winW, //真正反馈的宽度
//        WinH: winH //真正反馈的高度
//    };
//};

function getPageSize() {
    var winW, winH;//当前窗口的有效可视宽度和高度

    if (document.documentElement && document.documentElement.clientHeight) { //IE 6 Strict Mode
        winW = document.documentElement.clientWidth;
        winH = document.documentElement.clientHeight;
    } else if (document.body) { //其他浏览器
        winW = document.body.clientWidth;
        winH = document.body.clientHeight;
    } else if (window.innerHeight) { //所有非IE浏览器
        winW = window.innerWidth;
        winH = $(window).height();
    }
    return {
        WinW: winW, //真正反馈的宽度
        WinH: winH //真正反馈的高度
    };
}

$(window).resize(function () {
    if (t != document.documentElement.clientWidth) { //还记得一开始初始化的时候就记录下来的那个t变量吗？
        t = document.documentElement.clientWidth; //重新给t变量赋值
        doResize(); //继续调整宽高度
    }
});