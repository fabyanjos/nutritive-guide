var app = angular.module('nutritive-guide', [ 'ngResource', 'ui.bootstrap']);

app.factory('appService', function() {
    return {
        formatNumber: function(number) {
        	var n = number.replace(",", ".");
        	if(!isNaN(n) && number) {
	        	var num = numeral(n).format('0.00');
	            return num.replace(".", ",");
        	}
        	return number;
        },
        createArray: function(data, hash) {
        	hash[0] = [""];
        	angular.forEach(data.foodElements, function(value, key) {
        		var element = [];
        		element.push(value.pk.element.name);
        		hash[value.pk.element.id] = element;
			});
        },
        updateArray: function(data, hash) {
        	hash[0].push(data.name);
        	angular.forEach(data.foodElements, function(value, key) {
        		var v;
        		if(value.value.trim() == "") 
        			v = "-";
        		else 
        			v = value.value;
        		hash[value.pk.element.id].push(v);
			});
        }
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
	return $resource('/food/:method/:id', null, {
		'update' : { method : 'PUT' },
		query: {method:'GET', params:{method: 'byName', name:'name'}, isArray:true}
	});
}]);

app.controller("CategoryCtrl",['$scope', 'Category', function($scope, Category) {
	$scope.categories = Category.query(function(){});
}]);

app.controller("ElementCtrl",['$scope', 'Element', function($scope, Element){
	$scope.elements = Element.query(function(){});
}]);

app.controller("FoodCtrl", [ '$scope', '$http', 'Food', 'appService', function($scope, $http, Food, appService) {
	$scope.formatNumber = function(number) {
		return appService.formatNumber(number);
    };
	$scope.foods = {};
	$scope.first = true;
	
	$scope.onSelect = function ($item) {
		$scope.$item = $item;
	};
	
	$scope.add = function() {
		if($scope.$item != null) {
			Food.get({ id : $scope.$item.id }, function(data) {
				if($scope.first) {
					$scope.first = false;
					appService.createArray(data, $scope.foods);
				}
				appService.updateArray(data, $scope.foods);
			});
			$scope.asyncSelected = "";
		}
	};
	
	$scope.getLocation = function(val) {
		var list = [];
		return $http.get('/food/filter/name', {
			params : { name : val }
		}).success(function(data, status, headers, config) {
			angular.forEach(data, function(item) {
				list.push(item);
			});
        }).error(function(data, status, headers, config) {
            console.log('error: ' + status);
        }).then(function(res){
        	return list;
	    });
	};
}]);