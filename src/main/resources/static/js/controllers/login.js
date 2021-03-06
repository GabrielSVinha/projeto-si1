(function() {
    'use strict';

    app.controller('LoginController', LoginController);

    LoginController.$inject = ['$state', 'UserService'];

    function LoginController($state, UserService) {
        var self = this;

        this.submit = function(user) {
            UserService.login(user)
                .then(function(user) {
                    if (user !== null) {
                        $state.go('profile', {profile: user});
                    }
                })
                .catch(function() {
                    // ops..
                });
        };
    }
})();