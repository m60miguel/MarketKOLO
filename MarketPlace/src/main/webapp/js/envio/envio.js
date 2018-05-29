/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function ($){
    $(document).ready(function (event){
        $.ajax({
            url: '/MarketPlace/api/envios',
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function(data) {
            console.log(data);
            for(var i=0; i<data.length; i++){
                var tableRow = $('<tr>');
                //<td>: Cada division de la tabla
                var direccionEnvio = $('<td>');
                direccionEnvio.text(data[i].direccionEnvio);
                var ciudad = $('<td>');
                ciudad.text(data[i].ciudad);
                var acciones = $('<td>');
                
                var botonEliminar = $('<button>').addClass('button alert');
                botonEliminar.text('Eliminar').attr('data-id', data[i].idEnvio);
                botonEliminar.click(eliminar);
                
                var botonActualizar = $('<a href="/MarketPlace/crearEnvio.html?id='+data[i].idEnvio+'">').addClass('button success');
                botonActualizar.text('Actualizar');
                
                acciones.append(botonActualizar);
                acciones.append(botonEliminar);
                
                tableRow.append(ciudad);
                tableRow.append(direccionEnvio);

                tableRow.append(acciones);

                $('#tablaEnvios table tbody').append(tableRow);
            }
        }).fail(function (xhr, status, error){
           console.log(error);
        });
    });
    
    function eliminar(event){
        $.ajax({
            url: '/MarketPlace/api/envios/'+$(this).attr('data-id'),
            contentType: 'application/json',
            method: 'DELETE',
            dataType: 'json'
        }).done(function (data){
            console.log("Elemento Eliminado");
            window.location.reload();
        }).fail(function (xhr, status, error){
            console.log("Error");
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