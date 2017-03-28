(function() {
    'use strict';

    app.controller('ProfileController', ProfileController);

    ProfileController.$inject = ['$state', 'AdService', '$stateParams', 'UserService'];

    function ProfileController($state, AdService, $stateParams, UserService) {
        var self = this;

        this.userAds = [];

        UserService.getUser().then((user) => {
            AdService.searchBy(user.name, 'user').then((data) => {
                self.userAds = data;
            });
        });

        console.log(this.userAds);


    }

})();