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
            url: '/MarketPlace/api/productos/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var nombre = $('#name').val(data.nombreProducto);
            var marca = $('#trademark').val(data.marcaProducto);
            var valor = $('#price').val(data.valorProducto);
            var garantia = $('#warranty').val(data.garantiaProducto);
            var tipo = $('#type').val(data.tipoProducto);
            var id = data.idProducto;

            $('#botonCrear').text('Actualizar Producto').click(function (event) {
                var nombre = $('#name').val();
                var marca = $('#trademark').val();
                var valor = $('#price').val();
                var garantia = $('#warranty').val();
                var tipo = $('#type').val();

                $.ajax({
                    url: '/MarketPlace/api/productos/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        nombreProducto: nombre,
                        marcaProducto: marca,
                        valorProducto: valor,
                        garantiaProducto: garantia,
                        tipoProducto: tipo,
                        idProducto: id
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    window.location.href = './editarProducto.html';
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
            var marca = $('#trademark').val();
            var valor = $('#price').val();
            var garantia = $('#warranty').val();
            var tipo = $('#type').val();
            $.ajax({
                url: '/MarketPlace/api/productos/',
                contentType: 'application/json',
                data: JSON.stringify({
                    nombreProducto: nombre,
                    marcaProducto: marca,
                    valorProducto: valor,
                    garantiaProducto: garantia,
                    tipoProducto: tipo
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = './editarProducto.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);

