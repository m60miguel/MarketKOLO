/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.logic;

import co.edu.konrad.marketplace.entities.FacturaEntity;
import co.edu.konrad.marketplace.persistence.FacturaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author DarkFACS
 */
@Stateless
public class FacturaLogic {
    
    /**
     * Inyeccion del Persistence de Factura
     */
    @Inject
    private FacturaPersistence facturaPersistence;

    /**
     * Obtener Listado de Factura. Inyeccion del persistence de factura
     *
     * @return
     */
    public List<FacturaEntity> obtenerFacturas() {
        List<FacturaEntity> facturas = facturaPersistence.findAll();
        return facturas;
    }

    /**
     * Obtener una factura desde el Identificador (id)
     *
     * @param id
     * @return factura encontrado
     */
    public FacturaEntity obtenerFacturaPorId(Long id) {
        FacturaEntity factura = facturaPersistence.find(id);
        if (factura == null) {
            throw new IllegalArgumentException("La factura solicitada no existe");
        }
        return factura;
    }

    /**
     * Metodo utilizado para crear una Nueva Factura
     *
     * @param factura
     * @return factura creado
     */
    public FacturaEntity crearFactura(FacturaEntity factura) {
        facturaPersistence.create(factura);
        return factura;
    }

    /**
     * Actualizar un objeto Factura
     *
     * @param id
     * @param factura
     * @return factura actualizado
     */
    public FacturaEntity actualizarFactura(Long id, FacturaEntity factura) {
        FacturaEntity facturaEntity = facturaPersistence.update(factura);
        return facturaEntity;
    }

    /**
     * Borrar una factura desde el ID
     *
     * @param id
     */
    public void eliminarFactura(Long id) {
        facturaPersistence.delete(id);
    }
}
