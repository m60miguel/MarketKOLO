/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.dto;

import co.edu.konrad.marketplace.entities.ComunicacionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DarkFACS
 */
public class ComunicacionDTO {
    
    private Long idComunicacion;
    
    private String tipoComunicacion;

    private String descripcionComunicacion;

    private int proveedor;

    public ComunicacionDTO(){
        
    }
    public ComunicacionEntity toEntity(){
        ComunicacionEntity comunicacion = new ComunicacionEntity();
        comunicacion.setIdComunicacion(this.idComunicacion);
        comunicacion.setTipoComunicacion(this.tipoComunicacion);
        comunicacion.setDescripcionComunicacion(this.descripcionComunicacion);
        comunicacion.setProveedorId(this.proveedor);
        return comunicacion;
    }
    
    public ComunicacionDTO(ComunicacionEntity comunicacion){
        this.idComunicacion = comunicacion.getIdComunicacion();
        this.tipoComunicacion = comunicacion.getTipoComunicacion();
        this.descripcionComunicacion = comunicacion.getDescripcionComunicacion();
        this.proveedor  = comunicacion.getProveedorId();
    }
    
    public static List<ComunicacionDTO> toComunicacionList(List<ComunicacionEntity> comunicacionList){
        List<ComunicacionDTO> listaComunicaciones = new ArrayList<>();
        for (int i=0; i<comunicacionList.size(); i++){
            listaComunicaciones.add(new ComunicacionDTO(comunicacionList.get(i)));
        }
        return listaComunicaciones;
    }
    
    public Long getIdComunicacion() {
        return idComunicacion;
    }

    public void setIdComunicacion(Long idComunicacion) {
        this.idComunicacion = idComunicacion;
    }

    public String getTipoComunicacion() {
        return tipoComunicacion;
    }

    public void setTipoComunicacion(String tipoComunicacion) {
        this.tipoComunicacion = tipoComunicacion;
    }

    public String getDescripcionComunicacion() {
        return descripcionComunicacion;
    }

    public void setDescripcionComunicacion(String descripcionComunicacion) {
        this.descripcionComunicacion = descripcionComunicacion;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }
}
