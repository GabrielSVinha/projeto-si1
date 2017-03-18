(function() {
    'use strict';

    app.directive('mainFooter', MainFooterDirective);

    MainFooterDirective.$inject = [];

    function MainFooterDirective() {
        return {
            restrict: 'E',
            templateUrl: '/views/main-footer.html'
        };
    }
})();