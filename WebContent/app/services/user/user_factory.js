'use strict';

/* UserFactory Services */

//var userFactory = angular.module('userFactory', ['ngResource']);

gifts.lazy.factory('UserFactory', function($resource, $q, $log) {
	console.log('From UserFactory');
	
	
	 var resource = $resource('createAccount/:id', {id : '@id'});
	 
	// $log.log (resource);
	 
	 return resource;
});