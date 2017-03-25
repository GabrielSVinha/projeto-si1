(function() {
    'use strict';

    app.service('UserService', UserService);

    UserService.$inject = ['$http', '$q'];

    function UserService($http, $q) {
        var self = this;

        this.getUser = function() {
            var deferred = $q.defer();

            return deferred.promise;
        };

        this.registerUser = function(user) {
            return $http.post('/api/user/', user);
        };

        this.login = function() {

        };
    }
})();