/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author DarkFACS
 */
@Entity
public class EvaluacionEntity implements Serializable {
    
    /**
     * Atributo estático para el manejo de versiones de la entidad
     */
    private static final long serialVersionUID= 1L;

    /**
     * Llave primaria de la Entidad Evaluacion
     */
    @Id
    @Column (name = "id_evaluacion", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEvaluacion;
    
    /**
     * Variable que almacena la calificacion de la evaluacion
     */
    @Column (name = "calificacion_evaluacion")
    private int calificacionEvaluacion;
    
    /**
     * Variable que almacena el comentario de la evaluacion
     */
    @Column (name = "comentario_evaluacion")
    private String comentarioEvaluacion;

    @ManyToOne
    @JoinColumn (name = "id_producto")
    private ProductoEntity producto;

    /**
     * Metodos GET Y SET
     */
    
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

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }
}
