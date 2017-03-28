(function() {
    'use strict';

    app.controller('ProfileController', ProfileController);

    ProfileController.$inject = ['$state', 'UserService', 'AdService', 'flash'];

    function ProfileController($state, UserService, AdService, flash) {
        var self = this;

        this.soldAds = [];
        this.user = null;

        UserService.getUser()
            .then(function(user) {
                self.user = user;
                return AdService.getSoldAds(user.user_id);
            })
            .then(function(soldAds) {
                self.soldAds = soldAds;
            });
    }
})();
