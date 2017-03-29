(function() {
    'use strict';

    app.controller('ProfileController', ProfileController);

    ProfileController.$inject = ['$state', 'UserService', 'flash', '$stateParams'];

    function ProfileController($state, $stateParams, UserService, flash) {
        var self = this;
        var user = $stateParams["user"];
        var sold_ads = $stateParams["sold_ads"](user["user_id"]);
    }
})();
