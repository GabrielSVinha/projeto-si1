(function() {
    'use strict';

    app.controller('RegisterController', RegisterController);

    RegisterController.$inject = ['$state', 'UserService'];

    function RegisterController($state, UserService) {
        var self = this;

        this.submitForm = function(user) {
            UserService.registerUser(user)
                .then(function(user) {
                    if (user !== null) {
                        $state.go('profile');
                    }
                })
                .catch(function() {
                    // heh..
                });
        };

        this.resetForm = function(user, form) {
            if (!user) {
                return;
            }

            user.name = null;
            user.email = null;
            user.password = null;
            user.confirmPassword = null;
            user.type = null;

            form.$setPristine();
            form.$setUntouched();
        };
    }
})();