(function() {
    'use strict';

    app.controller('ProfileController', ProfileController);

    ProfileController.$inject = ['$state', 'AdService', '$stateParams', 'UserService'];

    function ProfileController($state, AdService, $stateParams, UserService) {
        var self = this;

        this.userAds = [];
        this.userInfo = [];

        this.getUser = function() {
            return UserService.getUser();
        };

        this.getUser().then((user) => {
            AdService.searchBy(user.name, 'user').then((data) => {
                self.userAds = data;
            });
        });

        this.getUser().then((userData) => {
            this.userInfo.push(userData.name);
            this.userInfo.push(userData.email);
            this.userInfo.push(userData.balance);
        });

        console.log(this.getUser());
    }

})();
