/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.resources;

import co.edu.konrad.marketplace.dto.DatosPagoDTO;
import co.edu.konrad.marketplace.entities.DatosPagoEntity;
import co.edu.konrad.marketplace.logic.DatosPagoLogic;
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
 * Recurso del datoPago
 * @author DarkFACS
 */
@Path("/datospago")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DatosPagoResource {
    
    @EJB
    private DatosPagoLogic datoPagoLogic;
    
    @GET
    public List<DatosPagoDTO> getDatosPagoList(){
        List<DatosPagoEntity> datosPago = datoPagoLogic.obtenerDatosPago();
        return DatosPagoDTO.toDatosPagoList(datosPago);
    }
    
    @GET
    @Path("{id: \\d+}")
    public DatosPagoDTO getDatoPago(@PathParam("id")Long id){
        DatosPagoEntity datoPago = datoPagoLogic.obtenerDatoPagoPorId(id);
        if (datoPago == null){
            throw new RuntimeException("El dato de pago no existe");
        }
        return new DatosPagoDTO(datoPago);
    }
    
    @POST
    public DatosPagoDTO createDatoPago(DatosPagoDTO datoPago){
        return new DatosPagoDTO(datoPagoLogic.crearDatoPago(datoPago.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public DatosPagoDTO updateDatoPago(@PathParam("id")Long id, DatosPagoDTO datoPago){
        DatosPagoEntity datoPagoEntity = datoPagoLogic.obtenerDatoPagoPorId(id);
        if (datoPagoEntity == null){
            throw new RuntimeException("El dato de pago no existe");
        }
        return new DatosPagoDTO(datoPagoLogic.actualizarDatoPago(id, datoPago.toEntity()));
    }
    
    @DELETE
    @Path("{datoPagoId: \\d+}")
    public void deleteDatoPago(@PathParam("datoPagoId")Long id){
        DatosPagoEntity datoPagoEntity = datoPagoLogic.obtenerDatoPagoPorId(id);
        if (datoPagoEntity == null){
            throw new RuntimeException("El dato de pago no existe");
        }
        datoPagoLogic.eliminarDatoPago(id);
    }
}
