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
import javax.persistence.NamedQuery;

/**
 *
 * @author DarkFACS
 */
@Entity (name = "Proveedor")
@NamedQuery (name = "Proveedor.findByName", query = "select p from Proveedor p where p.nombreProveedor = :nombre")
public class ProveedorEntity implements Serializable {
    
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID= 1L;

    /**
     * Llave primaria de la Entidad Proveedor
     */
    @Id
    @Column (name = "id_proveedor", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProveedor;
    
    /**
     * Variable que almacena el nit del proveedor
     */
    @Column (name = "nit_proveedor", nullable = false)
    private int nitProveedor;
    
    /**
     * Variable que almacena el nombre del proveedor
     */
    @Column (name = "nombre_proveedor", nullable = false)
    private String nombreProveedor;
    
    /**
     * Variable que almacena el usuario del proveedor
     */
    @Column (name = "usuario_proveedor", nullable = false)
    private String usuarioProveedor;
    
    /**
     * Variable que almacena el password del proveedor
     */
    @Column (name = "pass_proveedor", nullable = false)
    private String passProveedor;
   
    /**
     * Variable que almacena el avatar del proveedor
     */
    @Column (name = "avatar_proveedor")
    private String avatarProveedor;

    /**
     * Metodos GET Y SET
     * @return 
     */
    
    public Long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(int nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getUsuarioProveedor() {
        return usuarioProveedor;
    }

    public void setUsuarioProveedor(String usuarioProveedor) {
        this.usuarioProveedor = usuarioProveedor;
    }

    public String getPassProveedor() {
        return passProveedor;
    }

    public void setPassProveedor(String passProveedor) {
        this.passProveedor = passProveedor;
    }

    public String getAvatarProveedor() {
        return avatarProveedor;
    }

    public void setAvatarProveedor(String avatarProveedor) {
        this.avatarProveedor = avatarProveedor;
    }
}
