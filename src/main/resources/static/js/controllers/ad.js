(function () {
    'use strict';

    app.controller('AdController', AdController);

    AdController.$inject = ['$state', 'AdService', '$stateParams', 'UserService'];

    function AdController($state, AdService, $stateParams, UserService) {
        var self = this;

        this.ads = [];

        this.createAd = function (ad) {
            AdService.createAd(ad)
                .then(function (ad) {
                    if (ad !== null) {
                        self.ads.push(ad);
                        $state.go('^.list');
                    }
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

        (() => {
            if ($state.current.data.loadUserAds) {
                UserService.getUser().then((user) => {
                    self.search(user.name, 'user');
                });
            } else {
                AdService.getAll()
                    .then(function (ads) {
                        self.ads = ads;
                    });
            }
        })();
    };

})();