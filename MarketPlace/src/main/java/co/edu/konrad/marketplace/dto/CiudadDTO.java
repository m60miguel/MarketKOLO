/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.dto;

import co.edu.konrad.marketplace.entities.CiudadEntity;
import co.edu.konrad.marketplace.entities.PaisEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DarkFACS
 */
public class CiudadDTO {
    
    private Long idCiudad;

    private int codigoCiudad;

    private String nombreCiudad;
    
    private PaisEntity pais;
    
    public CiudadDTO(){
        
    }
    public CiudadEntity toEntity(){
        CiudadEntity ciudad = new CiudadEntity();
        ciudad.setIdCiudad(this.idCiudad);
        ciudad.setCodigoCiudad(this.codigoCiudad);
        ciudad.setNombreCiudad(this.nombreCiudad);
        ciudad.setPais(this.pais);
        return ciudad;
    }
    
    public CiudadDTO(CiudadEntity ciudad){
        this.idCiudad = ciudad.getIdCiudad();
        this.codigoCiudad = ciudad.getCodigoCiudad();
        this.nombreCiudad = ciudad.getNombreCiudad();
        this.pais = ciudad.getPais();
    }
    
    public static List<CiudadDTO> toCiudadList(List<CiudadEntity> ciudadList){
        List<CiudadDTO> listaCiudades = new ArrayList<>();
        for (int i=0; i<ciudadList.size();i++){
            listaCiudades.add(new CiudadDTO(ciudadList.get(i)));
        }
        return listaCiudades;
    }

    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public int getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(int codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public PaisEntity getPais() {
        return pais;
    }

    public void setPais(PaisEntity pais) {
        this.pais = pais;
    }

}
