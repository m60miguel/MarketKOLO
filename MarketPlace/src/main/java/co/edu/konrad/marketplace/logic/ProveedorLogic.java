/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.logic;

import co.edu.konrad.marketplace.entities.ProveedorEntity;
import co.edu.konrad.marketplace.persistence.ProveedorPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author DarkFACS
 */
@Stateless
public class ProveedorLogic {
    
    /**
     * Inyeccion del Persistence de Proveedor
     */
    @Inject
    private ProveedorPersistence proveedorPersistence;

    /**
     * Obtener Listado de Proveedor. Inyeccion del persistence de proveedor
     *
     * @return
     */
    public List<ProveedorEntity> obtenerProveedores() {
        List<ProveedorEntity> proveedores = proveedorPersistence.findAll();
        return proveedores;
    }

    /**
     * Obtener un proveedor desde el Identificador (id)
     *
     * @param id
     * @return proveedor encontrado
     */
    public ProveedorEntity obtenerProveedorPorId(Long id) {
        ProveedorEntity proveedor = proveedorPersistence.find(id);
        if (proveedor == null) {
            throw new IllegalArgumentException("El proveedor solicitado no existe");
        }
        return proveedor;
    }

    /**
     * Metodo utilizado para crear un Nuevo Proveedor
     *
     * @param proveedor
     * @return proveedor creado
     */
    public ProveedorEntity crearProveedor(ProveedorEntity proveedor) {
        proveedorPersistence.create(proveedor);
        return proveedor;
    }

    /**
     * Actualizar un objeto Proveedor
     *
     * @param id
     * @param proveedor
     * @return proveedor actualizado
     */
    public ProveedorEntity actualizarProveedor(Long id, ProveedorEntity proveedor) {
        ProveedorEntity proveedorEntity = proveedorPersistence.update(proveedor);
        return proveedorEntity;
    }

    /**
     * Borrar un proveedor desde el ID
     *
     * @param id
     */
    public void eliminarProveedor(Long id) {
        proveedorPersistence.delete(id);
    }
}
