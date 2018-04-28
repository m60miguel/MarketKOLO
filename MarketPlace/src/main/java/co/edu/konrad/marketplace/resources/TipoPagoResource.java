/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.resources;

import co.edu.konrad.marketplace.dto.TipoPagoDTO;
import co.edu.konrad.marketplace.entities.TipoPagoEntity;
import co.edu.konrad.marketplace.logic.TipoPagoLogic;
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
 * Recurso del tipo pago
 * @author DarkFACS
 */
@Path("/tipospago")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TipoPagoResource {
    
    @EJB
    private TipoPagoLogic tipoPagoLogic;
    
    @GET
    public List<TipoPagoDTO> getTipoPagoList(){
        List<TipoPagoEntity> tiposPago = tipoPagoLogic.obtenerTiposPago();
        return TipoPagoDTO.toTipoPagoList(tiposPago);
    }
    
    @GET
    @Path("{id: \\d+}")
    public TipoPagoDTO getTipoPago(@PathParam("id")Long id){
        TipoPagoEntity tipoPago = tipoPagoLogic.obtenerTipoPagoPorId(id);
        if (tipoPago == null){
            throw new RuntimeException("El tipo pago no existe");
        }
        return new TipoPagoDTO(tipoPago);
    }
    
    @POST
    public TipoPagoDTO createTipoPago(TipoPagoDTO tipoPago){
        return new TipoPagoDTO(tipoPagoLogic.crearTipoPago(tipoPago.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public TipoPagoDTO updateTipoPago(@PathParam("id")Long id, TipoPagoDTO tipoPago){
        TipoPagoEntity tipoPagoEntity = tipoPagoLogic.obtenerTipoPagoPorId(id);
        if (tipoPagoEntity == null){
            throw new RuntimeException("El tipo pago no existe");
        }
        return new TipoPagoDTO(tipoPagoLogic.actualizarTipoPago(id, tipoPago.toEntity()));
    }
    
    @DELETE
    @Path("{tipoPagoId: \\d+}")
    public void deleteTipoPago(@PathParam("tipoPagoId")Long id){
        TipoPagoEntity tipoPagoEntity = tipoPagoLogic.obtenerTipoPagoPorId(id);
        if (tipoPagoEntity == null){
            throw new RuntimeException("El tipo pago no existe");
        }
        tipoPagoLogic.eliminarTipoPago(id);
    }
}
