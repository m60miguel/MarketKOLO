(function ($) {
    var getUrlParameter = function getUrlParameter(sParam) {
        var sPageUrl = decodeURIComponent(window.location.search.substring(1)),
                sURLVariables = sPageUrl.split('&'),
                sParameterName,
                i;
        for (var i = 0; i < sURLVariables.length; i++) {
            sParameterName = sURLVariables[i].split('=');
            if (sParameterName[0] === sParam) {
                return sParameterName[1] === undefined ? true : sParameterName[1];
            }
        }
    };
    var muestraProducto = '<table>' +
            '<tbody>' +
            '<tr>' +
            '<td rowspan="7" width="300" nowrap align="center"><img src="${imagenProducto}" height="400" width="400"></td>' +
            '<td rowspan="7" width="20" nowrap></td>' +
            '<td colspan="2" align="center"><h2>${nombreProducto}</h2></td>' +
            '</tr>' +
            '<tr></tr>' +
            '<tr>' +
            '<td><h4>Marca: </h4></td>' +
            '<td><h4>${marcaProducto}</h4></td>' +
            '</tr>' +
            '<tr>' +
            '<td><h5>Tipo:</h5></td>' +
            '<td><h5>${tipoProducto}</h5></td>' +
            '</tr>' +
            '<tr>' +
            '<td><h6>Garantia:</h6></td>' +
            '<td><h6>${garantiaProducto} meses</h6></td>' +
            '</tr>' +
            '<tr></tr>' +
            '<tr>' +
            '<td colspan="2" align="left"><h2 style="color: #0033ff">$ ${valorProducto}</h2></td>' +
            '</tr>' +
            '</tbody>' +
            '</table>';
    if (getUrlParameter('id')) {
        $.ajax({
            url: '/MarketPlace/api/productos/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            console.log(data);
            $.template("divProducto", muestraProducto);
            $.tmpl("divProducto", data).appendTo("#datapr");
        });
    }
})(jQuery);