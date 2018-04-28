/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.logic;

import co.edu.konrad.marketplace.entities.TipoProductoEntity;
import co.edu.konrad.marketplace.persistence.TipoProductoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author DarkFACS
 */
@Stateless
public class TipoProductoLogic {
    
    /**
     * Inyeccion del Persistence de TipoProductoLogic
     */
    @Inject
    private TipoProductoPersistence tipoProductoPersistence;

    /**
     * Obtener Listado de TipoProductoLogic. Inyeccion del persistence de tipoProducto
     *
     * @return
     */
    public List<TipoProductoEntity> obtenerTiposProducto() {
        List<TipoProductoEntity> tiposProducto = tipoProductoPersistence.findAll();
        return tiposProducto;
    }

    /**
     * Obtener un tipo de producto desde el Identificador (id)
     *
     * @param id
     * @return tipoProducto encontrado
     */
    public TipoProductoEntity obtenerTipoProductoPorId(Long id) {
        TipoProductoEntity tipoProducto = tipoProductoPersistence.find(id);
        if (tipoProducto == null) {
            throw new IllegalArgumentException("El tipo de producto solicitado no existe");
        }
        return tipoProducto;
    }

    /**
     * Metodo utilizado para crear un Nuevo TipoProductoLogic
     *
     * @param tipoProducto
     * @return tipoProducto creado
     */
    public TipoProductoEntity crearTipoProducto(TipoProductoEntity tipoProducto) {
        tipoProductoPersistence.create(tipoProducto);
        return tipoProducto;
    }

    /**
     * Actualizar un objeto TipoProductoLogic
     *
     * @param id
     * @param tipoProducto
     * @return tipoProducto actualizado
     */
    public TipoProductoEntity actualizarTipoProducto(Long id, TipoProductoEntity tipoProducto) {
        TipoProductoEntity tipoProductoEntity = tipoProductoPersistence.update(tipoProducto);
        return tipoProductoEntity;
    }

    /**
     * Borrar un tipoProducto desde el ID
     *
     * @param id
     */
    public void eliminarTipoProducto(Long id) {
        tipoProductoPersistence.delete(id);
    }
}
