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
            url: '/MarketPlace/api/datosfinancieros/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var ventas = $('#annualsales').val(data.ventasAnuales);
            var mercado = $('#market').val(data.mercadoObjetivo);
            var nivel = $('#level').val(data.nivelReputacion);
            var proveedor = $('#providercode').val(data.proveedor);
            var id = data.iddFinancieros;

            $('#botonCrear').text('Actualizar DatosFinancieros').click(function (event) {
                var ventas = $('#annualsales').val();
                var mercado = $('#market').val();
                var nivel = $('#level').val();
                var proveedor = $('#providercode').val();

                $.ajax({
                    url: '/MarketPlace/api/datosfinancieros/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        ventasAnuales: ventas,
                        mercadoObjetivo: mercado,
                        nivelReputacion: nivel,
                        proveedor: proveedor,
                        iddFinancieros: id
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    window.location.href = './editarDatosFinancieros.html';
                }).fail(function (xhr, status, error) {
                    console.log(error);
                });
            });
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {
        $('#botonCrear').click(function (event) {
            var ventas = $('#annualsales').val();
            var mercado = $('#market').val();
            var nivel = $('#level').val();
            var proveedor = $('#providercode').val();
            $.ajax({
                url: '/MarketPlace/api/datosfinancieros/',
                contentType: 'application/json',
                data: JSON.stringify({
                    ventasAnuales: ventas,
                    mercadoObjetivo: mercado,
                    nivelReputacion: nivel,
                    proveedor: proveedor
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = './editarDatosFinancieros.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);