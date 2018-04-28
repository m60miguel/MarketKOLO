/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.logic;

import co.edu.konrad.marketplace.entities.ComunicacionEntity;
import co.edu.konrad.marketplace.persistence.ComunicacionPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author DarkFACS
 */
@Stateless
public class ComunicacionLogic {
    
    /**
     * Inyeccion del Persistence de Comunicacion
     */
    @Inject
    private ComunicacionPersistence comunicacionPersistence;

    /**
     * Obtener Listado de Comunicaciones. Inyeccion del persistence del comunicacion
     *
     * @return
     */
    public List<ComunicacionEntity> obtenerComunicaciones() {
        List<ComunicacionEntity> comunicaciones = comunicacionPersistence.findAll();
        return comunicaciones;
    }

    /**
     * Obtener una comunicacion desde el Identificador (id)
     *
     * @param id
     * @return comunicacion encontrado
     */
    public ComunicacionEntity obtenerComunicacionPorId(Long id) {
        ComunicacionEntity comunicacion = comunicacionPersistence.find(id);
        if (comunicacion == null) {
            throw new IllegalArgumentException("La comunicacion solicitada no existe");
        }
        return comunicacion;
    }

    /**
     * Metodo utilizado para crear una Nueva Comunicacion
     *
     * @param comunicacion
     * @return comunicacion creado
     */
    public ComunicacionEntity crearComunicacion(ComunicacionEntity comunicacion) {
        comunicacionPersistence.create(comunicacion);
        return comunicacion;
    }

    /**
     * Actualizar un objeto Comunicacion
     *
     * @param id
     * @param comunicacion
     * @return comunicacion actualizado
     */
    public ComunicacionEntity actualizarComunicacion(Long id, ComunicacionEntity comunicacion) {
        ComunicacionEntity comunicacionEntity = comunicacionPersistence.update(comunicacion);
        return comunicacionEntity;
    }

    /**
     * Borrar una comunicacion desde el ID
     *
     * @param id
     */
    public void eliminarComunicacion(Long id) {
        comunicacionPersistence.delete(id);
    }
}
