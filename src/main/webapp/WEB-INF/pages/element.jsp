<html>
<body>
<div id="title">Consulta por nutriente</div>
<div id="content">
	<div ng-controller="FoodElementCtrl">
		<div class="filter-box">
		  	<select 
		  		ng-model="element" 
		  		ng-options="element.name for element in elements" 
		  		ng-change="change();" 
		  		>
		  		<option selected="selected" value="">Selecione um nutrienete</option>
		  	</select>
	  		<select 
	  			ng-model="category" 
	  			ng-options="category.name for category in categories" 
	  			ng-change="change();"
	  			style="display:none;"
	  			id="category"
	  			>
	  			<option selected="selected" value="">Selecione uma categoria</option>
	  		</select>
	  	</div>
	  	<br/>
	  		
		<table ng-if="!isEmpty(foods)">
	      <thead>
	      	<tr>
		      	<th>Alimento</th>
		      	<th>Quantidade</th>
		     </tr>
	      </thead>
	      <tbody>
	        <tr ng-repeat="food in foods">
	          <td>{{food.name}}</td>
	          <td>{{formatNumber(food.foodElement[element.value])}}</td>
	        </tr>
	      </tbody>
	    </table>
	    
	    <div ng-if="!isEmpty(foods)">
			<p><strong>Fonte:</strong> <a href="http://www.unicamp.br/nepa/taco/" target="blank">TACO</a> - Tabela Brasileira de Composi&ccedil;&atilde;o de Alimentos</p>
		</div>
	</div>
</div>
</body>
</html>