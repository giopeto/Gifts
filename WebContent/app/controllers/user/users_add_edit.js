'use strict';

/* User Add Edit Controller */

gifts.lazy.controller('usersAddEditCtrl', function($scope, $log, UserFactory, $http) {
	
	var usersScope = this;
	usersScope.user = new UserFactory();
	
	/*usersScope.user = {
		firstName: '',
		lastName: '',
		email: '',
		userName: '',
		password: ''
	};*/
	
	usersScope.set = function () {
		
		UserFactory.save(usersScope.user, function (data) {
			$log.log("data", data);
		}, function (error) {
			$log.log (error);
		});
		
	};
	
	$log.info ('asd3')
	
});