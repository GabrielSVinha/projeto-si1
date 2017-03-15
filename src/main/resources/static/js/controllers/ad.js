(function() {
    'use strict';

    app.controller('AdController', AdController);

    AdController.$inject = [];

    function AdController(){
        var self = this;

        this.ads = [];
    };

})();