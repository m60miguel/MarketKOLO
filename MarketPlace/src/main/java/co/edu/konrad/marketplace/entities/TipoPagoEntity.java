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
@Entity
public class TipoPagoEntity implements Serializable {
    
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID= 1L;

    /**
     * Llave primaria de la Entidad TipoPago
     */
    @Id
    @Column (name = "id_tPago", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTPago;
    
    /**
     * Variable que almacena la nombre del tipo de pago
     */
    @Column (name = "nombre_tPago")
    private String nombreTPago;

    /**
     * Metodos GET Y SET
     */
    
    public Long getIdTPago() {
        return idTPago;
    }

    public void setIdTPago(Long idTPago) {
        this.idTPago = idTPago;
    }

    public String getNombreTPago() {
        return nombreTPago;
    }

    public void setNombreTPago(String nombreTPago) {
        this.nombreTPago = nombreTPago;
    }
}
