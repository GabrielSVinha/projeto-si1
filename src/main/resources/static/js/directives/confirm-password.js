(function() {
    'use strict';

    app.directive('confirmPassword', ConfirmPasswordDirective);

    ConfirmPasswordDirective.$inject = [];

    function ConfirmPasswordDirective() {
        return {
            restrict: 'A',
            require: '?ngModel',
            scope: {
                password: '=confirmPassword'
            },
            link: function(scope, el, attrs, ngModelController) {
                if (!ngModelController) {
                    return;
                }

                ngModelController.$validators.confirmPassword = function(modelValue, viewValue) {
                    return validatePassword(scope.password, modelValue || viewValue);
                };

                scope.$watch('password', function(password) {
                    const compareResult = validatePassword(password, ngModelController.$modelValue || ngModelController.$viewValue);

                    ngModelController.$setValidity('confirmPassword', compareResult);
                });

                /**
                 * Validate the confirm password with the password
                 *
                 * @param {string} password
                 * @param {string} modelValue
                 *
                 * @returns {boolean}
                 */
                function validatePassword(password, modelValue) {
                    if (typeof modelValue === 'undefined' && typeof password === 'string' && password.lenght === 0) {
                        return true;
                    } else if (typeof password === 'undefined' && typeof modelValue === 'string' && modelValue.length === 0) {
                        return true;
                    }

                    return password === modelValue;
                }
            }
        }
    }
})();