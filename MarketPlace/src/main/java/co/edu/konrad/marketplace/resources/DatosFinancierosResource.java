/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.resources;

import co.edu.konrad.marketplace.dto.DatosFinancierosDTO;
import co.edu.konrad.marketplace.entities.DatosFinancierosEntity;
import co.edu.konrad.marketplace.logic.DatosFinancierosLogic;
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
 * Recurso del datoFinanciero
 * @author DarkFACS
 */
@Path("/datosfinancieros")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DatosFinancierosResource {
    
    @EJB
    private DatosFinancierosLogic datoFinancieroLogic;
    
    @GET
    public List<DatosFinancierosDTO> getDatosFinancierosList(){
        List<DatosFinancierosEntity> datosFinancieros = datoFinancieroLogic.obtenerDatosFinancieros();
        return DatosFinancierosDTO.toDatosFinancierosList(datosFinancieros);
    }
    
    @GET
    @Path("{id: \\d+}")
    public DatosFinancierosDTO getDatoFinanciero(@PathParam("id")Long id){
        DatosFinancierosEntity datoFinanciero = datoFinancieroLogic.obtenerDatoFinancieroPorId(id);
        if (datoFinanciero == null){
            throw new RuntimeException("El dato financiero no existe");
        }
        return new DatosFinancierosDTO(datoFinanciero);
    }
    
    @POST
    public DatosFinancierosDTO createDatoFinanciero(DatosFinancierosDTO datoFinanciero){
        return new DatosFinancierosDTO(datoFinancieroLogic.crearDatoFinanciero(datoFinanciero.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public DatosFinancierosDTO updateDatoFinanciero(@PathParam("id")Long id, DatosFinancierosDTO datoFinanciero){
        DatosFinancierosEntity datoFinancieroEntity = datoFinancieroLogic.obtenerDatoFinancieroPorId(id);
        if (datoFinancieroEntity == null){
            throw new RuntimeException("El dato financiero no existe");
        }
        return new DatosFinancierosDTO(datoFinancieroLogic.actualizarDatoFinanciero(id, datoFinanciero.toEntity()));
    }
    
    @DELETE
    @Path("{datoFinancieroId: \\d+}")
    public void deleteDatoFinanciero(@PathParam("datoFinancieroId")Long id){
        DatosFinancierosEntity datoFinancieroEntity = datoFinancieroLogic.obtenerDatoFinancieroPorId(id);
        if (datoFinancieroEntity == null){
            throw new RuntimeException("El dato financiero no existe");
        }
        datoFinancieroLogic.eliminarDatoFinanciero(id);
    }
}
