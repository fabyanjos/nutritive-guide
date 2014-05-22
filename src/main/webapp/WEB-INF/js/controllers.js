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
    $scope.isEmpty = function(obj) {
		return appService.isEmpty(obj);
    };
    $scope.getTooltipText = function(text) {
		return appService.getTooltipText(text);
    };
    $scope.isNumber = function(text) {
		return appService.isNumber(text);
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
			$scope.asyncSelected = null;
			$scope.$item = null;
		}
	};
	
	$scope.search = function(val) {
		var list = [];
		if(val.length >= 2) {
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
		}
		return [];
	};
}]);
