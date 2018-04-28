/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.resources;

import co.edu.konrad.marketplace.dto.ProveedorProductoDTO;
import co.edu.konrad.marketplace.entities.ProveedorProductoEntity;
import co.edu.konrad.marketplace.logic.ProveedorProductoLogic;
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
 * Recurso del proveedor producto
 * @author DarkFACS
 */
@Path("/proveedoresproductos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProveedorProductoResource {
    
    @EJB
    private ProveedorProductoLogic proveedorProductoLogic;
    
    @GET
    public List<ProveedorProductoDTO> getProveedorProductoList(){
        List<ProveedorProductoEntity> proveedoresProductos = proveedorProductoLogic.obtenerProveedoresProductos();
        return ProveedorProductoDTO.toProveedorProductoList(proveedoresProductos);
    }
    
    @GET
    @Path("{id: \\d+}")
    public ProveedorProductoDTO getProveedorProducto(@PathParam("id")Long id){
        ProveedorProductoEntity proveedorProducto = proveedorProductoLogic.obtenerProveedorProductoPorId(id);
        if (proveedorProducto == null){
            throw new RuntimeException("El proveedor producto no existe");
        }
        return new ProveedorProductoDTO(proveedorProducto);
    }
    
    @POST
    public ProveedorProductoDTO createProveedorProducto(ProveedorProductoDTO proveedorProducto){
        return new ProveedorProductoDTO(proveedorProductoLogic.crearProveedorProducto(proveedorProducto.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public ProveedorProductoDTO updateProveedorProducto(@PathParam("id")Long id, ProveedorProductoDTO proveedorProducto){
        ProveedorProductoEntity proveedorProductoEntity = proveedorProductoLogic.obtenerProveedorProductoPorId(id);
        if (proveedorProductoEntity == null){
            throw new RuntimeException("El proveedor producto no existe");
        }
        return new ProveedorProductoDTO(proveedorProductoLogic.actualizarProveedorProducto(id, proveedorProducto.toEntity()));
    }
    
    @DELETE
    @Path("{proveedorProductoId: \\d+}")
    public void deleteProveedorProducto(@PathParam("proveedorProductoId")Long id){
        ProveedorProductoEntity proveedorProductoEntity = proveedorProductoLogic.obtenerProveedorProductoPorId(id);
        if (proveedorProductoEntity == null){
            throw new RuntimeException("El proveedor producto no existe");
        }
        proveedorProductoLogic.eliminarProveedorProducto(id);
    }
}
