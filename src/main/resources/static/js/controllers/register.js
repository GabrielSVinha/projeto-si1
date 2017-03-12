(function() {
    'use strict';

    app.controller('RegisterController', RegisterController);

    RegisterController.$inject = [];

    function RegisterController() {
        var self = this;

        this.submitForm = function(user) {
            // register
        };

        this.resetForm = function(evt, user) {
            evt.preventDefault();

            for (var key in user) {
                if (user.hasOwnProperty(key)) {
                    delete user[key];
                }
            }
        };
    }
})();