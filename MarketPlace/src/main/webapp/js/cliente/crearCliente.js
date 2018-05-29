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
            url: '/MarketPlace/api/clientes/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var nombre = $('#name').val(data.nombreCliente);
            var apellido = $('#surname').val(data.apellidoCliente);
            var documento = $('#tDoc').val(data.tDocCliente);
            var numero = $('#nDoc').val(data.nDocCliente);
            var fecNac = $('#birth').val(data.fechaNacCliente);
            var usuario = $('#user').val(data.usuarioCliente);
            var pass = $('#pass').val(data.passCliente);
            var direccion = $('#address').val(data.direccionCliente);
            var telefono = $('#phone').val(data.telefonoCliente);
            var email = $('#email').val(data.emailCliente);
            var avatar = $('#avatar').val(data.avatarCliente);
            var ciudad = $('#cityCode').val(data.ciudadId);
            var id = data.idCliente;

            $('#botonCrear').text('Actualizar Cliente').click(function (event) {
                var nombre = $('#name').val();
                var apellido = $('#surname').val();
                var documento = $('#tDoc').val();
                var numero = $('#nDoc').val();
                var fecNac = $('#birth').val();
                var usuario = $('#user').val();
                var pass = $('#pass').val();
                var direccion = $('#address').val();
                var telefono = $('#phone').val();
                var email = $('#email').val();
                var avatar = $('#avatar').val();
                var ciudad = $('#cityCode').val();

                $.ajax({
                    url: '/MarketPlace/api/clientes/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        nombreCliente: nombre,
                        apellidoCliente: apellido,
                        tDocCliente: documento,
                        nDocCliente: numero,
                        fechaNacCliente: fecNac,
                        usuarioCliente: usuario,
                        passCliente: pass,
                        direccionCliente: direccion,
                        telefonoCliente: telefono,
                        emailCliente: email,
                        avatarCliente: avatar,
                        ciudad: ciudad,
                        idCliente: id
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    window.location.href = './editarCliente.html';
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
            var apellido = $('#surname').val();
            var documento = $('#tDoc').val();
            var numero = $('#nDoc').val();
            var fecNac = $('#birth').val();
            var usuario = $('#user').val();
            var pass = $('#pass').val();
            var direccion = $('#address').val();
            var telefono = $('#phone').val();
            var email = $('#email').val();
            var avatar = $('#avatar').val();
            var ciudad = $('#cityCode').val();
            $.ajax({
                url: '/MarketPlace/api/clientes/',
                contentType: 'application/json',
                data: JSON.stringify({
                    nombreCliente: nombre,
                        apellidoCliente: apellido,
                        tDocCliente: documento,
                        nDocCliente: numero,
                        fechaNacCliente: fecNac,
                        usuarioCliente: usuario,
                        passCliente: pass,
                        direccionCliente: direccion,
                        telefonoCliente: telefono,
                        emailCliente: email,
                        avatarCliente: avatar,
                        ciudad: ciudad
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = './editarCliente.html';
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