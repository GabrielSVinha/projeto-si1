(function() {
    'use strict';

    app.factory('AdService', AdService);

    AdService.$inject = ['$http'];

    function AdService($http) {
        var service = {};

        service.getAll = function() {
            return [];
        };

        return service;
    }
})();