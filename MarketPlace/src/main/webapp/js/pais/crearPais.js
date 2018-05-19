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
            url: '/MarketPlace/api/paises/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var codigo = $('#code').val(data.codigoPais);
            var nombre = $('#name').val(data.nombrePais);
            var id = data.idPais;

            $('#botonCrear').text('Actualizar Pais').click(function (event) {
                var codigo = $('#code').val();
                var nombre = $('#name').val();

                $.ajax({
                    url: '/MarketPlace/api/paises/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        codigoPais: codigo,
                        nombrePais: nombre,
                        idPais: id
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    window.location.href = './editarPais.html';
                }).fail(function (xhr, status, error) {
                    console.log(error);
                });
            });
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {
        $('#botonCrear').click(function (event) {
            var codigo = $('#code').val();
            var nombre = $('#name').val();
            $.ajax({
                url: '/MarketPlace/api/paises/',
                contentType: 'application/json',
                data: JSON.stringify({
                    codigoPais: codigo,
                    nombrePais: nombre,
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = './editarPais.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);


