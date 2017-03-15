(function(){

	'use strict';

	app.factory('LoginService', LoginService);

    LoginService.$inject = ['$http'];

	function LoginService($http){
		var service = {};

		service.login = function(user) {
			//console.log(user);
			//console.log("chegou no service"); tratar com o back
		};

		return service;
	};

})();