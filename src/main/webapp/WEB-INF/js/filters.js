app.filter('orderByNumber', function () {
    return function (number) {
        var newOrderByNumber;
        for (var i = 0; i < Object.keys(number).length; i++) {
        	console.log(number[i]);
            newOrderByNumber = Object.keys(number).sort(function (a, b) {
                return parseFloat(a.booth.slice(1)) - parseFloat(b.booth.slice(1));
            });
        }
        return newOrderByNumber;
    };
});