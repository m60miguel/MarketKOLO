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
                '<a href="#"><img src="${imagenProducto}" height="200" width="200"/></a>' +
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
            var rango = Math.floor((data.length - 1) / 8);
            sessionStorage.setItem("numPaginas", rango + 1);
            var pagina = parseInt(sessionStorage.getItem("pagina"));
            var allPag = rango + 1;
            rango = rango + pagina;
            document.getElementById("totalPaginas").innerHTML = allPag;
            document.getElementById("numPg").innerHTML = sessionStorage.getItem("pagina");
            sessionStorage.setItem("numPaginas", allPag);
            var max = ((pagina - 1) * 8)
            for (var i = max; i < (8 + max); i++) {
                if (i < data.length) {
                    dataProductos.push(data[i]);
                }
            }
            var gridproducts = $("#grid-products1");
            var counter = 0;
            $.each(dataProductos, function (index, producto) {
                $.template("divProducto", divProducto);
                $.tmpl("divProducto", producto).appendTo(gridproducts);
                counter = counter + 1;
                if (counter == 4) {
                    gridproducts = $("#grid-products2");
                }
            }).fail(function (xhr, status, error) {
                console.log(error);
            });
        }).fail(function (xhr, status, error) {
            console.log(error);
        });
    });
    function mod(n, m) {
        return ((n % m) + m) % m;
    }
})(jQuery);
        