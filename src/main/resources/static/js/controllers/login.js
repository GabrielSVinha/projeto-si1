(function() {
    'use strict';

    app.controller('LoginController', LoginController);

    LoginController.$inject = ['$state', 'UserService'];

    function LoginController($state, UserService) {
        var self = this;

        this.submit = function(user) {
            UserService.login(user)
                .then(function(token) {
                    if (token !== null) {
                        $state.go('profile');
                    }
                });
        };
    }
})();