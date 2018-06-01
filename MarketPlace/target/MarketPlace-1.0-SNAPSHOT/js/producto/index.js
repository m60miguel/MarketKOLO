(function ($) {
    $(document).ready(function () {
        console.log("Inicia");
        if (sessionStorage.getItem("pagina") == null || sessionStorage.getItem("pagina") == 0) {
            sessionStorage.setItem("pagina", 1);
            console.log(sessionStorage.getItem("pagina"));
        }

        var divProducto = '<div class="column">' +
                '<div class="product-card">' +
                '<div class="product-card-thumbnail">' +
                '<a href="#"><img src="https://placehold.it/180x180"/></a>' +
                '</div>' +
                '<h2 class="product-card-title"><a href="#">${nombreProducto}</a></h2>' +
                '<span class="product-card-desc">${marcaProducto}</span>' +
                '<span class="product-card-price">${valorProducto}</span><span class="product-card-sale">$12.99</span>' +
                '</div>' +
                '</div>';
        $("#grid-products").empty();
        $.ajax({
            url: '/MarketPlace/api/productos',
            method: 'GET',
            contentType: 'application/json',
            dataType: 'json'
        }).done(function (data) {
            console.log(data);
            var dataProductos = new Array();
            var rango = Math.floor((data.length - 1) / 9);
            sessionStorage.setItem("numPaginas", rango + 1);
            var pagina = parseInt(sessionStorage.getItem("pagina"));
            var allPag = rango + 1;
            rango = rango + pagina;
            document.getElementById("totalPaginas").innerHTML = allPag;
            document.getElementById("numPg").innerHTML = sessionStorage.getItem("pagina");
            sessionStorage.setItem("numPaginas", allPag);
            var max = ((pagina - 1) * 9)
            for (var i = max; i < (9 + max); i++) {
                if (i < data.length) {
                    dataProductos.push(data[i]);
                }
            }
            $.each(dataProductos, function (index, producto) {
                $.template("divProducto", divProducto);
                $.tmpl("divProducto", producto).appendTo("#grid-products");

            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });
})(jQuery);
        