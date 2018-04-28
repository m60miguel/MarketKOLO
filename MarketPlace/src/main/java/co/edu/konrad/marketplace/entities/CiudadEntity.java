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
@Entity (name = "Ciudad")
@NamedQuery (name = "Ciudad.findByName", query = "select c from Ciudad c where c.nombreCiudad = :nombre")
public class CiudadEntity implements Serializable {
    
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID= 1L;

    /**
     * Llave primaria de la Entidad Ciudad
     */
    @Id
    @Column (name = "id_ciudad", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCiudad;
    
    /**
     * Variable que almacena el codigo de la ciudad
     */
    @Column (name = "codigo_ciudad", nullable = false)
    private int codigoCiudad;
    
    /**
     * Variable que almacena el nombre de la ciudad
     */
    @Column (name = "nombre_ciudad", nullable = false)
    private String nombreCiudad;
    
    @ManyToOne
    @JoinColumn (name = "id_pais")
    private PaisEntity pais;

    /**
     * Metodos GET Y SET
     * @return idCiudad
     */
    
    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public int getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(int codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public PaisEntity getPais() {
        return pais;
    }

    public void setPais(PaisEntity pais) {
        this.pais = pais;
    }
}
