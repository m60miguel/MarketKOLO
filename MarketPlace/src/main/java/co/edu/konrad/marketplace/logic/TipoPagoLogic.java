/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.logic;

import co.edu.konrad.marketplace.entities.TipoPagoEntity;
import co.edu.konrad.marketplace.persistence.TipoPagoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author DarkFACS
 */
@Stateless
public class TipoPagoLogic {
    
    /**
     * Inyeccion del Persistence de TipoPago
     */
    @Inject
    private TipoPagoPersistence tipoPagoPersistence;

    /**
     * Obtener Listado de TipoPago. Inyeccion del persistence de tipoPago
     *
     * @return
     */
    public List<TipoPagoEntity> obtenerTiposPago() {
        List<TipoPagoEntity> tiposPago = tipoPagoPersistence.findAll();
        return tiposPago;
    }

    /**
     * Obtener un tipo de pago desde el Identificador (id)
     *
     * @param id
     * @return tipoPago encontrado
     */
    public TipoPagoEntity obtenerTipoPagoPorId(Long id) {
        TipoPagoEntity tipoPago = tipoPagoPersistence.find(id);
        if (tipoPago == null) {
            throw new IllegalArgumentException("El tipo de pago solicitado no existe");
        }
        return tipoPago;
    }

    /**
     * Metodo utilizado para crear un Nuevo TipoPago
     *
     * @param tipoPago
     * @return tipoPago creado
     */
    public TipoPagoEntity crearTipoPago(TipoPagoEntity tipoPago) {
        tipoPagoPersistence.create(tipoPago);
        return tipoPago;
    }

    /**
     * Actualizar un objeto TipoPago
     *
     * @param id
     * @param tipoPago
     * @return tipoPago actualizado
     */
    public TipoPagoEntity actualizarTipoPago(Long id, TipoPagoEntity tipoPago) {
        TipoPagoEntity tipoPagoEntity = tipoPagoPersistence.update(tipoPago);
        return tipoPagoEntity;
    }

    /**
     * Borrar un tipoPago desde el ID
     *
     * @param id
     */
    public void eliminarTipoPago(Long id) {
        tipoPagoPersistence.delete(id);
    }
}
