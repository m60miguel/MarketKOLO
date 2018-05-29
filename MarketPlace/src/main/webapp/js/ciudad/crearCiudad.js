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
            url: '/MarketPlace/api/ciudades/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var codigo = $('#cityCod').val(data.codigoCiudad);
            var nombre = $('#cityName').val(data.nombreCiudad);
            var pais = $('#countryCode').val(data.paisId);
            var id = data.idCiudad;

            $('#botonCrear').text('Actualizar Ciudad').click(function (event) {
                var codigo = $('#cityCod').val();
                var nombre = $('#cityName').val();
                var pais = $('#countryCode').val();

                $.ajax({
                    url: '/MarketPlace/api/ciudades/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        codigoCiudad: codigo,
                        nombreCiudad: nombre,
                        pais: pais,
                        idCiudad: id
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    window.location.href = './editarCiudad.html';
                }).fail(function (xhr, status, error) {
                    console.log(error);
                });
            });
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {
        $('#botonCrear').click(function (event) {
            var codigo = $('#cityCod').val();
            var nombre = $('#cityName').val();
            var pais = $('#countryCode').val();
            $.ajax({
                url: '/MarketPlace/api/ciudades/',
                contentType: 'application/json',
                data: JSON.stringify({
                    codigoCiudad: codigo,
                        nombreCiudad: nombre,
                        pais: pais
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = './editarCiudad.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    };
    $.ajax({
        url: '/MarketPlace/api/paises',
        contentType: 'application/json',
        method: 'GET',
        dataType: 'json'
    }).done(function (data) {
        console.log(data);
        for (var i = 0; i < data.length; i++) {
            /*<option value="">Seleccione Proveedor</option>    */
            var options = '<option value="' + data[i].idPais + '">' + data[i].nombrePais + '</option>';
            $('#countryCode').append(options);
        }
    }).fail(function (xhr, status, error) {
        console.log(error);
    });
})(jQuery);