var app = angular.module('ad-extreme', ['ui.router', 'ngMessages', 'ngAria'])
    .config(['$locationProvider', '$stateProvider', function($locationProvider, $stateProvider) {
        $locationProvider.html5Mode(true);

        /**
         * If you're going to add another route, be sure to also add
         * it in the class br.edu.ufcg.computacao.si1.config.WebConfig
         */
        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: '/views/home.html',
                controller: 'HomeController',
                controllerAs: 'homeCtrl'
            })
            .state('register', {
                url: '/cadastre-se',
                templateUrl: '/views/register.html',
                controller: 'RegisterController',
                controllerAs: 'registerCtrl'
            })
            .state('login', {
                url: '/login',
                templateUrl: '/views/login.html',
                controller: 'LoginController',
                controllerAs: 'loginCtrl'
            });
    }]);