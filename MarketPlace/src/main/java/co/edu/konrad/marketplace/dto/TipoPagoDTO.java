/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.dto;

import co.edu.konrad.marketplace.entities.TipoPagoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DarkFACS
 */
public class TipoPagoDTO {
    
    private Long idTPago;

    private String nombreTPago;
    
    public TipoPagoDTO(){
        
    }
    public TipoPagoEntity toEntity(){
        TipoPagoEntity tipoPago = new TipoPagoEntity();
        tipoPago.setIdTPago(this.idTPago);
        tipoPago.setNombreTPago(this.nombreTPago);
        return tipoPago;
    }
    
    public TipoPagoDTO(TipoPagoEntity tipoPago){
        this.idTPago = tipoPago.getIdTPago();
        this.nombreTPago = tipoPago.getNombreTPago();
    }
    
    public static List<TipoPagoDTO> toTipoPagoList(List<TipoPagoEntity> tipoPagoList){
        List<TipoPagoDTO> listaTipoPago = new ArrayList<>();
        for (int i=0; i<tipoPagoList.size();i++){
            listaTipoPago.add(new TipoPagoDTO(tipoPagoList.get(i)));
        }
        return listaTipoPago;
    }

    public Long getIdTPago() {
        return idTPago;
    }

    public void setIdTPago(Long idTPago) {
        this.idTPago = idTPago;
    }

    public String getNombreTPago() {
        return nombreTPago;
    }

    public void setNombreTPago(String nombreTPago) {
        this.nombreTPago = nombreTPago;
    }

}
