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
            url: '/MarketPlace/api/tiposproducto/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var nombre = $('#tProduct').val(data.nombreTProducto);
            var descripcion = $('#description').val(data.descripcionTProducto);
            var id = data.idTProducto;

            $('#botonCrear').text('Actualizar Tipo Producto').click(function (event) {
                var nombre = $('#tProduct').val();
                var descripcion = $('#description').val();

                $.ajax({
                    url: '/MarketPlace/api/tiposproducto/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        nombreTProducto: nombre,
                        descripcionTProducto: descripcion,
                        idTProducto: id
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    window.location.href = './editarTipoProducto.html';
                }).fail(function (xhr, status, error) {
                    console.log(error);
                });
            });
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {
        $('#botonCrear').click(function (event) {
            var nombre = $('#tProduct').val();
            var descripcion = $('#description').val();
            $.ajax({
                url: '/MarketPlace/api/tiposproducto/',
                contentType: 'application/json',
                data: JSON.stringify({
                    nombreTProducto: nombre,
                    descripcionTProducto: descripcion
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = './editarTipoProducto.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);