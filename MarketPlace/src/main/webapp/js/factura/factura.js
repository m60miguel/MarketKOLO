/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function ($){
    $(document).ready(function (event){
        $.ajax({
            url: '/MarketPlace/api/facturas',
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function(data) {
            console.log(data);
            for(var i=0; i<data.length; i++){
                var tableRow = $('<tr>');
                //<td>: Cada division de la tabla
                var fechaCompra = $('<td>');
                fechaCompra.text(data[i].fechaCompra);
                var cantidadCompra = $('<td>');
                cantidadCompra.text(data[i].cantidadCompra);
                var cliente = $('<td>');
                cliente.text(data[i].clienteId);
                var producto = $('<td>');
                producto.text(data[i].producto);
                var acciones = $('<td>');
                
                var botonEliminar = $('<button>').addClass('button alert');
                botonEliminar.text('Eliminar').attr('data-id', data[i].idFactura);
                botonEliminar.click(eliminar);
                
                var botonActualizar = $('<a href="/MarketPlace/crearFactura.html?id='+data[i].idFactura+'">').addClass('button success');
                botonActualizar.text('Actualizar');
                
                acciones.append(botonActualizar);
                acciones.append(botonEliminar);
                
                tableRow.append(cliente);
                tableRow.append(producto);
                tableRow.append(cantidadCompra);
                tableRow.append(fechaCompra);

                tableRow.append(acciones);

                $('#tablaFacturas table tbody').append(tableRow);
            }
        }).fail(function (xhr, status, error){
           console.log(error);
        });
    });
    
    function eliminar(event){
        $.ajax({
            url: '/MarketPlace/api/facturas/'+$(this).attr('data-id'),
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