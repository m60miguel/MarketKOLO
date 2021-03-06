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
@Entity (name = "Comunicacion")
public class ComunicacionEntity implements Serializable {
    
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID= 1L;

    /**
     * Llave primaria de la Entidad Comunicacion
     */
    @Id
    @Column (name = "id_comunicacion", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idComunicacion;
    
    /**
     * Variable que almacena el tipo del comunicacion
     */
    @Column (name = "tipo_comunicacion", nullable = false)
    private String tipoComunicacion;
    
    /**
     * Variable que almacena la descripcion del tipo de comunicacion
     */
    @Column (name = "descripcion_comunicacion")
    private String descripcionComunicacion;

    @JoinColumn (name = "proveedor_id")
    private int proveedorId;

    /**
     * Metodos GET Y SET
     * @return idComunicacion
     */
    
    public Long getIdComunicacion() {
        return idComunicacion;
    }

    public void setIdComunicacion(Long idComunicacion) {
        this.idComunicacion = idComunicacion;
    }

    public String getTipoComunicacion() {
        return tipoComunicacion;
    }

    public void setTipoComunicacion(String tipoComunicacion) {
        this.tipoComunicacion = tipoComunicacion;
    }

    public String getDescripcionComunicacion() {
        return descripcionComunicacion;
    }

    public void setDescripcionComunicacion(String descripcionComunicacion) {
        this.descripcionComunicacion = descripcionComunicacion;
    }

    public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }
}
