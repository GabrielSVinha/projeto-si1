var app = angular.module('ad-extreme', ['ui.router', 'ngMessages'])
    .config(['$locationProvider', '$stateProvider', function($locationProvider, $stateProvider) {
        $locationProvider.html5Mode(true);

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: '/views/home.html',
                controller: 'HomeController',
                controllerAs: 'home'
            })
            .state('register', {
                url: '/cadastrar-se',
                templateUrl: '/views/register.html',
                controller: 'RegisterController',
                controllerAs: 'register'
            })
            .state('login', {
                url: '/login',
                templateUrl: '/views/login.html',
                controller: 'LoginController',
                controllerAs: 'login'
            });
    }]);