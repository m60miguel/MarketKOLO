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
@Entity (name = "DatosFinancieros")
public class DatosFinancierosEntity implements Serializable {
    
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID= 1L;

    /**
     * Llave primaria de la Entidad DatosFinancieros
     */
    @Id
    @Column (name = "id_dFinancieros", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iddFinancieros;
    
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
    private String nivelReputacion;

    @JoinColumn (name = "proveedor_id")
    private int proveedorId;

    /**
     * Metodos GET Y SET
     * @return iddFinancieros
     */
    
    public Long getIddFinancieros() {
        return iddFinancieros;
    }

    public void setIddFinancieros(Long iddFinancieros) {
        this.iddFinancieros = iddFinancieros;
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

    public String getNivelReputacion() {
        return nivelReputacion;
    }

    public void setNivelReputacion(String nivelReputacion) {
        this.nivelReputacion = nivelReputacion;
    }

    public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }
}
