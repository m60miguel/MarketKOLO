/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.logic;

import co.edu.konrad.marketplace.entities.PaisEntity;
import co.edu.konrad.marketplace.persistence.PaisPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author DarkFACS
 */
@Stateless
public class PaisLogic {
    
    /**
     * Inyeccion del Persistence de Pais
     */
    @Inject
    private PaisPersistence paisPersistence;

    /**
     * Obtener Listado de Pais. Inyeccion del persistence de pais
     *
     * @return
     */
    public List<PaisEntity> obtenerPaises() {
        List<PaisEntity> paises = paisPersistence.findAll();
        return paises;
    }

    /**
     * Obtener un pais desde el Identificador (id)
     *
     * @param id
     * @return pais encontrado
     */
    public PaisEntity obtenerPaisPorId(Long id) {
        PaisEntity pais = paisPersistence.find(id);
        if (pais == null) {
            throw new IllegalArgumentException("El pais solicitado no existe");
        }
        return pais;
    }

    /**
     * Metodo utilizado para crear un Nuevo Pais
     *
     * @param pais
     * @return pais creado
     */
    public PaisEntity crearPais(PaisEntity pais) {
        paisPersistence.create(pais);
        return pais;
    }

    /**
     * Actualizar un objeto Pais
     *
     * @param id
     * @param pais
     * @return pais actualizado
     */
    public PaisEntity actualizarPais(Long id, PaisEntity pais) {
        PaisEntity paisEntity = paisPersistence.update(pais);
        return paisEntity;
    }

    /**
     * Borrar un pais desde el ID
     *
     * @param id
     */
    public void eliminarPais(Long id) {
        paisPersistence.delete(id);
    }
}
