/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function ($){
    $(document).ready(function (event){
        $.ajax({
            url: '/MarketPlace/api/proveedores',
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function(data) {
            console.log(data);
            for(var i=0; i<data.length; i++){
                var tableRow = $('<tr>');
                //<td>: Cada division de la tabla
                var nitProveedor = $('<td>');
                nitProveedor.text(data[i].nitProveedor);
                var nombreProveedor = $('<td>');
                nombreProveedor.text(data[i].nombreProveedor);
                var usuarioProveedor = $('<td>');
                usuarioProveedor.text(data[i].usuarioProveedor);
                var passProveedor = $('<td>');
                passProveedor.text(data[i].passProveedor);
                var avatarProveedor = $('<td>');
                avatarProveedor.text(data[i].avatarProveedor);
                var acciones = $('<td>');
                
                var botonEliminar = $('<button>').addClass('button alert');
                botonEliminar.text('Eliminar').attr('data-id', data[i].idProveedor);
                botonEliminar.click(eliminar);
                
                var botonActualizar = $('<a href="/MarketPlace/crearProveedor.html?id='+data[i].idProveedor+'">').addClass('button success');
                botonActualizar.text('Actualizar');
                
                acciones.append(botonActualizar);
                acciones.append(botonEliminar);
                
                tableRow.append(nitProveedor);
                tableRow.append(nombreProveedor);
                tableRow.append(usuarioProveedor);
                tableRow.append(passProveedor);
                tableRow.append(avatarProveedor);
                tableRow.append(acciones);

                $('#tablaProveedores table tbody').append(tableRow);
            }
        }).fail(function (xhr, status, error){
           console.log(error);
        });
    });
    
    function eliminar(event){
        $.ajax({
            url: '/MarketPlace/api/proveedores/'+$(this).attr('data-id'),
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