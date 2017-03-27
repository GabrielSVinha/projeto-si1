(function() {
    'use strict';

    app.filter('dateToTimestamp', [function() {
        return function(dateStr) {
            return (new Date(dateStr)).getTime();
        }
    }]);
})();