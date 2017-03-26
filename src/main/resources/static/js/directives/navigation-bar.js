(function() {
    'use strict';

    app.directive('navigationBar', NavigationBar);

    NavigationBar.$inject = ['$rootScope', '$state', 'UserService'];

    function NavigationBar($rootScope, $state, UserService) {
        return {
            restrict: 'E',
            templateUrl: '/views/navigation-bar.html',
            scope: {},
            link: function(scope, el) {
                scope.isLoggedIn = function() {
                    return UserService.isLoggedIn();
                };

                UserService.getUser()
                    .then(function(user) {
                        scope.user = user;
                    })
                    .catch(function() {
                        scope.user = null;
                    });

                scope.logout = function() {
                    UserService.logout()
                        .then(function(success) {
                            if (success) {
                                $state.go('home');
                            }
                        });
                };

                $rootScope.$on('loginSuccess', function() {
                    UserService.getUser()
                        .then(function(user) {
                            scope.user = user;
                        });
                });
            }
        };
    }
})();