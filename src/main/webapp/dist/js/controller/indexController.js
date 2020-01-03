hosApp.controller('indexController', function($scope,$http,$rootScope,$timeout) {
    checkCookie();
    $http({
        method : 'POST',
        url : "menu/menuInit",
        headers: {'token':getCookie("token")},
    }).success(function(response){
        checkResultCode(response.resultCode);
        $rootScope.menuList=response.data;
        window.location.href = "#/permissionManager";
    }).error(function(response){

    });




});