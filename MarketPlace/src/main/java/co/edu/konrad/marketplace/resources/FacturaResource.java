/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.resources;

import co.edu.konrad.marketplace.dto.FacturaDTO;
import co.edu.konrad.marketplace.entities.FacturaEntity;
import co.edu.konrad.marketplace.logic.FacturaLogic;
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
 * Recurso de la factura
 * @author DarkFACS
 */
@Path("/facturas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FacturaResource {
    
    @EJB
    private FacturaLogic facturaLogic;
    
    @GET
    public List<FacturaDTO> getFacturaList(){
        List<FacturaEntity> facturas = facturaLogic.obtenerFacturas();
        return FacturaDTO.toFacturaList(facturas);
    }
    
    @GET
    @Path("{id: \\d+}")
    public FacturaDTO getFactura(@PathParam("id")Long id){
        FacturaEntity factura = facturaLogic.obtenerFacturaPorId(id);
        if (factura == null){
            throw new RuntimeException("La factura no existe");
        }
        return new FacturaDTO(factura);
    }
    
    @POST
    public FacturaDTO createFactura(FacturaDTO factura){
        return new FacturaDTO(facturaLogic.crearFactura(factura.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public FacturaDTO updateFactura(@PathParam("id")Long id, FacturaDTO factura){
        FacturaEntity facturaEntity = facturaLogic.obtenerFacturaPorId(id);
        if (facturaEntity == null){
            throw new RuntimeException("La factura no existe");
        }
        return new FacturaDTO(facturaLogic.actualizarFactura(id, factura.toEntity()));
    }
    
    @DELETE
    @Path("{facturaId: \\d+}")
    public void deleteFactura(@PathParam("facturaId")Long id){
        FacturaEntity facturaEntity = facturaLogic.obtenerFacturaPorId(id);
        if (facturaEntity == null){
            throw new RuntimeException("La factura no existe");
        }
        facturaLogic.eliminarFactura(id);
    }
}
