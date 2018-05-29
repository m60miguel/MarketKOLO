/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

/**
 *
 * @author DarkFACS
 */
@Entity (name = "ProveedorProducto")
public class ProveedorProductoEntity implements Serializable {
    
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID= 1L;

    /**
     * Llave primaria de la Entidad ProveedorProducto
     */
    @Id
    @Column (name = "id_pProducto", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProveedorProducto;
    
    /**
     * Variable que almacena el tipo del comunicacion
     */
    @Column (name = "tipo_pProducto", nullable = false)
    private String tipoProveedorProducto;
    
    /**
     * Variable que almacena la descripcion del tipo de comunicacion
     */
    @Column (name = "descripcion_pProducto")
    private String descripcionProveedorProducto;

    @JoinColumn (name = "proveedor_id")
    private int proveedorId;
    
    @JoinColumn (name = "producto_id")
    private int productoId;

    /**
     * Metodos GET Y SET
     * @return idProveedorProducto
     */
    
    public Long getIdProveedorProducto() {
        return idProveedorProducto;
    }

    public void setIdProveedorProducto(Long idProveedorProducto) {
        this.idProveedorProducto = idProveedorProducto;
    }

    public String getTipoProveedorProducto() {
        return tipoProveedorProducto;
    }

    public void setTipoProveedorProducto(String tipoProveedorProducto) {
        this.tipoProveedorProducto = tipoProveedorProducto;
    }

    public String getDescripcionProveedorProducto() {
        return descripcionProveedorProducto;
    }

    public void setDescripcionProveedorProducto(String descripcionProveedorProducto) {
        this.descripcionProveedorProducto = descripcionProveedorProducto;
    }

    public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }
}
