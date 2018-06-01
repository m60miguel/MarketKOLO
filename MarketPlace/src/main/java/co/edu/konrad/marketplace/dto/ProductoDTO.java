/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.dto;

import co.edu.konrad.marketplace.entities.ProductoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DarkFACS
 */
public class ProductoDTO {
    
    private Long idProducto;

    private String nombreProducto;

    private String marcaProducto;

    private int valorProducto;

    private int garantiaProducto;
    
    private String imagenProducto;

    private int tipoProducto;

    public ProductoDTO(){
        
    }
    public ProductoEntity toEntity(){
        ProductoEntity producto = new ProductoEntity();
        producto.setIdProducto(this.idProducto);
        producto.setNombreProducto(this.nombreProducto);
        producto.setMarcaProducto(this.marcaProducto);
        producto.setValorProducto(this.valorProducto);
        producto.setGarantiaProducto(this.garantiaProducto);
        producto.setImagenProducto(this.imagenProducto);
        producto.setTipoProductoId(this.tipoProducto);
        return producto;
    }
    
    public ProductoDTO(ProductoEntity producto){
        this.idProducto = producto.getIdProducto();
        this.nombreProducto = producto.getNombreProducto();
        this.marcaProducto = producto.getMarcaProducto();
        this.valorProducto = producto.getValorProducto();
        this.garantiaProducto = producto.getGarantiaProducto();
        this.imagenProducto = producto.getImagenProducto();
        this.tipoProducto = producto.getTipoProductoId();
    }
    
    public static List<ProductoDTO> toProductoList(List<ProductoEntity> productoList){
        List<ProductoDTO> listaProductos = new ArrayList<>();
        for (int i=0; i<productoList.size(); i++){
            listaProductos.add(new ProductoDTO(productoList.get(i)));
        }
        return listaProductos;
    }
    
    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public int getValorProducto() {
        return valorProducto;
    }

    public void setValorProducto(int valorProducto) {
        this.valorProducto = valorProducto;
    }

    public int getGarantiaProducto() {
        return garantiaProducto;
    }

    public void setGarantiaProducto(int garantiaProducto) {
        this.garantiaProducto = garantiaProducto;
    }

    public int getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(int tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }
}
