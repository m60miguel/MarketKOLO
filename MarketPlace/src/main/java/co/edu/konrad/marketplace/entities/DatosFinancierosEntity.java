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
@Entity
public class DatosFinancierosEntity implements Serializable {
    
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID= 1L;

    /**
     * Llave primaria de la Entidad DatosFinancieros
     */
    @Id
    @Column (name = "id_proveedor", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProveedor;
    
    /**
     * Variable que almacena las ventas anuales
     */
    @Column (name = "ventas_anuales")
    private int ventasAnuales;
    
    /**
     * Variable que almacena el mercado objetivo
     */
    @Column (name = "mercado_objetivo")
    private String mercadoObjetivo;
    
    /**
     * Variable que almacena el nivel de reputacion
     */
    @Column (name = "nivel_reputacion")
    private String nivelreputacion;

    @ManyToOne
    @JoinColumn (name = "id_proveedor")
    private ProveedorEntity proveedor;

    /**
     * Metodos GET Y SET
     */
    
    public Long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getVentasAnuales() {
        return ventasAnuales;
    }

    public void setVentasAnuales(int ventasAnuales) {
        this.ventasAnuales = ventasAnuales;
    }

    public String getMercadoObjetivo() {
        return mercadoObjetivo;
    }

    public void setMercadoObjetivo(String mercadoObjetivo) {
        this.mercadoObjetivo = mercadoObjetivo;
    }

    public String getNivelreputacion() {
        return nivelreputacion;
    }

    public void setNivelreputacion(String nivelreputacion) {
        this.nivelreputacion = nivelreputacion;
    }

    public ProveedorEntity getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorEntity proveedor) {
        this.proveedor = proveedor;
    }
}
