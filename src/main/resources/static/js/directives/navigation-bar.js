(function() {
    'use strict';

    app.directive('navigationBar', NavigationBar);

    NavigationBar.$inject = [];

    function NavigationBar() {
        return {
            restrict: 'E',
            templateUrl: '/views/navigation-bar.html'
        };
    }
})();