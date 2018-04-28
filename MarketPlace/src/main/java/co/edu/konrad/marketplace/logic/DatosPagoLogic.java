/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.logic;

import co.edu.konrad.marketplace.entities.DatosPagoEntity;
import co.edu.konrad.marketplace.persistence.DatosPagoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author DarkFACS
 */
@Stateless
public class DatosPagoLogic {
    
    /**
     * Inyeccion del Persistence de DatosPago
     */
    @Inject
    private DatosPagoPersistence datosPagoPersistence;

    /**
     * Obtener Listado de DatosPago. Inyeccion del persistence del datosPago
     *
     * @return
     */
    public List<DatosPagoEntity> obtenerDatosPago() {
        List<DatosPagoEntity> datosPago = datosPagoPersistence.findAll();
        return datosPago;
    }

    /**
     * Obtener una dato de pago desde el Identificador (id)
     *
     * @param id
     * @return datoPago encontrado
     */
    public DatosPagoEntity obtenerDatoPagoPorId(Long id) {
        DatosPagoEntity datoPago = datosPagoPersistence.find(id);
        if (datoPago == null) {
            throw new IllegalArgumentException("El dato de pago solicitado no existe");
        }
        return datoPago;
    }

    /**
     * Metodo utilizado para crear una Nuevo DatosPago
     *
     * @param datoPago
     * @return datoPago creado
     */
    public DatosPagoEntity crearDatoPago(DatosPagoEntity datoPago) {
        datosPagoPersistence.create(datoPago);
        return datoPago;
    }

    /**
     * Actualizar un objeto DatosPago
     *
     * @param id
     * @param datoPago
     * @return datosPago actualizado
     */
    public DatosPagoEntity actualizarDatoPago(Long id, DatosPagoEntity datoPago) {
        DatosPagoEntity datosPagoEntity = datosPagoPersistence.update(datoPago);
        return datosPagoEntity;
    }

    /**
     * Borrar un datoPago desde el ID
     *
     * @param id
     */
    public void eliminarDatoPago(Long id) {
        datosPagoPersistence.delete(id);
    }
}
