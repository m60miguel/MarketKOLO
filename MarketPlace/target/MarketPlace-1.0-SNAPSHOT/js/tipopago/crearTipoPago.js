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
            url: '/MarketPlace/api/tipospago/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var tipoPago = $('#tpay').val(data.nombreTPago);
            var id = data.idTPago;

            $('#botonCrear').text('Actualizar Tipo Pago').click(function (event) {
                var tipoPago = $('#tpay').val();

                $.ajax({
                    url: '/MarketPlace/api/tipospago/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        nombreTPago: tipoPago,
                        idTPago: id
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    window.location.href = './editarTipoPago.html';
                }).fail(function (xhr, status, error) {
                    console.log(error);
                });
            });
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {
        $('#botonCrear').click(function (event) {
            var tipoPago = $('#tpay').val();
            $.ajax({
                url: '/MarketPlace/api/tipospago/',
                contentType: 'application/json',
                data: JSON.stringify({
                    nombreTPago: tipoPago
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = './editarTipoPago.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);