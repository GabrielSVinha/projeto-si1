(function () {
    'use strict';

    app.controller('AdController', AdController);

    AdController.$inject = ['$state', 'AdService', '$stateParams', 'UserService'];

    function AdController($state, AdService, $stateParams, UserService) {
        var self = this;

        this.ads = [];

        AdService.getAll()
            .then(function (ads) {
                self.ads = ads;
            });

        this.createAd = function (ad) {
            AdService
                .createAd(ad)
                .then(function () {
                    return AdService.getAll();
                })
                .then(function(ads) {
                    self.ads = ads;
                    $state.go('^.list');
                });
        }

        this.search = function (searchContent, searchType) {
            AdService.searchBy(searchContent, searchType).then((data) => {
                self.ads = data;
            });
        };

        this.clearAdForm = function (ad, form) {
            if (!ad) {
                return;
            }

            ad.title = null;
            ad.price = null;
            ad.type = null;

            form.$setPristine();
            form.$setUntouched();
        };
    };

})();