/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.logic;

import co.edu.konrad.marketplace.entities.ProveedorProductoEntity;
import co.edu.konrad.marketplace.persistence.ProveedorProductoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author DarkFACS
 */
@Stateless
public class ProveedorProductoLogic {
    
    /**
     * Inyeccion del Persistence de ProveedorProducto
     */
    @Inject
    private ProveedorProductoPersistence proveedorProductoPersistence;

    /**
     * Obtener Listado de ProveedorProducto. Inyeccion del persistence de proveedorProducto
     *
     * @return
     */
    public List<ProveedorProductoEntity> obtenerProveedoresProductos() {
        List<ProveedorProductoEntity> proveedoresProductos = proveedorProductoPersistence.findAll();
        return proveedoresProductos;
    }

    /**
     * Obtener un proveedor producto desde el Identificador (id)
     *
     * @param id
     * @return proveedor encontrado
     */
    public ProveedorProductoEntity obtenerProveedorProductoPorId(Long id) {
        ProveedorProductoEntity proveedorProducto = proveedorProductoPersistence.find(id);
        if (proveedorProducto == null) {
            throw new IllegalArgumentException("El proveedor producto solicitado no existe");
        }
        return proveedorProducto;
    }

    /**
     * Metodo utilizado para crear un Nuevo ProveedorProducto
     *
     * @param proveedorProducto
     * @return proveedorProducto creado
     */
    public ProveedorProductoEntity crearProveedorProducto(ProveedorProductoEntity proveedorProducto) {
        proveedorProductoPersistence.create(proveedorProducto);
        return proveedorProducto;
    }

    /**
     * Actualizar un objeto ProveedorProducto
     *
     * @param id
     * @param proveedorProducto
     * @return proveedorProducto actualizado
     */
    public ProveedorProductoEntity actualizarProveedorProducto(Long id, ProveedorProductoEntity proveedorProducto) {
        ProveedorProductoEntity proveedorProductoEntity = proveedorProductoPersistence.update(proveedorProducto);
        return proveedorProductoEntity;
    }

    /**
     * Borrar un proveedorProducto desde el ID
     *
     * @param id
     */
    public void eliminarProveedorProducto(Long id) {
        proveedorProductoPersistence.delete(id);
    }
}
