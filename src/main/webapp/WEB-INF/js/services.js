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
        	hash[name] = [""];
        	hash['umidade'] = ['Umidade (%)'];
        	hash['energiaKcal'] = ['Energia (kcal)'];
        	hash['energiaKJ'] = ['Energia (kJ)'];
        	hash['proteina'] = ['Proteína (g)'];
        	hash['lipideos'] = ['Lipídeos (g)'];
        	hash['colesterol'] = ['Colesterol (mg)'];
        	hash['carboidrato'] = ['Carboidrato (g)'];
        	hash['fibraAlimentar'] = ['Fibra Alimentar (g)'];
        	hash['cinzas'] = ['Cinzas (g)'];
        	hash['calcio'] = ['Cálcio (mg)'];
        	hash['magnesio'] = ['Magnésio (mg)'];
        	hash['manganes'] = ['Manganês (mg)'];
        	hash['fosforo'] = ['Fósforo (mg)'];
        	hash['ferro'] = ['Ferro (mg)'];
        	hash['sodio'] = ['Sódio (mg)'];
        	hash['potassio'] = ['Potássio (mg)'];
        	hash['cobre'] = ['Cobre (mg)'];
        	hash['zinco'] = ['Zinco (mg)'];
        	hash['retinol'] = ['Retinol (mcg)'];
        	hash['re'] = ['RE (mcg)'];
        	hash['rae'] = ['RAE  (mcg)'];
        	hash['tiamina'] = ['Tiamina (mg)'];
        	hash['riboflavina'] = ['Riboflavina (mg)'];
        	hash['piridoxina'] = ['Piridoxina (mg)'];
        	hash['niacina'] = ['Niacina (mg)'];
        	hash['vitaminaC'] = ['Vitamina C (mg)'];
        },
        updateArray: function(data, hash) {
        	hash[name].push(data.name);
        	angular.forEach(Object.keys(data.foodElement), function(value, key) {
        		var v;
        		if(data.foodElement[value] != null && data.foodElement[value].trim() == "") 
        			v = "-";
        		else 
        			v = data.foodElement[value];
        		hash[value].push(v);
			});
        }
    };
});
