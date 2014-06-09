app.factory('appService', function() {
    return {
        formatNumber: function(number) {
        	if(!isNaN(number) && number) {
	        	var num = numeral(number).format('0.00');
	            return num.replace(".", ",");
        	}
        	return number;
        },
        createArray: function(data, hash) {
        	hash['1'] = [{'value' : ''}];
        	hash['umidade'] = [{'value' : 'Umidade (%)'}];
        	hash['energiaKcal'] = [{'value' : 'Energia (kcal)'}];
        	hash['energiaKJ'] = [{'value' : 'Energia (kJ)'}];
        	hash['proteina'] = [{'value' : 'Proteína (g)'}];
        	hash['lipideos'] = [{'value' : 'Lipídeos (g)'}];
        	hash['colesterol'] = [{'value' : 'Colesterol (mg)'}];
        	hash['carboidrato'] = [{'value' : 'Carboidrato (g)'}];
        	hash['fibraAlimentar'] = [{'value' : 'Fibra Alimentar (g)'}];
        	hash['cinzas'] = [{'value' : 'Cinzas (g)'}];
        	hash['calcio'] = [{'value' : 'Cálcio (mg)'}];
        	hash['magnesio'] = [{'value' : 'Magnésio (mg)'}];
        	hash['manganes'] = [{'value' : 'Manganês (mg)'}];
        	hash['fosforo'] = [{'value' : 'Fósforo (mg)'}];
        	hash['ferro'] = [{'value' : 'Ferro (mg)'}];
        	hash['sodio'] = [{'value' : 'Sódio (mg)'}];
        	hash['potassio'] = [{'value' : 'Potássio (mg)'}];
        	hash['cobre'] = [{'value' : 'Cobre (mg)'}];
        	hash['zinco'] = [{'value' : 'Zinco (mg)'}];
        	hash['retinol'] = [{'value' : 'Retinol (mcg)'}];
        	hash['re'] = [{'value' : 'RE (mcg)'}];
        	hash['rae'] = [{'value' : 'RAE  (mcg)'}];
        	hash['tiamina'] = [{'value' : 'Tiamina (mg)'}];
        	hash['riboflavina'] = [{'value' : 'Riboflavina (mg)'}];
        	hash['piridoxina'] = [{'value' : 'Piridoxina (mg)'}];
        	hash['niacina'] = [{'value' : 'Niacina (mg)'}];
        	hash['vitaminaC'] = [{'value' : 'Vitamina C (mg)'}];
        },
        updateArray: function(data, hash) {
        	hash['1'].push({'value' : data.name});
        	angular.forEach(Object.keys(data.foodElement), function(value) {
        		var v = {};
        		if(data.foodElement[value] != null && data.foodElement[value].trim() == "") { 
        			v.value = "-";
        			v.higher = false;
        		} else {
        			var number = parseFloat(data.foodElement[value].replace(",", ".")); 
        			if(!isNaN(number)) {
        				v.higher = true;
	        			angular.forEach(hash[value], function(item, key) {
	        				var num = parseFloat(item.value.replace(",", "."));
	        				if(!isNaN(num))
	        					if (number > num) {
	        						item.higher = false;
	        					} else {
	        						v.higher = false;
	        					}
	        			});
        			} else
        				v.higher = false;
        			v.value =  data.foodElement[value];
        		}
        		hash[value].push(v);
			});
        },
        isEmpty: function(obj) {
        	return angular.equals({}, obj) || angular.equals([], obj) || angular.equals(undefined, obj);
        },
        getTooltipText: function(text) {
        	if(text.indexOf("(g)") > -1)
        		return "grama";
        	else if(text.indexOf("(mcg)") > -1)
        		return "micrograma";
        	else if(text.indexOf("(mg)") > -1)
        		return "miligrama";
        	else if(text.indexOf("(kcal)") > -1)
        		return "kilocaloria";
        	else if(text.indexOf("(kJ)") > -1)
        		return "kilojoule";
        	else if(text.indexOf("(%)") > -1)
        		return "%";
        	else if(text == "NA")
        		return "Não aplicável";
        	else if(text == "Tr")
        		return "Traço: Valores de nutrientes arredondados para números que caiam entre 0 e 0,5, com uma casa decimal que caiam entre 0 e 0,05, ";
        	else if(text == "-")
        		return "Análise não realizada";
        	else if(text == "*")
        		return "Análise serão reavaliadas";
        	else 
        		return "";
        },
        isNumber: function(text) {
        	return !isNaN(text);
        }
    };
});
