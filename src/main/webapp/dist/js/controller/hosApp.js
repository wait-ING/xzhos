var hosApp = angular.module('HosApp', ['ngRoute']);


// configure our routes
hosApp.config(['$routeProvider',function($routeProvider){
    $routeProvider
        .when('/home', {
            templateUrl : 'home.html',
            controller  : 'homeController'
        })
        .when('/login', {
            templateUrl : 'login.html',
            controller  : 'loginController'
        })
        .when('/permissionManager',{
            templateUrl:'permissionManager.html',
            controller:'permissionManagerController'
        })

        .otherwise({
            redirectTo:"/home"
        })

}]);