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
            url: '/MarketPlace/api/envios/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var direccion = $('#shippingaddress').val(data.direccionEnvio);
            var ciudad = $('#cityCode').val(data.ciudadId);
            var id = data.idEnvio;

            $('#botonCrear').text('Actualizar Envio').click(function (event) {
                var direccion = $('#shippingaddress').val();
                var ciudad = $('#cityCode').val();

                $.ajax({
                    url: '/MarketPlace/api/envios/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        direccionEnvio: direccion,
                        ciudad: ciudad,
                        idEnvio: id
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    window.location.href = './editarEnvio.html';
                }).fail(function (xhr, status, error) {
                    console.log(error);
                });
            });
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {
        $('#botonCrear').click(function (event) {
            var direccion = $('#shippingaddress').val();
            var ciudad = $('#cityCode').val();
            $.ajax({
                url: '/MarketPlace/api/envios/',
                contentType: 'application/json',
                data: JSON.stringify({
                    direccionEnvio: direccion,
                    ciudad: ciudad
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = './editarEnvio.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    };
    $.ajax({
        url: '/MarketPlace/api/ciudades',
        contentType: 'application/json',
        method: 'GET',
        dataType: 'json'
    }).done(function (data) {
        console.log(data);
        for (var i = 0; i < data.length; i++) {
            /*<option value="">Seleccione Proveedor</option>    */
            var options = '<option value="' + data[i].idCiudad + '">' + data[i].nombreCiudad + '</option>';
            $('#cityCode').append(options);
        }
    }).fail(function (xhr, status, error) {
        console.log(error);
    });
})(jQuery);