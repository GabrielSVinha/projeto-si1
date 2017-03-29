(function() {
    'use strict';

    app.service('UserService', UserService);

    UserService.$inject = ['$http', '$q', '$cookies', '$rootScope'];

    function UserService($http, $q, $cookies, $rootScope) {
        var self = this;

        this.user = null;

        this.getUser = function() {
            var deferred = $q.defer();

            if (self.user !== null) {
                deferred.resolve(self.user);
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
            return $http.post('/api/user/new', user)
                .then(response => response.data)
                .then(function(user) {
                    self.user = user;
                    return self.login(user);
                });
        };

        this.login = function(user) {
            return $http.post('/api/user/login', user)
                .then(response => response.data)
                .then(function(response) {
                    $cookies.put('token', response.tokenKey);
                    $rootScope.$broadcast('loginSuccess');

                    return self.getUser();
                })
                .catch(function() {
                    $rootScope.$broadcast('loginFailed');

                    return null;
                });
        };

        this.logout = function() {
            return $http.post('/api/user/logout')
                .then(function(response) {
                    if (response.status === 204) {
                        self.user = null;
                        $cookies.remove('token');
                        $rootScope.$broadcast('logoutSuccess');

                        return true;
                    }

                    $rootScope.$broadcast('logoutFailed');
                    return false;
                })
                .catch(function() {
                    $rootScope.$broadcast('logoutFailed');
                    return false;
                });
        };

        this.isLoggedIn = function() {
            return self.user !== null && angular.isDefined($cookies.get('token'));
        };
        this.sold_ads = function(id){
            return $http.get("/api/user/sold/" + id)
                .then(response => response.data)
        };
    }
})();
