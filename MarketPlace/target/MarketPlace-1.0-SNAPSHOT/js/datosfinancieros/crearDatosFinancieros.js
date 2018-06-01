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
            var proveedor = $('#provCode').val(data.proveedorId);
            var id = data.iddFinancieros;

            $('#botonCrear').text('Actualizar DatosFinancieros').click(function (event) {
                var ventas = $('#annualsales').val();
                var mercado = $('#market').val();
                var nivel = $('#level').val();
                var proveedor = $('#provCode').val();

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
            var proveedor = $('#provCode').val();
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
    };
    $.ajax({
        url: '/MarketPlace/api/proveedores',
        contentType: 'application/json',
        method: 'GET',
        dataType: 'json'
    }).done(function (data) {
        console.log(data);
        for (var i = 0; i < data.length; i++) {
            /*<option value="">Seleccione Proveedor</option>    */
            var options = '<option value="' + data[i].idProveedor + '">' + data[i].nombreProvvedor + '</option>';
            $('#provCode').append(options);
        }
    }).fail(function (xhr, status, error) {
        console.log(error);
    });
})(jQuery);