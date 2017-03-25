(function() {
    'use strict';

    app.service('UserService', UserService);

    UserService.$inject = ['$http', '$q', '$cookies'];

    function UserService($http, $q, $cookies) {
        var self = this;

        this.user = null;

        this.getUser = function() {
            var deferred = $q.defer();

            if (self.user !== null) {
                deferred.resolve(user);
            }

            if (!angular.isDefined($cookies.get('token'))) {
                deferred.reject();
            } else {
                $http.get('/api/user/me')
                    .then(response => response.data)
                    .then(user => {
                        self.user = user;
                        deferred.resolve(user);
                    })
                    .catch(() => {
                        self.user = null;
                        $cookies.remove('token');
                        deferred.reject();
                    });
            }

            return deferred.promise;
        };

        this.registerUser = function(user) {
            return $http.post('/api/user/', user);
        };

        this.login = function(user) {
            return $http.post('/api/user/login', user)
                .then(response => response.data)
                .then(function(response) {
                    $cookies.put('token', response.tokenKey);
                    return response;
                })
                .catch(function() {
                    return null;
                });
        };

        this.logout = function() {
            return $http.post('/api/user/logout')
                .then(function(response) {
                    if (response.status === 204) {
                        self.user = null;
                        $cookies.remove('token');

                        return true;
                    }

                    return false;
                })
                .catch(function() {
                    return false;
                });
        };

        this.isLoggedIn = function() {
            return self.user !== null && angular.isDefined($cookies.get('token'));
        };
    }
})();