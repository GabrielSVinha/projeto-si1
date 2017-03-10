(function() {
    'use strict';

    app.directive('navigationBar', NavigationBar);

    NavigationBar.$inject = [];

    function NavigationBar() {
        return {
            restrict: 'E',
            templateUrl: '/js/directives/navigation-bar/view.html'
        };
    }
})();