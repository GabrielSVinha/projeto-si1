(function() {
    'use strict';

    app.directive('navigationBar', NavigationBar);

    NavigationBar.$inject = ['$state', 'UserService'];

    function NavigationBar($state, UserService) {
        return {
            restrict: 'E',
            templateUrl: '/views/navigation-bar.html',
            scope: {},
            link: function(scope, el) {
                scope.isLoggedIn = function() {
                    return UserService.isLoggedIn();
                };

                scope.logout = function() {
                    UserService.logout()
                        .then(function(success) {
                            if (success) {
                                $state.go('home');
                            }
                        });
                };
            }
        };
    }
})();