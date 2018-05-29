/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.dto;

import co.edu.konrad.marketplace.entities.TipoProductoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DarkFACS
 */
public class TipoProductoDTO {
    
    private Long idTProducto;

    private String nombreTProducto;

    private String descripcionTProducto;

    public TipoProductoDTO(){
        
    }
    public TipoProductoEntity toEntity(){
        TipoProductoEntity tipoProducto = new TipoProductoEntity();
        tipoProducto.setIdTProducto(this.idTProducto);
        tipoProducto.setNombreTProducto(this.nombreTProducto);
        tipoProducto.setDescripcionTProducto(this.descripcionTProducto);
        return tipoProducto;
    }
    
    public TipoProductoDTO(TipoProductoEntity tipoProducto){
        this.idTProducto = tipoProducto.getIdTProducto();
        this.nombreTProducto = tipoProducto.getNombreTProducto();
        this.descripcionTProducto = tipoProducto.getDescripcionTProducto();
    }
    
    public static List<TipoProductoDTO> toTipoProductoList(List<TipoProductoEntity> tipoProductoList){
        List<TipoProductoDTO> listaTipoProducto = new ArrayList<>();
        for (int i=0; i<tipoProductoList.size();i++){
            listaTipoProducto.add(new TipoProductoDTO(tipoProductoList.get(i)));
        }
        return listaTipoProducto;
    }
    
    public Long getIdTProducto() {
        return idTProducto;
    }

    public void setIdTProducto(Long idTProducto) {
        this.idTProducto = idTProducto;
    }

    public String getNombreTProducto() {
        return nombreTProducto;
    }

    public void setNombreTProducto(String nombreTProducto) {
        this.nombreTProducto = nombreTProducto;
    }

    public String getDescripcionTProducto() {
        return descripcionTProducto;
    }

    public void setDescripcionTProducto(String descripcionTProducto) {
        this.descripcionTProducto = descripcionTProducto;
    }
}
