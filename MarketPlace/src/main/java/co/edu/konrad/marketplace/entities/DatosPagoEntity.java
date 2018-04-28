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
@Entity (name = "DatosPago")
public class DatosPagoEntity implements Serializable {
    
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID= 1L;

    /**
     * Llave primaria de la Entidad DatosPago
     */
    @Id
    @Column (name = "id_dPago", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDatosPago;
    
    /**
     * Variable que almacena el nombre del banco
     */
    @Column (name = "nombre_banco", nullable = false)
    private String nombreBanco;
    
    /**
     * Variable que almacena el numero de cuenta del banco
     */
    @Column (name = "nro_cuenta")
    private int nroCuenta;

    /**
     * Variable que almacena la franquicia del banco
     */
    @Column (name = "fraquicia_banco")
    private String franquiciaBanco;
    
    /**
     * Variable que almacena el numero de tarjeta del banco
     */
    @Column (name = "nro_tarjeta")
    private int nroTarjeta;
    
    /**
     * Variable que almacena el codigo de clave del banco
     */
    @Column (name = "cod_clave")
    private int codClave;

    @ManyToOne
    @JoinColumn (name = "id_cliente")
    private ClienteEntity cliente;
    
    @ManyToOne
    @JoinColumn (name = "id_tPago")
    private TipoPagoEntity tipoPago;

    /**
     * Metodos GET Y SET
     * @return idDatosPago
     */
    
    public Long getIdDatosPago() {
        return idDatosPago;
    }

    public void setIdDatosPago(Long idDatosPago) {
        this.idDatosPago = idDatosPago;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getFranquiciaBanco() {
        return franquiciaBanco;
    }

    public void setFranquiciaBanco(String franquiciaBanco) {
        this.franquiciaBanco = franquiciaBanco;
    }

    public int getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(int nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public int getCodClave() {
        return codClave;
    }

    public void setCodClave(int codClave) {
        this.codClave = codClave;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public TipoPagoEntity getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPagoEntity tipoPago) {
        this.tipoPago = tipoPago;
    }
}
