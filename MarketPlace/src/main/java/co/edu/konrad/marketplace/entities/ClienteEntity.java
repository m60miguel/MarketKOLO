/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author DarkFACS
 */
@Entity
public class ClienteEntity implements Serializable {
    
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID= 1L;

    /**
     * Llave primaria de la Entidad Cliente
     */
    @Id
    @Column (name = "id_cliente", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCliente;
    
    /**
     * Variable que almacena el nombre del cliente
     */
    @Column (name = "nombre_cliente", nullable = false)
    private String nombreCliente;
    
    /**
     * Variable que almacena el apellido del cliente
     */
    @Column (name = "apellido_cliente", nullable = false)
    private int apellidoCliente;
    
    /**
     * Variable que almacena el tipo de documento del cliente
     */
    @Column (name = "tDoc_cliente", nullable = false)
    private String tDocCliente;
    
    /**
     * Variable que almacena el numero de documento del cliente
     */
    @Column (name = "nDoc_cliente", nullable = false)
    private int nDocCliente;
    
    /**
     * Variable que almacena la fecha de nacimiento del cliente
     */
    @Temporal(TemporalType.DATE)
    @Column (name = "fechaNac_cliente", nullable = false)
    private Date fechaNacCliente;
    
    /**
     * Variable que almacena el usuario del cliente
     */
    @Column (name = "usuario_cliente", nullable = false)
    private String usuarioCliente;
    
    /**
     * Variable que almacena el password del cliente
     */
    @Column (name = "pass_cliente", nullable = false)
    private String passCliente;
    
    /**
     * Variable que almacena la direccion del cliente
     */
    @Column (name = "direccion_cliente", nullable = false)
    private String direccionCliente;
    
    /**
     * Variable que almacena el telefono del cliente
     */
    @Column (name = "telefono_cliente", nullable = false)
    private int telefonoCliente;
    
    /**
     * Variable que almacena el email del cliente
     */
    @Column (name = "email_cliente", nullable = false)
    private String emailCliente;
    
    /**
     * Variable que almacena el avatar del cliente
     */
    @Column (name = "avatar_cliente")
    private String avatarCliente;

    @ManyToOne
    @JoinColumn (name = "id_ciudad")
    private CiudadEntity ciudad;

    /**
     * Metodos GET Y SET
     */
    
    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(int apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String gettDocCliente() {
        return tDocCliente;
    }

    public void settDocCliente(String tDocCliente) {
        this.tDocCliente = tDocCliente;
    }

    public int getnDocCliente() {
        return nDocCliente;
    }

    public void setnDocCliente(int nDocCliente) {
        this.nDocCliente = nDocCliente;
    }

    public Date getFechaNacCliente() {
        return fechaNacCliente;
    }

    public void setFechaNacCliente(Date fechaNacCliente) {
        this.fechaNacCliente = fechaNacCliente;
    }

    public String getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(String usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public String getPassCliente() {
        return passCliente;
    }

    public void setPassCliente(String passCliente) {
        this.passCliente = passCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public int getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(int telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getAvatarCliente() {
        return avatarCliente;
    }

    public void setAvatarCliente(String avatarCliente) {
        this.avatarCliente = avatarCliente;
    }

    public CiudadEntity getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadEntity ciudad) {
        this.ciudad = ciudad;
    }
}
