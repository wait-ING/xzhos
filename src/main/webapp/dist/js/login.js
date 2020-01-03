$(function () {


});
function login() {
    var userName=$("#userName").val();
    var password=$("#password").val();
    if (isNull(userName)||isNull(password)){
        showErrorInfo("用户名、密码为空");
        return;
    }
    if (!validUserName(userName)){
        showErrorInfo("用户名格式错误");
        return;
    }
    if (!validUserName(password)){
        showErrorInfo("密码格式错误");
        return;
    }
    var data = {"loginAccount": userName, "password": password}
    $.ajax({
        type:'POST',
        dataType:"json",
        url:"user/login",
        contentType:"application/json; charset=utf-8",
        data: JSON.stringify(data),
        success:function (result) {
           if(result.resultCode==500){
               showErrorInfo(result.message)
                return ;
           }
           if (result.resultCode==200){
               hindErrorInfo();
               alert("登录成功");
               setCookie("token",result.data.token);
               window.location.href = "/";
           }
        },error:function () {
            showErrorInfo("接口异常，请联系管理员");
            return ;
        }

    })

}

