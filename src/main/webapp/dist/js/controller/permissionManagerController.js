hosApp.controller('permissionManagerController', function($scope,$http,$rootScope,$timeout) {
    checkCookie();

    /*
    TODO
    * 保存新增角色
    * */
    $("#saveAddRoleBtn").click(function () {
       var roleName=$("#addRoleName").val();
        if (validLength(roleName,10)){//角色至多10字符
            var data={"roleName":roleName};
            $.ajax({
                type:"POST",
                dataType:"json",
                url:"subAdmin/saveRole",
                contentType:"application/json;charset=utf-8",
                data:JSON.stringify(data),
                beforeSend:function (result) {
                    result.setRequestHeader("token",getCookie("token"));
                },
                success:function (result) {

                },
                error:function () {
                    reset();
                    alert("操作失败");
                }

            })
        }
    });
    /*
    * 展示所有角色
    * */
    $("#jqGrid").jqGrid({
        loadBeforeSend:function (request) {
            //设置header值
            request.setRequestHeader("token", getCookie("token"));
        },
        //请求后台 JSON 数据的 URL
        url: 'subAdmin/listRoles',
        mtype:"post", //后台返回的数据格式
        datatype: "json", //接收数据后响应的类型
        colModel: [
            {
                label: 'id',
                name: 'id',
                index: 'id',
                width: 50,
                hidden: true,
                key: true
            },
            {
                label: '角色名',
                name: 'roleName',
                index: 'typeName',
                editable:true,//开启编辑模式
                edittype:"text",//编辑当前列的类型
                sortable: false,
                width: 80,
                resizable:false //不允许拖拽改变列宽
            },
            {
                label: '创建时间',
                name: 'createdTime',
                index: 'createdTime',
                sortable: false,
                width: 80
            },
            {
                label: '创建人',
                name: 'creator',
                index: 'creator',
                sortable: false,
                width: 80
            },
            {
                label: '修改时间',
                name: 'editedTime',
                index: 'editedTime',
                sortable: false,
                width: 80
            },
            {
                label: '修改人',
                name: 'editor',
                index: 'editor',
                sortable: false,
                width: 80
            }
        ],
        //表格高度，可自行调节
        height: 485,
        //默认一页显示多少条数据，可自行调节
        rowNum: 10,
        //翻页控制条中，每页显示记录数可选集合
        rowList: [10, 30, 50],
        //主题，这里选用的是 Bootstrap 主题
        styleUI: 'Bootstrap',
        //数据加载时显示的提示信息
        loadtext: '信息读取中...',
        //是否显示行号，默认值是 false，不显示
        rownumbers: true,
        //行号列的宽度
        rownumWidth: 35,
        //宽度是否自适应
        autowidth: true,
        //是否可以多选
        multiselect: true,
        //分页信息 DOM
        pager: "#jqGridPager",
        jsonReader: {
            root: "data.list",           //数据列表模型
            page: "data.currPage",       //数据页码
            total: "data.totalPage",     //数据总页码
            records: "data.totalCount"   //数据总记录数
        },
        // 向后台请求的参数
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },

        // 数据加载完成并且 DOM 创建完毕之后的回调函数
        gridComplete: function () {
            //隐藏 Grid 底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });



});

/**
 * 新增角色
 */
function addRole() {
    var addRoleModal = new Custombox.modal({
        content: {
            effect: 'fadein',
            target: '#addRoleModal'
        }
    });
    addRoleModal.open();
}



/*
 * 关闭模态框
 * */

function closeMyModal() {
    reset();
    closeAllModal();
}
/*
* 清空数据
* */
function reset() {
    $("#addRoleName").val('');
}

