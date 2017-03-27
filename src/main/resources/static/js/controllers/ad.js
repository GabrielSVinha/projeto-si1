(function() {
    'use strict';

    app.controller('AdController', AdController);

    AdController.$inject = ['$state', 'AdService'];

    function AdController($state, AdService) {
        var self = this;

        this.ads = [];

        AdService.getAll()
            .then(function(ads) {
                self.ads = ads;
            });

        this.createAd = function(ad) {
            AdService.createAd(ad)
                .then(function(ad) {
                    if (ad !== null) {
                        self.ads.push(ad);
                        $state.go('^.list');
                    }
                });
        }

        this.clearAdForm = function(ad, form) {
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