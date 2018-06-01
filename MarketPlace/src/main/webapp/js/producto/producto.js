/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function ($){
    $(document).ready(function (event){
        $.ajax({
            url: '/MarketPlace/api/productos',
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function(data) {
            console.log(data);
            for(var i=0; i<data.length; i++){
                var tableRow = $('<tr>');
                //<td>: Cada division de la tabla
                var nombreProducto = $('<td>');
                nombreProducto.text(data[i].nombreProducto);
                var marcaProducto = $('<td>');
                marcaProducto.text(data[i].marcaProducto);
                var valorProducto = $('<td>');
                valorProducto.text(data[i].valorProducto);
                var garantiaProducto = $('<td>');
                garantiaProducto.text(data[i].garantiaProducto);
                var imagenProducto = $('<td>');
                imagenProducto.text(data[i].imagenProducto);
                var tipoProducto = $('<td>');
                tipoProducto.text(data[i].tipoProducto);
                var acciones = $('<td>');
                
                var botonEliminar = $('<button>').addClass('button alert');
                botonEliminar.text('Eliminar').attr('data-id', data[i].idProducto);
                botonEliminar.click(eliminar);
                
                var botonActualizar = $('<a href="/MarketPlace/crearProducto.html?id='+data[i].idProducto+'">').addClass('button success');
                botonActualizar.text('Actualizar');
                
                acciones.append(botonActualizar);
                acciones.append(botonEliminar);
                
                tableRow.append(nombreProducto);
                tableRow.append(marcaProducto);
                tableRow.append(valorProducto);
                tableRow.append(garantiaProducto);
                tableRow.append(imagenProducto);
                tableRow.append(tipoProducto);

                tableRow.append(acciones);

                $('#tablaProductos table tbody').append(tableRow);
            }
        }).fail(function (xhr, status, error){
           console.log(error);
        });
    });
    
    function eliminar(event){
        $.ajax({
            url: '/MarketPlace/api/productos/'+$(this).attr('data-id'),
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