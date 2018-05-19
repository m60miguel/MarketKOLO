/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    if (getUrlParameter('id')) {
        $.ajax({
            url: '/MarketPlace/api/facturas/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var fecCompra = $('#date').val(data.fechaCompra);
            var canCompra = $('#quantity').val(data.cantidadCompra);
            var cliente = $('#client').val(data.cliente);
            var producto = $('#product').val(data.producto);
            var id = data.idFactura;

            $('#botonCrear').text('Actualizar Factura').click(function (event) {
                var fecCompra = $('#date').val();
                var canCompra = $('#quantity').val();
                var cliente = $('#client').val();
                var producto = $('#product').val();

                $.ajax({
                    url: '/MarketPlace/api/facturas/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        fechaCompra: fecCompra,
                        cantidadCompra: canCompra,
                        cliente: cliente,
                        producto: producto,
                        idFactura: id
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    window.location.href = './editarFactura.html';
                }).fail(function (xhr, status, error) {
                    console.log(error);
                });
            });
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {
        $('#botonCrear').click(function (event) {
            var fecCompra = $('#date').val();
            var canCompra = $('#quantity').val();
            var cliente = $('#client').val();
            var producto = $('#product').val();
            $.ajax({
                url: '/MarketPlace/api/facturas/',
                contentType: 'application/json',
                data: JSON.stringify({
                    fechaCompra: fecCompra,
                        cantidadCompra: canCompra,
                        cliente: cliente,
                        producto: producto
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = './editarFactura.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);