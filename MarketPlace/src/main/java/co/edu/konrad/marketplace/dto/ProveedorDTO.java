/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.dto;

import co.edu.konrad.marketplace.entities.ProveedorEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DarkFACS
 */
public class ProveedorDTO {
    
    private Long idProveedor;
    
    private int nitProveedor;

    private String nombreProveedor;

    private String usuarioProveedor;

    private String passProveedor;

    private String avatarProveedor;

    public ProveedorDTO(){
        
    }
    public ProveedorEntity toEntity(){
        ProveedorEntity proveedor = new ProveedorEntity();
        proveedor.setIdProveedor(this.idProveedor);
        proveedor.setNitProveedor(this.nitProveedor);
        proveedor.setNombreProveedor(this.nombreProveedor);
        proveedor.setUsuarioProveedor(this.usuarioProveedor);
        proveedor.setPassProveedor(this.passProveedor);
        proveedor.setAvatarProveedor(this.avatarProveedor);
        return proveedor;
    }
    
    public ProveedorDTO(ProveedorEntity proveedor){
        this.idProveedor = proveedor.getIdProveedor();
        this.nitProveedor = proveedor.getNitProveedor();
        this.nombreProveedor = proveedor.getNombreProveedor();
        this.usuarioProveedor = proveedor.getUsuarioProveedor();
        this.passProveedor = proveedor.getPassProveedor();
        this.avatarProveedor = proveedor.getAvatarProveedor();
    }
    
    public static List<ProveedorDTO> toProveedorList(List<ProveedorEntity> proveedorList){
        List<ProveedorDTO> listaProveedores = new ArrayList<>();
        for (int i=0; i<proveedorList.size(); i++){
            listaProveedores.add(new ProveedorDTO(proveedorList.get(i)));
        }
        return listaProveedores;
    }
    
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
