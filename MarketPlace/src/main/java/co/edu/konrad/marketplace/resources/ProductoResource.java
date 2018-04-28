/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.resources;

import co.edu.konrad.marketplace.dto.ProductoDTO;
import co.edu.konrad.marketplace.entities.ProductoEntity;
import co.edu.konrad.marketplace.logic.ProductoLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Recurso del producto
 * @author DarkFACS
 */
@Path("/productos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductoResource {
    
    @EJB
    private ProductoLogic productoLogic;
    
    @GET
    public List<ProductoDTO> getProductoList(){
        List<ProductoEntity> productos = productoLogic.obtenerProductos();
        return ProductoDTO.toProductoList(productos);
    }
    
    @GET
    @Path("{id: \\d+}")
    public ProductoDTO getProducto(@PathParam("id")Long id){
        ProductoEntity producto = productoLogic.obtenerProductoPorId(id);
        if (producto == null){
            throw new RuntimeException("El producto no existe");
        }
        return new ProductoDTO(producto);
    }
    
    @POST
    public ProductoDTO createProducto(ProductoDTO producto){
        return new ProductoDTO(productoLogic.crearProducto(producto.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public ProductoDTO updateProducto(@PathParam("id")Long id, ProductoDTO producto){
        ProductoEntity productoEntity = productoLogic.obtenerProductoPorId(id);
        if (productoEntity == null){
            throw new RuntimeException("El producto no existe");
        }
        return new ProductoDTO(productoLogic.actualizarProducto(id, producto.toEntity()));
    }
    
    @DELETE
    @Path("{productoId: \\d+}")
    public void deleteProducto(@PathParam("productoId")Long id){
        ProductoEntity productoEntity = productoLogic.obtenerProductoPorId(id);
        if (productoEntity == null){
            throw new RuntimeException("El producto no existe");
        }
        productoLogic.eliminarProducto(id);
    }
}
