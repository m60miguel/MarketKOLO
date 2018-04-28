/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.logic;

import co.edu.konrad.marketplace.entities.DatosFinancierosEntity;
import co.edu.konrad.marketplace.persistence.DatosFinancierosPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author DarkFACS
 */
@Stateless
public class DatosFinancierosLogic {
    
    /**
     * Inyeccion del Persistence de DatosFinancieros
     */
    @Inject
    private DatosFinancierosPersistence datoFinancieroPersistence;

    /**
     * Obtener Listado de DatosFinancieros. Inyeccion del persistence del datoFinanciero
     *
     * @return
     */
    public List<DatosFinancierosEntity> obtenerDatosFinancieros() {
        List<DatosFinancierosEntity> datosFinancieros = datoFinancieroPersistence.findAll();
        return datosFinancieros;
    }

    /**
     * Obtener una dato financiero desde el Identificador (id)
     *
     * @param id
     * @return datoFinanciero encontrado
     */
    public DatosFinancierosEntity obtenerDatoFinancieroPorId(Long id) {
        DatosFinancierosEntity datoFinanciero = datoFinancieroPersistence.find(id);
        if (datoFinanciero == null) {
            throw new IllegalArgumentException("El dato financiero solicitado no existe");
        }
        return datoFinanciero;
    }

    /**
     * Metodo utilizado para crear una Nuevo DatosFinancieros
     *
     * @param datoFinanciero
     * @return datoFinanciero creado
     */
    public DatosFinancierosEntity crearDatoFinanciero(DatosFinancierosEntity datoFinanciero) {
        datoFinancieroPersistence.create(datoFinanciero);
        return datoFinanciero;
    }

    /**
     * Actualizar un objeto DatosFinancieros
     *
     * @param id
     * @param datoFinanciero
     * @return datoFinanciero actualizado
     */
    public DatosFinancierosEntity actualizarDatoFinanciero(Long id, DatosFinancierosEntity datoFinanciero) {
        DatosFinancierosEntity datoFinancieroEntity = datoFinancieroPersistence.update(datoFinanciero);
        return datoFinancieroEntity;
    }

    /**
     * Borrar un datoFinanciero desde el ID
     *
     * @param id
     */
    public void eliminarDatoFinanciero(Long id) {
        datoFinancieroPersistence.delete(id);
    }
}
