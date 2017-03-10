var app = angular.module('ad-extreme', ['ui.router'])
    .config(['$locationProvider', '$stateProvider', function($locationProvider, $stateProvider) {
        $locationProvider.html5Mode(true);

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: '/js/views/home.html',
                controller: 'HomeController',
                controllerAs: 'home'
            })
            .state('register', {
                url: '/cadastrar-se'
            })
            .state('login', {
                url: '/login'
            });
    }]);