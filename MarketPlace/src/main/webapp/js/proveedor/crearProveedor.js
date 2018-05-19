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
            url: '/MarketPlace/api/proveedores/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var nit = $('#nit').val(data.nitProveedor);
            var nombre = $('#name').val(data.nombreProveedor);
            var usuario = $('#user').val(data.usuarioProveedor);
            var pass = $('#pass').val(data.passProveedor);
            var avatar = $('#avatar').val(data.avatarProveedor);
            var id = data.idProveedor;

            $('#botonCrear').text('Actualizar Proveedor').click(function (event) {
                var nit = $('#nit').val();
                var nombre = $('#name').val();
                var usuario = $('#user').val();
                var pass = $('#pass').val();
                var avatar = $('#avatar').val();

                $.ajax({
                    url: '/MarketPlace/api/proveedores/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        nitProveedor: nit,
                        nombreProveedor: nombre,
                        usuarioProveedor: usuario,
                        passProveedor: pass,
                        avatarProveedor: avatar,
                        idProveedor: id
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    window.location.href = './editarProveedor.html';
                }).fail(function (xhr, status, error) {
                    console.log(error);
                });
            });
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {
        $('#botonCrear').click(function (event) {
            var nit = $('#nit').val();
            var nombre = $('#name').val();
            var usuario = $('#user').val();
            var pass = $('#pass').val();
            var avatar = $('#avatar').val();
            $.ajax({
                url: '/MarketPlace/api/proveedores/',
                contentType: 'application/json',
                data: JSON.stringify({
                    nitProveedor: nit,
                    nombreProveedor: nombre,
                    usuarioProveedor: usuario,
                    passProveedor: pass,
                    avatarProveedor: avatar
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = './editarProveedor.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);


