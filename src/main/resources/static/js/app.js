var app = angular.module('ad-extreme', ['ui.router', 'ngMessages', 'ngAria', 'ngCookies'])
    .config(['$locationProvider', '$stateProvider', function($locationProvider, $stateProvider) {
        $locationProvider.html5Mode(true);

        /**
         * If you're going to add another route, be sure to also add
         * it in the class br.edu.ufcg.computacao.si1.config.WebConfig
         */
        $stateProvider
            .state('app', {
                abstract: true,
                resolve: {
                    user: ['UserService', function(UserService) {
                        return UserService
                            .getUser()
                            .catch(() => ({}));
                    }]
                },
                template: '<div data-ui-view></div>'
            })
            .state('home', {
                parent: 'app',
                url: '/',
                templateUrl: '/views/home.html',
                controller: 'HomeController',
                controllerAs: 'homeCtrl'
            })
            .state('register', {
                parent: 'app',
                url: '/cadastre-se',
                templateUrl: '/views/register.html',
                controller: 'RegisterController',
                controllerAs: 'registerCtrl'
            })
            .state('login', {
                parent: 'app',
                url: '/login',
                templateUrl: '/views/login.html',
                controller: 'LoginController',
                controllerAs: 'loginCtrl'
            })
            .state('ads', {
                parent: 'app',
                url: '/anuncios',
                templateUrl: '/views/ad-list.html',
                controller: 'AdController',
                controllerAs: 'adsCtrl'
            });
    }]);