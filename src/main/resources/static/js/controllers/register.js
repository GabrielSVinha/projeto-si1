(function() {
    'use strict';

    app.controller('RegisterController', RegisterController);

    RegisterController.$inject = [];

    function RegisterController() {
        var self = this;

        this.submitForm = function(user) {
            // register
        };

        this.resetForm = function(user, form) {
            if (!user) {
                return;
            }

            user.name = null;
            user.email = null;
            user.password = null;
            user.confirmPassword = null;
            user.role = null;

            form.$setPristine();
            form.$setUntouched();
        };
    }
})();