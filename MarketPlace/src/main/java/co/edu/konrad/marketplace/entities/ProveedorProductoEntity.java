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
import javax.persistence.ManyToOne;

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

    @ManyToOne
    @JoinColumn (name = "id_proveedor")
    private ProveedorEntity proveedor;
    
    @ManyToOne
    @JoinColumn (name = "id_producto")
    private ProductoEntity producto;

    /**
     * Metodos GET Y SET
     * @return 
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

    public ProveedorEntity getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorEntity proveedor) {
        this.proveedor = proveedor;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }
}
