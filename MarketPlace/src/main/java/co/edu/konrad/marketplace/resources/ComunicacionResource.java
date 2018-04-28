/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.resources;

import co.edu.konrad.marketplace.dto.ComunicacionDTO;
import co.edu.konrad.marketplace.entities.ComunicacionEntity;
import co.edu.konrad.marketplace.logic.ComunicacionLogic;
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
 * Recurso del comunicacion
 * @author DarkFACS
 */
@Path("/comunicaciones")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ComunicacionResource {
    
    @EJB
    private ComunicacionLogic comunicacionLogic;
    
    @GET
    public List<ComunicacionDTO> getComunicacionList(){
        List<ComunicacionEntity> comunicaciones = comunicacionLogic.obtenerComunicaciones();
        return ComunicacionDTO.toComunicacionList(comunicaciones);
    }
    
    @GET
    @Path("{id: \\d+}")
    public ComunicacionDTO getComunicacion(@PathParam("id")Long id){
        ComunicacionEntity comunicacion = comunicacionLogic.obtenerComunicacionPorId(id);
        if (comunicacion == null){
            throw new RuntimeException("La comunicacion no existe");
        }
        return new ComunicacionDTO(comunicacion);
    }
    
    @POST
    public ComunicacionDTO createComunicacion(ComunicacionDTO comunicacion){
        return new ComunicacionDTO(comunicacionLogic.crearComunicacion(comunicacion.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public ComunicacionDTO updateComunicacion(@PathParam("id")Long id, ComunicacionDTO comunicacion){
        ComunicacionEntity comunicacionEntity = comunicacionLogic.obtenerComunicacionPorId(id);
        if (comunicacionEntity == null){
            throw new RuntimeException("La comunicacion no existe");
        }
        return new ComunicacionDTO(comunicacionLogic.actualizarComunicacion(id, comunicacion.toEntity()));
    }
    
    @DELETE
    @Path("{comunicacionId: \\d+}")
    public void deleteComunicacion(@PathParam("comunicacionId")Long id){
        ComunicacionEntity comunicacionEntity = comunicacionLogic.obtenerComunicacionPorId(id);
        if (comunicacionEntity == null){
            throw new RuntimeException("La comunicacion no existe");
        }
        comunicacionLogic.eliminarComunicacion(id);
    }
}
