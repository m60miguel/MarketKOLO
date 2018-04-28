/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.resources;

import co.edu.konrad.marketplace.dto.CiudadDTO;
import co.edu.konrad.marketplace.entities.CiudadEntity;
import co.edu.konrad.marketplace.logic.CiudadLogic;
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
 * Recurso del ciudad
 * @author DarkFACS
 */
@Path("/ciudades")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CiudadResource {
    
    @EJB
    private CiudadLogic ciudadLogic;
    
    @GET
    public List<CiudadDTO> getCiudadList(){
        List<CiudadEntity> ciudades = ciudadLogic.obtenerCiudades();
        return CiudadDTO.toCiudadList(ciudades);
    }
    
    @GET
    @Path("{id: \\d+}")
    public CiudadDTO getCiudad(@PathParam("id")Long id){
        CiudadEntity ciudad = ciudadLogic.obtenerCiudadPorId(id);
        if (ciudad == null){
            throw new RuntimeException("La ciudad no existe");
        }
        return new CiudadDTO(ciudad);
    }
    
    @POST
    public CiudadDTO createCiudad(CiudadDTO ciudad){
        return new CiudadDTO(ciudadLogic.crearCiudad(ciudad.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public CiudadDTO updateCiudad(@PathParam("id")Long id, CiudadDTO ciudad){
        CiudadEntity ciudadEntity = ciudadLogic.obtenerCiudadPorId(id);
        if (ciudadEntity == null){
            throw new RuntimeException("La ciudad no existe");
        }
        return new CiudadDTO(ciudadLogic.actualizarCiudad(id, ciudad.toEntity()));
    }
    
    @DELETE
    @Path("{ciudadId: \\d+}")
    public void deleteCiudad(@PathParam("ciudadId")Long id){
        CiudadEntity ciudadEntity = ciudadLogic.obtenerCiudadPorId(id);
        if (ciudadEntity == null){
            throw new RuntimeException("La ciudad no existe");
        }
        ciudadLogic.eliminarCiudad(id);
    }
}
