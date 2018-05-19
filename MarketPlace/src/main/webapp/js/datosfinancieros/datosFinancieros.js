/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function ($){
    $(document).ready(function (event){
        $.ajax({
            url: '/MarketPlace/api/datosfinancieros',
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function(data) {
            console.log(data);
            for(var i=0; i<data.length; i++){
                var tableRow = $('<tr>');
                //<td>: Cada division de la tabla
                var ventasAnuales = $('<td>');
                ventasAnuales.text(data[i].ventasAnuales);
                var mercadoObjetivo = $('<td>');
                mercadoObjetivo.text(data[i].mercadoObjetivo);
                var nivelReputacion = $('<td>');
                nivelReputacion.text(data[i].nivelReputacion);
                var proveedor = $('<td>');
                proveedor.text(data[i].proveedor);
                var acciones = $('<td>');
                
                var botonEliminar = $('<button>').addClass('button alert');
                botonEliminar.text('Eliminar').attr('data-id', data[i].iddFinancieros);
                botonEliminar.click(eliminar);
                
                var botonActualizar = $('<a href="/MarketPlace/crearDatosFinancieros.html?id='+data[i].iddFinancieros+'">').addClass('button success');
                botonActualizar.text('Actualizar');
                
                acciones.append(botonActualizar);
                acciones.append(botonEliminar);
                
                tableRow.append(ventasAnuales);
                tableRow.append(mercadoObjetivo);
                tableRow.append(nivelReputacion);
                tableRow.append(proveedor);

                tableRow.append(acciones);

                $('#tablaDatosFinancieros table tbody').append(tableRow);
            }
        }).fail(function (xhr, status, error){
           console.log(error);
        });
    });
    
    function eliminar(event){
        $.ajax({
            url: '/MarketPlace/api/datosfinancieros/'+$(this).attr('data-id'),
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