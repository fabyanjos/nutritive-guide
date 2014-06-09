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
//					$http.get('/js/elements-obj.json').then(function(result) {
//						$scope.foods = result.data;
//						console.log($scope.foods);
//			        });
					appService.createArray(data, $scope.foods);
				}
				appService.updateArray(data, $scope.foods);
			});
			$scope.asyncSelected = null;
			$scope.$item = null;
		}
	};
	
	$scope.search = function(val) {
		if(val.length >= 2) {
			var result = Food.query({ method: 'names', name: val, maxResults: 10});
			
			return result.$promise.then(
					function(data) {
						return data;
					});
		}
		return [];
	};
}]);

app.controller("FoodElementCtrl",['$http', '$scope', 'FoodElement', 'appService', 'Category', function($http, $scope, FoodElement, appService, Category) {
	$scope.formatNumber = function(number) {
		return appService.formatNumber(number);
    };
    $scope.isEmpty = function(obj) {
		return appService.isEmpty(obj);
    };
	$scope.foods = [];

	$scope.elements = [];
	$scope.categories = [];
	
	$scope.fetchCategories = function() {
		var result = Category.query(function(){});
		result.$promise.then(function(data) {
			$scope.categories = data;
		});
	};
	$scope.fetchElements = function() {
        $http.get('/js/elements.json').then(function(result) {
            $scope.elements = result.data;
        });
    };

    $scope.fetchElements();
    $scope.fetchCategories();
		
	$scope.change = function() {
		console.log("change");
		var categoryId = $scope.category ? $scope.category.id : '0';
		if($scope.element) {
			$("#category").attr('style', "display:")
			var result = FoodElement.query({ method: 'element', element: $scope.element.value, category: categoryId});
			result.$promise.then(function(data) {
				$scope.foods = data;
			});
		}
	};
	
	
}]);