/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.dto;

import co.edu.konrad.marketplace.entities.ProductoEntity;
import co.edu.konrad.marketplace.entities.ProveedorEntity;
import co.edu.konrad.marketplace.entities.ProveedorProductoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DarkFACS
 */
public class ProveedorProductoDTO {
    
    private Long idProveedorProducto;

    private String tipoProveedorProducto;

    private String descripcionProveedorProducto;

    private ProveedorEntity proveedor;

    private ProductoEntity producto;
    
    public ProveedorProductoDTO(){
        
    }
    public ProveedorProductoEntity toEntity(){
        ProveedorProductoEntity proveedorProducto = new ProveedorProductoEntity();
        proveedorProducto.setIdProveedorProducto(this.idProveedorProducto);
        proveedorProducto.setTipoProveedorProducto(this.tipoProveedorProducto);
        proveedorProducto.setDescripcionProveedorProducto(this.descripcionProveedorProducto);
        proveedorProducto.setProveedor(this.proveedor);
        proveedorProducto.setProducto(this.producto);
        return proveedorProducto;
    }
    
    public ProveedorProductoDTO(ProveedorProductoEntity proveedorProducto){
        this.idProveedorProducto = proveedorProducto.getIdProveedorProducto();
        this.tipoProveedorProducto = proveedorProducto.getTipoProveedorProducto();
        this.descripcionProveedorProducto = proveedorProducto.getDescripcionProveedorProducto();
        this.proveedor = proveedorProducto.getProveedor();
        this.producto = proveedorProducto.getProducto();
    }
    
    public static List<ProveedorProductoDTO> toProveedorProductoList(List<ProveedorProductoEntity> proveedorProductoList){
        List<ProveedorProductoDTO> listaProveedoresProductos = new ArrayList<>();
        for (int i=0; i<proveedorProductoList.size(); i++){
            listaProveedoresProductos.add(new ProveedorProductoDTO(proveedorProductoList.get(i)));
        }
        return listaProveedoresProductos;
    }

    public Long getIdProveedorProducto() {
        return idProveedorProducto;
    }

    public void setIdProveedorProducto(Long idProveedorProducto) {
        this.idProveedorProducto = idProveedorProducto;
    }

    public String getTipoProveedorProducto() {
        return tipoProveedorProducto;
    }

    public void setTipoProveedorProducto(String tipoProveedorProducto) {
        this.tipoProveedorProducto = tipoProveedorProducto;
    }

    public String getDescripcionProveedorProducto() {
        return descripcionProveedorProducto;
    }

    public void setDescripcionProveedorProducto(String descripcionProveedorProducto) {
        this.descripcionProveedorProducto = descripcionProveedorProducto;
    }

    public ProveedorEntity getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorEntity proveedor) {
        this.proveedor = proveedor;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }
}
