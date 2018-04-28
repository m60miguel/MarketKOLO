/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.logic;

import co.edu.konrad.marketplace.entities.CiudadEntity;
import co.edu.konrad.marketplace.persistence.CiudadPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author DarkFACS
 */
@Stateless
public class CiudadLogic {
    
    /**
     * Inyeccion del Persistence de Ciudad
     */
    @Inject
    private CiudadPersistence ciudadPersistence;

    /**
     * Obtener Listado de Ciudads. Inyeccion del persistence del ciudad
     *
     * @return
     */
    public List<CiudadEntity> obtenerCiudades() {
        List<CiudadEntity> ciudades = ciudadPersistence.findAll();
        return ciudades;
    }

    /**
     * Obtener una ciudad desde el Identificador (id)
     *
     * @param id
     * @return ciudad encontrado
     */
    public CiudadEntity obtenerCiudadPorId(Long id) {
        CiudadEntity ciudad = ciudadPersistence.find(id);
        if (ciudad == null) {
            throw new IllegalArgumentException("La ciudad solicitada no existe");
        }
        return ciudad;
    }

    /**
     * Metodo utilizado para crear una Nuevo Ciudad
     *
     * @param ciudad
     * @return ciudad creado
     */
    public CiudadEntity crearCiudad(CiudadEntity ciudad) {
        ciudadPersistence.create(ciudad);
        return ciudad;
    }

    /**
     * Actualizar un objeto Ciudad
     *
     * @param id
     * @param ciudad
     * @return ciudad actualizado
     */
    public CiudadEntity actualizarCiudad(Long id, CiudadEntity ciudad) {
        CiudadEntity ciudadEntity = ciudadPersistence.update(ciudad);
        return ciudadEntity;
    }

    /**
     * Borrar una ciudad desde el ID
     *
     * @param id
     */
    public void eliminarCiudad(Long id) {
        ciudadPersistence.delete(id);
    }
}
