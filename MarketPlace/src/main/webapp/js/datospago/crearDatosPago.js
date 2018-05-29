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
            url: '/MarketPlace/api/datospago/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var nombre = $('#name').val(data.nombreBanco);
            var cuenta = $('#account').val(data.nroCuenta);
            var franquicia = $('#franchise').val(data.franquiciaBanco);
            var tarjeta = $('#card').val(data.nroTarjeta);
            var codCla = $('#keycode').val(data.codClave);
            var cliente = $('#nameCode').val(data.clienteId);
            var tipoPago = $('#tPayCode').val(data.tipoPagoId);
            var id = data.idFactura;

            $('#botonCrear').text('Actualizar Factura').click(function (event) {
                var nombre = $('#name').val();
                var cuenta = $('#account').val();
                var franquicia = $('#franchise').val();
                var tarjeta = $('#card').val();
                var codCla = $('#keycode').val();
                var cliente = $('#nameCode').val();
                var tipoPago = $('#tPayCode').val();

                $.ajax({
                    url: '/MarketPlace/api/datospago/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        nombreBanco: nombre,
                        nroCuenta: cuenta,
                        franquiciaBanco: franquicia,
                        nroTarjeta: tarjeta,
                        codClave: codCla,
                        cliente: cliente,
                        tipoPago: tipoPago,
                        idFactura: id
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    window.location.href = './editarDatosPago.html';
                }).fail(function (xhr, status, error) {
                    console.log(error);
                });
            });
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {
        $('#botonCrear').click(function (event) {
            var nombre = $('#name').val();
            var cuenta = $('#account').val();
            var franquicia = $('#franchise').val();
            var tarjeta = $('#card').val();
            var codCla = $('#keycode').val();
            var cliente = $('#nameCode').val();
            var tipoPago = $('#tPayCode').val();
            $.ajax({
                url: '/MarketPlace/api/datospago/',
                contentType: 'application/json',
                data: JSON.stringify({
                    nombreBanco: nombre,
                    nroCuenta: cuenta,
                    franquiciaBanco: franquicia,
                    nroTarjeta: tarjeta,
                    codClave: codCla,
                    cliente: cliente,
                    tipoPago: tipoPago
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = './editarDatosPago.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    };
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
        url: '/MarketPlace/api/tipospago',
        contentType: 'application/json',
        method: 'GET',
        dataType: 'json'
    }).done(function (data) {
        console.log(data);
        for (var i = 0; i < data.length; i++) {
            /*<option value="">Seleccione Proveedor</option>    */
            var options = '<option value="' + data[i].idTPago + '">' + data[i].nombreTPago + '</option>';
            $('#tPayCode').append(options);
        }
    }).fail(function (xhr, status, error) {
        console.log(error);
    });
})(jQuery);