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
import javax.persistence.NamedQuery;

/**
 *
 * @author DarkFACS
 */
@Entity (name = "Cliente")
@NamedQuery (name = "Cliente.findByName", query = "select c from Cliente c where c.nombreCliente = :nombre")
public class ClienteEntity implements Serializable {
    
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID= 1L;

    /**
     * Llave primaria de la Entidad Cliente
     */
    @Id
    @Column (name = "id_cliente", nullable = false)
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
    private String apellidoCliente;
    
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
    @Column (name = "fechaNac_cliente", nullable = false)
    private String fechaNacCliente;
    
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
    @Column (name = "avatar_cliente",nullable = true)
    private String avatarCliente;

    @JoinColumn (name = "ciudad_id")
    private int ciudadId;

    /**
     * Metodos GET Y SET
     * @return idCliente
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

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
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

    public String getFechaNacCliente() {
        return fechaNacCliente;
    }

    public void setFechaNacCliente(String fechaNacCliente) {
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

    public int getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(int ciudadId) {
        this.ciudadId = ciudadId;
    }
}
