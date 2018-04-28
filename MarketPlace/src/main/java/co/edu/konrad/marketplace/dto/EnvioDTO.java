/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.dto;

import co.edu.konrad.marketplace.entities.CiudadEntity;
import co.edu.konrad.marketplace.entities.EnvioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DarkFACS
 */
public class EnvioDTO {
    
    private Long idEnvio;
    
    private String direccionEnvio;

    private CiudadEntity ciudad;
    
    public EnvioDTO(){
        
    }
    public EnvioEntity toEntity(){
        EnvioEntity envio = new EnvioEntity();
        envio.setIdEnvio(this.idEnvio);
        envio.setDireccionEnvio(this.direccionEnvio);
        envio.setCiudad(this.ciudad);
        return envio;
    }
    
    public EnvioDTO(EnvioEntity envio){
        this.idEnvio = envio.getIdEnvio();
        this.direccionEnvio = envio.getDireccionEnvio();
        this.ciudad = envio.getCiudad();
    }
    
    public static List<EnvioDTO> toEnvioList(List<EnvioEntity> envioList){
        List<EnvioDTO> listaEnvios = new ArrayList<>();
        for (int i=0; i<envioList.size(); i++){
            listaEnvios.add(new EnvioDTO(envioList.get(i)));
        }
        return listaEnvios;
    }

    public Long getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Long idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public CiudadEntity getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadEntity ciudad) {
        this.ciudad = ciudad;
    }
}
