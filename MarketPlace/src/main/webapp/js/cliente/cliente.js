/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function ($) {
    $(document).ready(function (event) {
        $.ajax({
            url: '/MarketPlace/api/clientes',
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            console.log(data);
            for (var i = 0; i < data.length; i++) {
                var tableRow = $('<tr>');
                //<td>: Cada division de la tabla
                var nombreCliente = $('<td>');
                nombreCliente.text(data[i].nombreCliente);
                var apellidoCliente = $('<td>');
                apellidoCliente.text(data[i].apellidoCliente);
                var tDocCliente = $('<td>');
                tDocCliente.text(data[i].tDocCliente);
                var nDocCliente = $('<td>');
                nDocCliente.text(data[i].nDocCliente);
                var fechaNacCliente = $('<td>');
                fechaNacCliente.text(data[i].fechaNacCliente);
                var usuarioCliente = $('<td>');
                usuarioCliente.text(data[i].usuarioCliente);
                var passCliente = $('<td>');
                passCliente.text('******');
                var direccionCliente = $('<td>');
                direccionCliente.text(data[i].direccionCliente);
                var telefonoCliente = $('<td>');
                telefonoCliente.text(data[i].telefonoCliente);
                var emailCliente = $('<td>');
                emailCliente.text(data[i].emailCliente);
                var avatarCliente = $('<td><img src="' + data[i].avatarCliente + '" height="100" width="100">');
                var ciudad = $('<td>');
                ciudad.text(data[i].ciudad);
                var acciones = $('<td>');

                var botonEliminar = $('<button>').addClass('button alert');
                botonEliminar.text('Eliminar').attr('data-id', data[i].idCliente);
                botonEliminar.click(eliminar);

                var botonActualizar = $('<a href="/MarketPlace/crearCliente.html?id=' + data[i].idCliente + '">').addClass('button success');
                botonActualizar.text('Actualizar');

                acciones.append(botonActualizar);
                acciones.append(botonEliminar);

                tableRow.append(nombreCliente);
                tableRow.append(apellidoCliente);
                tableRow.append(tDocCliente);
                tableRow.append(nDocCliente);
                tableRow.append(fechaNacCliente);
                tableRow.append(ciudad);
                tableRow.append(direccionCliente);
                tableRow.append(telefonoCliente);
                tableRow.append(emailCliente);
                tableRow.append(usuarioCliente);
                tableRow.append(passCliente);
                tableRow.append(avatarCliente);

                tableRow.append(acciones);

                tableRow.append(acciones);

                $('#tablaClientes table tbody').append(tableRow);
            }
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });

    function eliminar(event) {
        $.ajax({
            url: '/MarketPlace/api/clientes/' + $(this).attr('data-id'),
            contentType: 'application/json',
            method: 'DELETE',
            dataType: 'json'
        }).done(function (data) {
            console.log("Elemento Eliminado");
            window.location.reload();
        }).fail(function (xhr, status, error) {
            console.log("Error");
        });
    }
})(jQuery);