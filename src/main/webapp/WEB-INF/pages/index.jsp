<html>
<body>
<div id="title">Comparar</div>
<div id="content">
	<div ng-controller="FoodCtrl">
		<form id="search-box" ng-submit="add();">
			<div>
			    <input type="text" ng-model="asyncSelected" placeholder="Digite o nome do alimento" 
			    	typeahead="food.name for food in search($viewValue) | filter:$viewValue" 
			    	typeahead-loading="loadingFoods" typeahead-on-select="onSelect($item)">
		    </div>
		    <input type="button" value="Adicionar" ng-click="add()"/>
		    <i ng-show="loadingFoods" class="glyphicon glyphicon-refresh"></i>
		</form>
		<div id="scrolltable">
	    <table id="tb-food">
	      <thead>
	      </thead>
	      <tbody>
	        <tr ng-repeat="(id, value) in foods">
	          <td ng-repeat="text in value track by $index">{{formatNumber(text)}}</td>
	        </tr>
	      </tbody>
	    </table>
	    </div>
	</div>
</div>
</body>
</html>