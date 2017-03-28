(function() {
    'use strict';

    app.service('AdService', AdService);

    AdService.$inject = ['$http', 'UserService'];

    function AdService($http, UserService) {
        var self = this;

        this.getAll = function() {
            return $http.get('/api/ad/')
                .then(response => response.data);
        };

        this.searchBy = function(searchContent, searchType) {
            return $http.get('/api/ad/search?searchContent=' + searchContent + '&searchType=' + searchType)
                .then(response => response.data);
        };

        this.createAd = function(ad) {
            return UserService.getUser()
                .then(function(user) {
                    console.log(user);
                    ad.userId = user.id;
                    return ad;
                })
                .then(function(ad) {
                    console.log(ad);
                    return $http.post('/api/ad/new', ad);
                })
                .then(response => response.entity);
        };
    }
})();