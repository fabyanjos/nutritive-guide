var app = angular.module('nutritive-guide', [ 'ngResource', 'ui.bootstrap']);

app.directive('chosen', function() {
	var linker = function(scope, element, attrs) {
		var list = attrs['chosen'];
        scope.$watch(list, function() {
        	element.trigger('liszt:updated');
        	element.trigger("chosen:updated");
        });
        scope.$watch(element.ngModel, function(newVal, oldVal) {
        	  if (newVal !== oldVal) {
        	    stopLoading();
        	  }
        	});
        element.chosen();
	};
	return {
		restrict: 'A',
		link: linker
	};
});

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
	return $resource('/foods/:method/:name//:maxResults/:id', null, {
		'update' : { method : 'PUT' },
		query: {method:'GET', params:{method: 'method', name: 'name', maxResults: 'maxResults'}, isArray:true},
	});
}]);

app.factory('FoodElement', [ '$resource', function($resource) {
	return $resource('/foods/:method/:element/:category', null, {
		'update' : { method : 'PUT' },
		query: {method:'GET', params:{method: 'method', element: 'element', category: 'category'}, isArray:true}
	});
}]);