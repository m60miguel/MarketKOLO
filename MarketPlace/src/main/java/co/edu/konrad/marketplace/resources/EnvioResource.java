/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.resources;

import co.edu.konrad.marketplace.dto.EnvioDTO;
import co.edu.konrad.marketplace.entities.EnvioEntity;
import co.edu.konrad.marketplace.logic.EnvioLogic;
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
 * Recurso del envio
 * @author DarkFACS
 */
@Path("/envios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnvioResource {
    
    @EJB
    private EnvioLogic envioLogic;
    
    @GET
    public List<EnvioDTO> getEnvioList(){
        List<EnvioEntity> envios = envioLogic.obtenerEnvios();
        return EnvioDTO.toEnvioList(envios);
    }
    
    @GET
    @Path("{id: \\d+}")
    public EnvioDTO getEnvio(@PathParam("id")Long id){
        EnvioEntity envio = envioLogic.obtenerEnvioPorId(id);
        if (envio == null){
            throw new RuntimeException("El pago no existe");
        }
        return new EnvioDTO(envio);
    }
    
    @POST
    public EnvioDTO createEnvio(EnvioDTO envio){
        return new EnvioDTO(envioLogic.crearEnvio(envio.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public EnvioDTO updateEnvio(@PathParam("id")Long id, EnvioDTO envio){
        EnvioEntity envioEntity = envioLogic.obtenerEnvioPorId(id);
        if (envioEntity == null){
            throw new RuntimeException("El pago no existe");
        }
        return new EnvioDTO(envioLogic.actualizarEnvio(id, envio.toEntity()));
    }
    
    @DELETE
    @Path("{envioId: \\d+}")
    public void deleteEnvio(@PathParam("envioId")Long id){
        EnvioEntity envioEntity = envioLogic.obtenerEnvioPorId(id);
        if (envioEntity == null){
            throw new RuntimeException("El pago no existe");
        }
        envioLogic.eliminarEnvio(id);
    }
}
