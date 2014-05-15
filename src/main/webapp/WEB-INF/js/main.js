var app = angular.module('nutritive-guide', [ 'ngResource', 'ui.bootstrap']);

app.factory('Category', [ '$resource', function($resource) {
	return $resource('/category/:id', null, {
		'update' : { method : 'PUT' }
	});
}]);

app.factory('Element', [ '$resource', function($resource) {
	return $resource('/element/:id', null, {
		'update' : { method : 'PUT' }
	});
}]);

app.factory('Food', [ '$resource', function($resource) {
	return $resource('/food/:method/:id', null, {
		'update' : { method : 'PUT' },
		query: {method:'GET', params:{method: 'byName', name:'name'}, isArray:true}
	});
}]);
