//Define an angular module for our app
var gifts = angular.module('gifts', ['ngRoute', 'ngResource']);

gifts.config(function ($controllerProvider, $compileProvider, $filterProvider, $provide, $routeProvider) {
	
	gifts.lazy = {
        controller: $controllerProvider.register,
       	directive: $compileProvider.directive,
        filter: $filterProvider.register,
        factory: $provide.factory,
        service: $provide.service
    };
   
    $routeProvider.when('/users_add_edit', {
		templateUrl: 'app/templates/user/users_add_edit.html',
		resolve: {
			load: ['$q', '$rootScope', function ($q, $rootScope) {
				var deferred = $q.defer();
				require([
					//'directives/dateAndTime.js',
					'app/controllers/user/users_add_edit.js',
					'app/services/user/user_factory.js',
				], function () {
					$rootScope.$apply(function () {
						deferred.resolve();
					}, function () {
						console.log ('ERROR');
					});
				});
				return deferred.promise;
			}]
		}
	}).when('/login', {
		templateUrl: 'app/templates/user/login.html',
		resolve: {
			load: ['$q', '$rootScope', function ($q, $rootScope) {
				var deferred = $q.defer();
				require([
					//'directives/dateAndTime.js',
					'app/controllers/user/login.js',
					/*'app/services/user/user_factory.js',*/
				], function () {
					$rootScope.$apply(function () {
						deferred.resolve();
					}, function () {
						console.log ('ERROR');
					});
				});
				return deferred.promise;
			}]
		}
	}).otherwise({
		redirectTo: '/users_add_edit',
	});



});