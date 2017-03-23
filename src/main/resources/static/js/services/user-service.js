(function() {
    'use strict';

    app.service('UserService', UserService);

    UserService.$inject = ['$http', '$q'];

    function UserService($http, $q) {
        var self = this;

        this.getUser = function() {

        };
    }
})();