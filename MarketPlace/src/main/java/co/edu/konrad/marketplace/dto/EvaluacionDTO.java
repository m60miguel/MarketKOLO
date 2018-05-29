/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.dto;

import co.edu.konrad.marketplace.entities.EvaluacionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DarkFACS
 */
public class EvaluacionDTO {
    
    private Long idEvaluacion;

    private int calificacionEvaluacion;

    private String comentarioEvaluacion;

    private int producto;

    public EvaluacionDTO(){
        
    }
    public EvaluacionEntity toEntity(){
        EvaluacionEntity evaluacion = new EvaluacionEntity();
        evaluacion.setIdEvaluacion(this.idEvaluacion);
        evaluacion.setCalificacionEvaluacion(this.calificacionEvaluacion);
        evaluacion.setComentarioEvaluacion(this.comentarioEvaluacion);
        evaluacion.setProductoId(this.producto);
        return evaluacion;
    }
    
    public EvaluacionDTO(EvaluacionEntity evaluacion){
        this.idEvaluacion = evaluacion.getIdEvaluacion();
        this.calificacionEvaluacion = evaluacion.getCalificacionEvaluacion();
        this.comentarioEvaluacion = evaluacion.getComentarioEvaluacion();
        this.producto = evaluacion.getProductoId();
    }
    
    public static List<EvaluacionDTO> toEvaluacionList(List<EvaluacionEntity> evaluacionList){
        List<EvaluacionDTO> listaEvaluaciones = new ArrayList<>();
        for (int i=0; i<evaluacionList.size(); i++){
            listaEvaluaciones.add(new EvaluacionDTO(evaluacionList.get(i)));
        }
        return listaEvaluaciones;
    }
    
    public Long getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(Long idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public int getCalificacionEvaluacion() {
        return calificacionEvaluacion;
    }

    public void setCalificacionEvaluacion(int calificacionEvaluacion) {
        this.calificacionEvaluacion = calificacionEvaluacion;
    }

    public String getComentarioEvaluacion() {
        return comentarioEvaluacion;
    }

    public void setComentarioEvaluacion(String comentarioEvaluacion) {
        this.comentarioEvaluacion = comentarioEvaluacion;
    }

    public int getProductoId() {
        return producto;
    }

    public void setProductoId(int producto) {
        this.producto = producto;
    }
}
