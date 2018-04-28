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

/**
 *
 * @author DarkFACS
 */
@Entity (name = "TipoProducto")
public class TipoProductoEntity implements Serializable {
    
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID= 1L;

    /**
     * Llave primaria de la Entidad TipoProducto
     */
    @Id
    @Column (name = "id_tProducto", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTProducto;
    
    /**
     * Variable que almacena la nombre del tipo de producto
     */
    @Column (name = "nombre_tProducto")
    private String nombreTProducto;
    
    /**
     * Variable que almacena el descripcion del tipo de producto
     */
    @Column (name = "descripcion_tProducto")
    private String descripcionTProducto;

    /**
     * Metodos GET Y SET
     * @return 
     */
    
    public Long getIdTProducto() {
        return idTProducto;
    }

    public void setIdTProducto(Long idTProducto) {
        this.idTProducto = idTProducto;
    }

    public String getNombreTProducto() {
        return nombreTProducto;
    }

    public void setNombreTProducto(String nombreTProducto) {
        this.nombreTProducto = nombreTProducto;
    }

    public String getDescripcionTProducto() {
        return descripcionTProducto;
    }

    public void setDescripcionTProducto(String descripcionTProducto) {
        this.descripcionTProducto = descripcionTProducto;
    }
}
