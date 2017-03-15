(function(){

	'use strict';

	app.factory('LoginService', LoginService);

	function LoginService($http){
		var self= this;

		self.myService = {};


		function postLogin(user){
			//console.log(user);
			//console.log("chegou no service"); tratar com o back
		}

		self.myService.postLogin = postLogin;


		return self.myService;
	};

})();