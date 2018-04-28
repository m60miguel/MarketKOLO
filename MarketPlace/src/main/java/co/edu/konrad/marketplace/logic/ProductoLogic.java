/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.logic;

import co.edu.konrad.marketplace.entities.ProductoEntity;
import co.edu.konrad.marketplace.persistence.ProductoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author DarkFACS
 */
@Stateless
public class ProductoLogic {
    
    /**
     * Inyeccion del Persistence de Producto
     */
    @Inject
    private ProductoPersistence productoPersistence;

    /**
     * Obtener Listado de Producto. Inyeccion del persistence de producto
     *
     * @return
     */
    public List<ProductoEntity> obtenerProductos() {
        List<ProductoEntity> productos = productoPersistence.findAll();
        return productos;
    }

    /**
     * Obtener un producto desde el Identificador (id)
     *
     * @param id
     * @return producto encontrado
     */
    public ProductoEntity obtenerProductoPorId(Long id) {
        ProductoEntity producto = productoPersistence.find(id);
        if (producto == null) {
            throw new IllegalArgumentException("El producto solicitado no existe");
        }
        return producto;
    }

    /**
     * Metodo utilizado para crear un Nuevo Producto
     *
     * @param producto
     * @return producto creado
     */
    public ProductoEntity crearProducto(ProductoEntity producto) {
        productoPersistence.create(producto);
        return producto;
    }

    /**
     * Actualizar un objeto Producto
     *
     * @param id
     * @param producto
     * @return producto actualizado
     */
    public ProductoEntity actualizarProducto(Long id, ProductoEntity producto) {
        ProductoEntity productoEntity = productoPersistence.update(producto);
        return productoEntity;
    }

    /**
     * Borrar un producto desde el ID
     *
     * @param id
     */
    public void eliminarProducto(Long id) {
        productoPersistence.delete(id);
    }
}
