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
            url: '/MarketPlace/api/comunicaciones/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var tipoCom = $('#typeCom').val(data.tipoComunicacion);
            var desCom = $('#desCom').val(data.descripcionComunicacion);
            var proveedor = $('#provCode').val(data.proveedorId);
            var id = data.idComunicacion;

            $('#botonCrear').text('Actualizar Comunicacion').click(function (event) {
                var tipoCom = $('#typeCom').val();
                var desCom = $('#desCom').val();
                var proveedor = $('#provCode').val();

                $.ajax({
                    url: '/MarketPlace/api/comunicaciones/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        tipoComunicacion: tipoCom,
                        descripcionComunicacion: desCom,
                        proveedor: proveedor,
                        idComunicacion: id
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    window.location.href = './editarComunicacion.html';
                }).fail(function (xhr, status, error) {
                    console.log(error);
                });
            });
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {
        $('#botonCrear').click(function (event) {
            var tipoCom = $('#typeCom').val();
            var desCom = $('#desCom').val();
            var proveedor = $('#provCode').val();
            console.log(proveedor)
            $.ajax({
                url: '/MarketPlace/api/comunicaciones/',
                contentType: 'application/json',
                data: JSON.stringify({
                    tipoComunicacion: tipoCom,
                    descripcionComunicacion: desCom,
                    proveedor: proveedor
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = './editarComunicacion.html';
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
            var options = '<option value="' + data[i].idProveedor + '">' + data[i].nombreProveedor + '</option>';
            $('#provCode').append(options);
        }
    }).fail(function (xhr, status, error) {
        console.log(error);
    });
})(jQuery);