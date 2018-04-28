/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.dto;

import co.edu.konrad.marketplace.entities.DatosFinancierosEntity;
import co.edu.konrad.marketplace.entities.ProveedorEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DarkFACS
 */
public class DatosFinancierosDTO {
    
    private Long iddFinancieros;

    private int ventasAnuales;

    private String mercadoObjetivo;

    private String nivelreputacion;

    private ProveedorEntity proveedor;
    
    public DatosFinancierosDTO(){
        
    }
    public DatosFinancierosEntity toEntity(){
        DatosFinancierosEntity datosFinancieros = new DatosFinancierosEntity();
        datosFinancieros.setIddFinancieros(this.iddFinancieros);
        datosFinancieros.setVentasAnuales(this.ventasAnuales);
        datosFinancieros.setMercadoObjetivo(this.mercadoObjetivo);
        datosFinancieros.setNivelreputacion(this.nivelreputacion);
        datosFinancieros.setProveedor(this.proveedor);
        return datosFinancieros;
    }
    
    public DatosFinancierosDTO(DatosFinancierosEntity datosFinancieros){
        this.iddFinancieros = datosFinancieros.getIddFinancieros();
        this.ventasAnuales = datosFinancieros.getVentasAnuales();
        this.mercadoObjetivo = datosFinancieros.getMercadoObjetivo();
        this.nivelreputacion  = datosFinancieros.getNivelreputacion();
        this.proveedor  = datosFinancieros.getProveedor();
    }
    
    public static List<DatosFinancierosDTO> toDatosFinancierosList(List<DatosFinancierosEntity> datosFinancierosList){
        List<DatosFinancierosDTO> listaDatosFinancieros = new ArrayList<>();
        for (int i=0; i<datosFinancierosList.size(); i++){
            listaDatosFinancieros.add(new DatosFinancierosDTO(datosFinancierosList.get(i)));
        }
        return listaDatosFinancieros;
    }

    public Long getIddFinancieros() {
        return iddFinancieros;
    }

    public void setIddFinancieros(Long iddFinancieros) {
        this.iddFinancieros = iddFinancieros;
    }

    public int getVentasAnuales() {
        return ventasAnuales;
    }

    public void setVentasAnuales(int ventasAnuales) {
        this.ventasAnuales = ventasAnuales;
    }

    public String getMercadoObjetivo() {
        return mercadoObjetivo;
    }

    public void setMercadoObjetivo(String mercadoObjetivo) {
        this.mercadoObjetivo = mercadoObjetivo;
    }

    public String getNivelreputacion() {
        return nivelreputacion;
    }

    public void setNivelreputacion(String nivelreputacion) {
        this.nivelreputacion = nivelreputacion;
    }

    public ProveedorEntity getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorEntity proveedor) {
        this.proveedor = proveedor;
    } 
}
