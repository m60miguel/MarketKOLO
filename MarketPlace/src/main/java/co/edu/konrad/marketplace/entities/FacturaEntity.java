/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author DarkFACS
 */
@Entity (name = "Factura")
public class FacturaEntity implements Serializable {
    
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID= 1L;

    /**
     * Llave primaria de la Entidad Factura
     */
    @Id
    @Column (name = "id_factura", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFactura;

    /**
     * Variable que almacena la fecha de compra en la factura
     */
    @Temporal(TemporalType.DATE)
    @Column (name = "fecha_compra", nullable = false)
    private Date fechaCompra;
 
    /**
     * Variable que almacena la cantidad del producto comprado en la factura
     */
    @Column (name = "cantidad_compra", nullable = false)
    private int cantidadCompra;
    
    @JoinColumn (name = "id_cliente")
    private int clienteId;
    
    @JoinColumn (name = "producto_id")
    private int productoId;

    /**
     * Metodos GET Y SET
     * @return idFactura
     */
    
    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getCantidadCompra() {
        return cantidadCompra;
    }

    public void setCantidadCompra(int cantidadCompra) {
        this.cantidadCompra = cantidadCompra;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }
}
