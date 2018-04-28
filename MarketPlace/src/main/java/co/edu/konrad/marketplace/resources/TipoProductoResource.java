/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.resources;

import co.edu.konrad.marketplace.dto.TipoProductoDTO;
import co.edu.konrad.marketplace.entities.TipoProductoEntity;
import co.edu.konrad.marketplace.logic.TipoProductoLogic;
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
 * Recurso del tipo Producto
 * @author DarkFACS
 */
@Path("/tiposproducto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TipoProductoResource {
    
    @EJB
    private TipoProductoLogic tipoPagoLogic;
    
    @GET
    public List<TipoProductoDTO> getTipoProductoList(){
        List<TipoProductoEntity> tiposProducto = tipoPagoLogic.obtenerTiposProducto();
        return TipoProductoDTO.toTipoProductoList(tiposProducto);
    }
    
    @GET
    @Path("{id: \\d+}")
    public TipoProductoDTO getTipoProducto(@PathParam("id")Long id){
        TipoProductoEntity tipoPago = tipoPagoLogic.obtenerTipoProductoPorId(id);
        if (tipoPago == null){
            throw new RuntimeException("El tipo producto no existe");
        }
        return new TipoProductoDTO(tipoPago);
    }
    
    @POST
    public TipoProductoDTO createTipoProducto(TipoProductoDTO tipoPago){
        return new TipoProductoDTO(tipoPagoLogic.crearTipoProducto(tipoPago.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public TipoProductoDTO updateTipoProducto(@PathParam("id")Long id, TipoProductoDTO tipoPago){
        TipoProductoEntity tipoPagoEntity = tipoPagoLogic.obtenerTipoProductoPorId(id);
        if (tipoPagoEntity == null){
            throw new RuntimeException("El tipo producto no existe");
        }
        return new TipoProductoDTO(tipoPagoLogic.actualizarTipoProducto(id, tipoPago.toEntity()));
    }
    
    @DELETE
    @Path("{tipoPagoId: \\d+}")
    public void deleteTipoProducto(@PathParam("tipoPagoId")Long id){
        TipoProductoEntity tipoPagoEntity = tipoPagoLogic.obtenerTipoProductoPorId(id);
        if (tipoPagoEntity == null){
            throw new RuntimeException("El tipo producto no existe");
        }
        tipoPagoLogic.eliminarTipoProducto(id);
    }
}
