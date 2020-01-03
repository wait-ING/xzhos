// $(function () {
//    $("#headerPager").load("header.html");
//    $("#sidebarPager").load("sidebar.html");
//
// });
/*
* -----------验证--------------
*/
/**
 * 判空
 */
function isNull(obj) {
    if (obj == null || obj == undefined || obj.trim() == "") {
        return true;
    }
    return false;
}

/**
 * 用户名格式 4-16位
 */
function validUserName(userName) {
    var pattern = /^[a-zA-Z0-9_-]{4,16}$/;
    if (pattern.test(userName.trim())) {
        return (true);
    } else {
        return (false);
    }
}
/**
 * 密码格式 6-20位
 */
function validPassword(password) {
    var pattern = /^[a-zA-Z0-9]{6,20}$/;
    if (pattern.test(password.trim())) {
        return (true);
    } else {
        return (false);
    }
}
/**
 * 参数长度验证
 *
 * @param obj
 * @param length
 * @returns {boolean}
 */
function validLength(obj, length) {
    if (obj.trim().length < length) {
        return true;
    }
    return false;
}


/*
* -------------Cookie--------------
* */
/**
* 写入cookie
*/
function setCookie(name, value) {
    var Days = 30;
    var exp = new Date();
    exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString() + ";path=/";

}
/**
 * 读取cookie
 */
function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    if (arr = document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;
}
/**
 * 检查cookie
 */
function checkCookie() {
    if (getCookie("token") == null) {
        alert("未登录！");
        window.location.href = "../../login.html";
    }
    else {
        // $('#tip').html("Hello SSM!<br>看到此页面证明你登陆成功，且cookie中已经有合法的用户令牌了！");
    }
}

/**
 * 错误信息提示
 */
function showErrorInfo(info) {
    $('.alert-danger').css("display", "block");
    $('.alert-danger').html(info);
}

function hindErrorInfo() {
    $('.alert-danger').css("display", "none");
}

/*
* -----------页面包含---------------
* */


/**
 * 返回码
 */
function checkResultCode(code) {
    if (code == 402) {
        window.location.href = "login.html";
    }
    if (code == 500) {
       alert("服务器出错");
       return false;
    }
    if (code==200){
        return true;
    }
}

/*
* -------模态框关闭----------
* */
function closeAllModal() {
    Custombox.modal.closeAll();
}