var app = angular.module('ad-extreme', ['ui.router', 'ngMessages'])
    .config(['$locationProvider', '$stateProvider', function($locationProvider, $stateProvider) {
        $locationProvider.html5Mode(true);

        /**
         * If you're going to add another route, be sure to also add
         * it in the class br.edu.ufcg.computação.si1.config.WebConfig
         */
        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: '/views/home.html',
                controller: 'HomeController',
                controllerAs: 'home'
            })
            .state('register', {
                url: '/cadastre-se',
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