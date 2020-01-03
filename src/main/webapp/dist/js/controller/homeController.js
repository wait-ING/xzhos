hosApp.controller('homeController', function($scope,$http,$rootScope,$timeout){
    checkCookie();

});

/*
 //后台请求当前导航的下一级导航
function getMenu(parentMenuId,obj) {
    // alert(this);

    // var indexLi = document.getElementById("showDiv").getElementsByTagName("li");
    // var indexLia = document.getElementById("showDiv").getElementsByTagName("li")[indexId];
    var data={"parentId": parentMenuId};
    alert($(obj).html()+"出啊惹怒的this")
    $.ajax(
        {
            url: "menu/getMenu",
            data: JSON.stringify(data),
            type: "post",
            dataType: "json",
            contentType:"application/json; charset=utf-8",
            beforeSend: function (request) {
                //设置header值
                request.setRequestHeader("token", getCookie("token"));
            },
            success: function (result) {
                checkResultCode(result.resultCode);
                var menuList=result.data;
                if (menuList.length==0){//没有下一级菜单，跳转对应控制界面
                    alert("无下一级目录")
                    return ;
                }
                //如果有下一级别则展示
                for(var i=0;i<menuList.length;i++){
                    var menu = menuList[i];
                    $(obj).parent().addClass('has-treeview');
                    $(obj).children("p").append(
                        "<i class='right fas fa-angle-left'></i>"
                    );
                    $(obj).parent().append(
                        "<ul class='nav nav-treeview'>" +
                            "<li class='nav-item'>" +
                                "<a href='javascript:;' onclick='getMenu(" +menu.id +"," +i+")' class='nav-link'>" +
                                    "<i class='fas fa-circle nav-icon' ></i>" +
                                    "<p>"+menu.name+ "</p>" +
                                "</a>" +
                            "</li>" +
                        "</ul> ");
                }
            }
        });
}
*/



// $("#jqGrid").jqGrid({
//     loadBeforeSend:function (request) {
//         //设置header值
//         request.setRequestHeader("token", getCookie("token"));
//
//     },
//     //请求后台 JSON 数据的 URL
//     url: 'user/home',
//     mtype:"post",
//     //后台返回的数据格式
//     datatype: "json",
//     //列表信息，包括表头、宽度、是否显示、渲染参数等属性
//     // {label: 'id', name: 'id', index: 'id', width: 50, hidden: true, key: true},
//     colModel: [
//         {label: '登录名', name: 'hosName', index: 'hosName', sortable: false, width: 80},
//         {label: '添加时间', name: 'createTime', index: 'createTime', sortable: false, width: 80}
//     ],
//     //表格高度，可自行调节
//     height: 485,
//     //默认一页显示多少条数据，可自行调节
//     rowNum: 10,
//     //翻页控制条中，每页显示记录数可选集合
//     rowList: [10, 30, 50],
//     //主题，这里选用的是 Bootstrap 主题
//     styleUI: 'Bootstrap',
//     //数据加载时显示的提示信息
//     loadtext: '信息读取中...',
//     //是否显示行号，默认值是 false，不显示
//     rownumbers: true,
//     //行号列的宽度
//     rownumWidth: 35,
//     //宽度是否自适应
//     autowidth: true,
//     //是否可以多选
//     multiselect: true,
//     //分页信息 DOM
//     pager: "#jqGridPager",
//     jsonReader: {
//         root: "data.list",           //数据列表模型
//         page: "data.currPage",       //数据页码
//         total: "data.totalPage",     //数据总页码
//         records: "data.totalCount"   //数据总记录数
//     },
//     // 向后台请求的参数
//     prmNames: {
//         page: "page",
//         rows: "limit",
//         order: "order"
//     },
//
//     // 数据加载完成并且 DOM 创建完毕之后的回调函数
//     gridComplete: function () {
//         //隐藏 Grid 底部滚动条
//         $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
//     }
// });



// $.ajax({
//     url: "menu/menuInit",
//     beforeSend: function (request) {
//         //设置header值
//         request.setRequestHeader("token", getCookie("token"));
//     },
//     success: function (result) {
//         $scope.menuList=result.data;
//         $scope.name="gaja";
//         console.log(result.data)
//     }
// });



/*
 $.ajax({
 url:"menu/menuInit",
 beforeSend: function (request) {
 //设置header值
 request.setRequestHeader("token", getCookie("token"));
 },
 success:function (result) {
 checkResultCode(result.resultCode);
 var menuList=result.data;
 for(var i=0;i<menuList.length;i++){
 var menu = menuList[i];
 // onclick='getMenu("+menu.id +"," +this+")'
 $("#showDiv").append(
 "<li class='nav-item'>" +
 "<a href='javascript:;'  onclick='getMenu("+menu.id +"," +this+")' class='nav-link'>" +
 "<p>"+menu.name+ "</p>" +
 "</a>" +
 "</li>");
 };
 // <i class='right fas fa-angle-left'></i>
 }
 });

 */