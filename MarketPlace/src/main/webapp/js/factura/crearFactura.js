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
            var cliente = $('#nameCode').val(data.clienteId);
            var producto = $('#prodCode').val(data.productoId);
            var canCompra = $('#quantity').val(data.cantidadCompra);
            var fecCompra = $('#date').val(data.fechaCompra);
            var id = data.idFactura;

            $('#botonCrear').text('Actualizar Factura').click(function (event) {
                var cliente = $('#nameCode').val();
                var producto = $('#prodCode').val();
                var canCompra = $('#quantity').val();
                var fecCompra = $('#date').val();

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
            var cliente = $('#nameCode').val();
            var producto = $('#prodCode').val();
            var canCompra = $('#quantity').val();
            var fecCompra = $('#date').val();
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
    ;
    $.ajax({
        url: '/MarketPlace/api/clientes',
        contentType: 'application/json',
        method: 'GET',
        dataType: 'json'
    }).done(function (data) {
        console.log(data);
        for (var i = 0; i < data.length; i++) {
            /*<option value="">Seleccione Proveedor</option>    */
            var options = '<option value="' + data[i].idCliente + '">' + data[i].nombreCliente + '</option>';
            $('#nameCode').append(options);
        }
    }).fail(function (xhr, status, error) {
        console.log(error);
    });
    $.ajax({
        url: '/MarketPlace/api/productos',
        contentType: 'application/json',
        method: 'GET',
        dataType: 'json'
    }).done(function (data) {
        console.log(data);
        for (var i = 0; i < data.length; i++) {
            /*<option value="">Seleccione Proveedor</option>    */
            var options = '<option value="' + data[i].idProducto + '">' + data[i].nombreProducto + '</option>';
            $('#prodCode').append(options);
        }
    }).fail(function (xhr, status, error) {
        console.log(error);
    });
})(jQuery);