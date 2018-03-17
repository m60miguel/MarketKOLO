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
public class PaisEntity implements Serializable {
    
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID= 1L;

    /**
     * Llave primaria de la Entidad Pais
     */
    @Id
    @Column (name = "id_pais", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPais;
    
    /**
     * Variable que almacena el codigo del pais
     */
    @Column (name = "codigo_pais", nullable = false)
    private int codigoPais;
    
    /**
     * Variable que almacena el nombre del pais
     */
    @Column (name = "nombre_pais", nullable = false)
    private String nombrePais;

    /**
     * Metodos GET Y SET
     */
    
    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public int getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(int codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
}
