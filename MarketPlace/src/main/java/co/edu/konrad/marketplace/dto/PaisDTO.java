/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.dto;

import co.edu.konrad.marketplace.entities.PaisEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DarkFACS
 */
public class PaisDTO {
    
    private Long idPais;
    
    private int codigoPais;

    private String nombrePais;

    public PaisDTO(){
        
    }
    public PaisEntity toEntity(){
        PaisEntity pais = new PaisEntity();
        pais.setIdPais(this.idPais);
        pais.setNombrePais(this.nombrePais);
        pais.setCodigoPais(this.codigoPais);
        return pais;
    }
    
    public PaisDTO(PaisEntity pais){
        this.idPais = pais.getIdPais();
        this.nombrePais = pais.getNombrePais();
        this.codigoPais = pais.getCodigoPais();
    }
    
    public static List<PaisDTO> toPaisList(List<PaisEntity> paisList){
        List<PaisDTO> listaPaiss = new ArrayList<>();
        for (int i=0; i<paisList.size();i++){
            listaPaiss.add(new PaisDTO(paisList.get(i)));
        }
        return listaPaiss;
    }
    
    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public int getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(int codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
}
