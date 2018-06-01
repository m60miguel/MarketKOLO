/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function ($){
    $(document).ready(function (event){
        $.ajax({
            url: '/MarketPlace/api/datospago',
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function(data) {
            console.log(data);
            for(var i=0; i<data.length; i++){
                var tableRow = $('<tr>');
                //<td>: Cada division de la tabla
                var nombreBanco = $('<td>');
                nombreBanco.text(data[i].nombreBanco);
                var nroCuenta = $('<td>');
                nroCuenta.text(data[i].nroCuenta);
                var franquiciaBanco = $('<td>');
                franquiciaBanco.text(data[i].franquiciaBanco);
                var nroTarjeta = $('<td>');
                nroTarjeta.text(data[i].nroTarjeta);
                var codClave = $('<td>');
                codClave.text(data[i].codClave);
                var cliente = $('<td>');
                cliente.text(data[i].cliente);
                var tipoPago = $('<td>');
                tipoPago.text(data[i].tipoPago);
                var acciones = $('<td>');
                
                var botonEliminar = $('<button>').addClass('button alert');
                botonEliminar.text('Eliminar').attr('data-id', data[i].idDatosPago);
                botonEliminar.click(eliminar);
                
                var botonActualizar = $('<a href="/MarketPlace/crearDatosPago.html?id='+data[i].idDatosPago+'">').addClass('button success');
                botonActualizar.text('Actualizar');
                
                acciones.append(botonActualizar);
                acciones.append(botonEliminar);
                
                tableRow.append(nombreBanco);
                tableRow.append(nroCuenta);
                tableRow.append(franquiciaBanco);
                tableRow.append(nroTarjeta);
                tableRow.append(codClave);
                tableRow.append(cliente);
                tableRow.append(tipoPago);

                tableRow.append(acciones);

                $('#tablaDatosPago table tbody').append(tableRow);
            }
        }).fail(function (xhr, status, error){
           console.log(error);
        });
    });
    
    function eliminar(event){
        $.ajax({
            url: '/MarketPlace/api/datospago/'+$(this).attr('data-id'),
            contentType: 'application/json',
            method: 'DELETE',
            dataType: 'json'
        }).done(function (data){
            console.log("Elemento Eliminado");
            window.location.reload();
        }).fail(function (xhr, status, error){
            console.log("Error");
        });
    }
})(jQuery);