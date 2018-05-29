/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.dto;

import co.edu.konrad.marketplace.entities.DatosPagoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DarkFACS
 */
public class DatosPagoDTO {
    
    private Long idDatosPago;

    private String nombreBanco;

    private int nroCuenta;

    private String franquiciaBanco;

    private int nroTarjeta;

    private int codClave;

    private int cliente;

    private int tipoPago;

    public DatosPagoDTO(){
        
    }
    public DatosPagoEntity toEntity(){
        DatosPagoEntity datosPago = new DatosPagoEntity();
        datosPago.setIdDatosPago(this.idDatosPago);
        datosPago.setNombreBanco(this.nombreBanco);
        datosPago.setNroCuenta(this.nroCuenta);
        datosPago.setFranquiciaBanco(this.franquiciaBanco);
        datosPago.setNroTarjeta(this.nroTarjeta);
        datosPago.setCodClave(this.codClave);
        datosPago.setClienteId(this.cliente);
        datosPago.setTipoPagoId(this.tipoPago);
        return datosPago;
    }
    
    public DatosPagoDTO(DatosPagoEntity datosPago){
        this.idDatosPago = datosPago.getIdDatosPago();
        this.nombreBanco = datosPago.getNombreBanco();
        this.nroCuenta = datosPago.getNroCuenta();
        this.franquiciaBanco  = datosPago.getFranquiciaBanco();
        this.nroTarjeta  = datosPago.getNroTarjeta();
        this.codClave = datosPago.getCodClave();
        this.cliente  = datosPago.getClienteId();
        this.tipoPago  = datosPago.getTipoPagoId();
    }
    
    public static List<DatosPagoDTO> toDatosPagoList(List<DatosPagoEntity> datosPagoList){
        List<DatosPagoDTO> listaDatosPagos = new ArrayList<>();
        for (int i=0; i<datosPagoList.size(); i++){
            listaDatosPagos.add(new DatosPagoDTO(datosPagoList.get(i)));
        }
        return listaDatosPagos;
    }
    
    public Long getIdDatosPago() {
        return idDatosPago;
    }

    public void setIdDatosPago(Long idDatosPago) {
        this.idDatosPago = idDatosPago;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getFranquiciaBanco() {
        return franquiciaBanco;
    }

    public void setFranquiciaBanco(String franquiciaBanco) {
        this.franquiciaBanco = franquiciaBanco;
    }

    public int getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(int nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public int getCodClave() {
        return codClave;
    }

    public void setCodClave(int codClave) {
        this.codClave = codClave;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(int tipoPago) {
        this.tipoPago = tipoPago;
    }
}
