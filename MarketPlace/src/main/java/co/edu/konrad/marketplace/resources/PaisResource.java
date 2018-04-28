/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.resources;

import co.edu.konrad.marketplace.dto.PaisDTO;
import co.edu.konrad.marketplace.entities.PaisEntity;
import co.edu.konrad.marketplace.logic.PaisLogic;
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
 * Recurso del pais
 * @author DarkFACS
 */
@Path("/paises")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PaisResource {
    
    @EJB
    private PaisLogic paisLogic;
    
    @GET
    public List<PaisDTO> getPaisList(){
        List<PaisEntity> paises = paisLogic.obtenerPaises();
        return PaisDTO.toPaisList(paises);
    }
    
    @GET
    @Path("{id: \\d+}")
    public PaisDTO getPais(@PathParam("id")Long id){
        PaisEntity pais = paisLogic.obtenerPaisPorId(id);
        if (pais == null){
            throw new RuntimeException("El pais no existe");
        }
        return new PaisDTO(pais);
    }
    
    @POST
    public PaisDTO createPais(PaisDTO pais){
        return new PaisDTO(paisLogic.crearPais(pais.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public PaisDTO updatePais(@PathParam("id")Long id, PaisDTO pais){
        PaisEntity paisEntity = paisLogic.obtenerPaisPorId(id);
        if (paisEntity == null){
            throw new RuntimeException("El pais no existe");
        }
        return new PaisDTO(paisLogic.actualizarPais(id, pais.toEntity()));
    }
    
    @DELETE
    @Path("{paisId: \\d+}")
    public void deletePais(@PathParam("paisId")Long id){
        PaisEntity paisEntity = paisLogic.obtenerPaisPorId(id);
        if (paisEntity == null){
            throw new RuntimeException("El pais no existe");
        }
        paisLogic.eliminarPais(id);
    }
}
