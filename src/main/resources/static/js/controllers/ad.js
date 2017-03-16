(function() {
    'use strict';

    app.controller('AdController', AdController);

    AdController.$inject = ['AdService'];

    function AdController(adService) {
        var self = this;

        this.ads = adService.getAll();
    };

})();