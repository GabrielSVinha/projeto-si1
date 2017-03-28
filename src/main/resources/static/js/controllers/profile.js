(function() {
    'use strict';

    app.controller('ProfileController', ProfileController);

    ProfileController.$inject = ['$state', 'UserService', 'flash', '$stateParams'];

    function ProfileController($state, UserService, flash) {
        var self = this;
        this.user = $state.params.profile;
        console.log("====> user: " + this.user)
        var message = '<strong> Well done!</strong>  You successfully read this important alert message.';
        flash(message);
        this.sold_ads = UserService.sold_ads;
    }
})();
