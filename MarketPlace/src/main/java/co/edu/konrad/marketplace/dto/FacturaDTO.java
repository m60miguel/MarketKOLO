/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.dto;

import co.edu.konrad.marketplace.entities.FacturaEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DarkFACS
 */
public class FacturaDTO {
    
    private Long idFactura;

    private Date fechaCompra;

    private int cantidadCompra;

    private int cliente;

    private int producto;

    public FacturaDTO(){
        
    }
    public FacturaEntity toEntity(){
        FacturaEntity factura = new FacturaEntity();
        factura.setIdFactura(this.idFactura);
        factura.setFechaCompra(this.fechaCompra);
        factura.setCantidadCompra(this.cantidadCompra);
        factura.setClienteId(this.cliente);
        factura.setProductoId(this.producto);
        return factura;
    }
    
    public FacturaDTO(FacturaEntity factura){
        this.idFactura = factura.getIdFactura();
        this.fechaCompra = factura.getFechaCompra();
        this.cantidadCompra = factura.getCantidadCompra();
        this.cliente = factura.getClienteId();
        this.producto = factura.getProductoId();
    }
    
    public static List<FacturaDTO> toFacturaList(List<FacturaEntity> facturaList){
        List<FacturaDTO> listaFacturas = new ArrayList<>();
        for (int i=0; i<facturaList.size(); i++){
            listaFacturas.add(new FacturaDTO(facturaList.get(i)));
        }
        return listaFacturas;
    }
    
    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getCantidadCompra() {
        return cantidadCompra;
    }

    public void setCantidadCompra(int cantidadCompra) {
        this.cantidadCompra = cantidadCompra;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }
}
