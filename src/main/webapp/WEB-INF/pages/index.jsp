<html>
<body>
<div id="title">Comparar alimentos</div>
<div id="content">
	<div ng-controller="FoodCtrl">
		<form id="search-box" ng-submit="add();">
			<div>
			    <input type="text" ng-model="asyncSelected" placeholder="Digite o nome do alimento. Ex: Arroz" 
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
		          <td ng-repeat="element in value track by $index" ng-class="{ 'higher' : (element.higher && value.length > 2) }"
		          	>{{formatNumber(element.value)}} <span ng-if="!isNumber(element.value)" tooltip="{{getTooltipText(element.value)}}" 
		          		tooltip-placement="right" tooltip-append-to-body="true" class="tooltipHelp"></span></td>
		        </tr>
		      </tbody>
		    </table>
		    <div ng-if="!isEmpty(foods)">
		    	<p><strong>Fonte:</strong> <a href="http://www.unicamp.br/nepa/taco/" target="blank">TACO</a> - Tabela Brasileira de Composi&ccedil;&atilde;o de Alimentos</p>
		    	<!-- Tr: Tra&ccedil;o. Adotou-se tra&ccedil;o nas seguintes situa&ccedil;&otilde;es:
				<ol>
					<li>valores de nutrientes arredondados para n&uacute;meros que caiam entre 0 e 0,5;</li>
					<li>valores de nutrientes arredondados para n&uacute;meros com uma casa decimal que caiam entre 0 e 0,05;</li>
					<li>valores de nutrientes arredondados para n&uacute;meros com duas casas decimais que caiam entre 0 e 0,005 e;</li>
					<li>
						valores abaixo dos limites de quantifica&ccedil;&atilde;o.
						<ol>
							<li>composi&ccedil;&atilde;o centesimal: 0,1g/100g;</li>
							<li>colesterol: 1mg/100g;</li>
							<li>Cu, Fe, Mn, e Zn: 0,001mg/100g;</li>
							<li>Ca, Na: 0,04mg/100g;</li>
							<li>K e P: 0,001mg/100g;</li>
							<li>Mg 0,015mg/100g;</li>
							<li>tiamina, riboflavina e piridoxina: 0,03mg/100g;</li>
							<li>niacina e vitamina C: 1mg/100g;</li>
							<li>retinol em produtos c&aacute;rneos e outros: 3μg/100g e;</li>
							<li>retinol em l&aacute;cteos: 20μg/100g.</li>
						</ol>
					</li>
				</ol--> 
	    	</div>
	    </div>
	</div>
</div>
</body>
</html>