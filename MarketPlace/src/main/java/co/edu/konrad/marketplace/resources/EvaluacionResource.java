/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.resources;

import co.edu.konrad.marketplace.dto.EvaluacionDTO;
import co.edu.konrad.marketplace.entities.EvaluacionEntity;
import co.edu.konrad.marketplace.logic.EvaluacionLogic;
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
 * Recurso de la evaluacion
 * @author DarkFACS
 */
@Path("/evaluaciones")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EvaluacionResource {
    
    @EJB
    private EvaluacionLogic evaluacionLogic;
    
    @GET
    public List<EvaluacionDTO> getEvaluacionList(){
        List<EvaluacionEntity> evaluaciones = evaluacionLogic.obtenerEvaluaciones();
        return EvaluacionDTO.toEvaluacionList(evaluaciones);
    }
    
    @GET
    @Path("{id: \\d+}")
    public EvaluacionDTO getEvaluacion(@PathParam("id")Long id){
        EvaluacionEntity evaluacion = evaluacionLogic.obtenerEvaluacionPorId(id);
        if (evaluacion == null){
            throw new RuntimeException("La evaluacion no existe");
        }
        return new EvaluacionDTO(evaluacion);
    }
    
    @POST
    public EvaluacionDTO createEvaluacion(EvaluacionDTO evaluacion){
        return new EvaluacionDTO(evaluacionLogic.crearEvaluacion(evaluacion.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public EvaluacionDTO updateEvaluacion(@PathParam("id")Long id, EvaluacionDTO evaluacion){
        EvaluacionEntity evaluacionEntity = evaluacionLogic.obtenerEvaluacionPorId(id);
        if (evaluacionEntity == null){
            throw new RuntimeException("La evaluacion no existe");
        }
        return new EvaluacionDTO(evaluacionLogic.actualizarEvaluacion(id, evaluacion.toEntity()));
    }
    
    @DELETE
    @Path("{evaluacionId: \\d+}")
    public void deleteEvaluacion(@PathParam("evaluacionId")Long id){
        EvaluacionEntity evaluacionEntity = evaluacionLogic.obtenerEvaluacionPorId(id);
        if (evaluacionEntity == null){
            throw new RuntimeException("La evaluacion no existe");
        }
        evaluacionLogic.eliminarEvaluacion(id);
    }
}
