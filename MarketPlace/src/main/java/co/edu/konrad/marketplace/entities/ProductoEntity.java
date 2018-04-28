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
import javax.persistence.NamedQuery;

/**
 *
 * @author DarkFACS
 */
@Entity (name = "Producto")
@NamedQuery (name = "Producto.findByName", query = "select p from Producto p where p.nombreProducto = :nombre")
public class ProductoEntity implements Serializable {
    
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID= 1L;

    /**
     * Llave primaria de la Entidad Producto
     */
    @Id
    @Column (name = "id_producto", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProducto;
    
    /**
     * Variable que almacena el nombre del producto
     */
    @Column (name = "nombre_producto", nullable = false)
    private String nombreProducto;
    
    /**
     * Variable que almacena la marca del producto
     */
    @Column (name = "marca_producto", nullable = false)
    private String marcaProducto;
    
    /**
     * Variable que almacena el valor del producto
     */
    @Column (name = "valor_producto", nullable = false)
    private int valorProducto;
    
    /**
     * Variable que almacena la garantia del producto
     */
    @Column (name = "garantia_producto")
    private int garantiaProducto;

    @ManyToOne
    @JoinColumn (name = "id_tProducto")
    private TipoProductoEntity tipoProducto;

    /**
     * Metodos GET Y SET
     * @return 
     */
    
    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public int getValorProducto() {
        return valorProducto;
    }

    public void setValorProducto(int valorProducto) {
        this.valorProducto = valorProducto;
    }

    public int getGarantiaProducto() {
        return garantiaProducto;
    }

    public void setGarantiaProducto(int garantiaProducto) {
        this.garantiaProducto = garantiaProducto;
    }

    public TipoProductoEntity getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProductoEntity tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}
