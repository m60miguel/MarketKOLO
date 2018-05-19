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
            url: '/MarketPlace/api/evaluaciones/' + getUrlParameter('id'),
            contentType: 'application/json',
            method: 'GET',
            dataType: 'json'
        }).done(function (data) {
            var calificacion = $('#rating').val(data.calificacionEvaluacion);
            var comentario = $('#comment').val(data.comentarioEvaluacion);
            var producto = $('#productkey').val(data.producto);
            var id = data.idEvaluacion;

            $('#botonCrear').text('Actualizar Evaluacion').click(function (event) {
                var calificacion = $('#rating').val();
                var comentario = $('#comment').val();
                var producto = $('#productkey').val();

                $.ajax({
                    url: '/MarketPlace/api/evaluaciones/' + id,
                    contentType: 'application/json',
                    data: JSON.stringify({
                        calificacionEvaluacion: calificacion,
                        comentarioEvaluacion: comentario,
                        producto: producto,
                        idEvaluacion: id
                    }),
                    method: 'PUT',
                    dataType: 'json'
                }).done(function (data) {
                    window.location.href = './editarEvaluacion.html';
                }).fail(function (xhr, status, error) {
                    console.log(error);
                });
            });
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    } else {
        $('#botonCrear').click(function (event) {
            var calificacion = $('#rating').val();
            var comentario = $('#comment').val();
            var producto = $('#productkey').val();
            $.ajax({
                url: '/MarketPlace/api/evaluaciones/',
                contentType: 'application/json',
                data: JSON.stringify({
                    calificacionEvaluacion: calificacion,
                    comentarioEvaluacion: comentario,
                    producto: producto
                }),
                method: 'POST',
                dataType: 'json'
            }).done(function (data) {
                window.location.href = './editarEvaluacion.html';
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        });
    }
})(jQuery);