/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.logic;

import co.edu.konrad.marketplace.entities.EvaluacionEntity;
import co.edu.konrad.marketplace.persistence.EvaluacionPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author DarkFACS
 */
@Stateless
public class EvaluacionLogic {
    
    /**
     * Inyeccion del Persistence de Evaluacion
     */
    @Inject
    private EvaluacionPersistence evaluacionPersistence;

    /**
     * Obtener Listado de Evaluacion. Inyeccion del persistence de evaluacion
     *
     * @return
     */
    public List<EvaluacionEntity> obtenerEvaluaciones() {
        List<EvaluacionEntity> evaluaciones = evaluacionPersistence.findAll();
        return evaluaciones;
    }

    /**
     * Obtener una evaluacion desde el Identificador (id)
     *
     * @param id
     * @return evaluacion encontrado
     */
    public EvaluacionEntity obtenerEvaluacionPorId(Long id) {
        EvaluacionEntity evaluacion = evaluacionPersistence.find(id);
        if (evaluacion == null) {
            throw new IllegalArgumentException("La evaluacion solicitada no existe");
        }
        return evaluacion;
    }

    /**
     * Metodo utilizado para crear una Nueva Evaluacion
     *
     * @param evaluacion
     * @return evaluacion creado
     */
    public EvaluacionEntity crearEvaluacion(EvaluacionEntity evaluacion) {
        evaluacionPersistence.create(evaluacion);
        return evaluacion;
    }

    /**
     * Actualizar un objeto Evaluacion
     *
     * @param id
     * @param evaluacion
     * @return evaluacion actualizado
     */
    public EvaluacionEntity actualizarEvaluacion(Long id, EvaluacionEntity evaluacion) {
        EvaluacionEntity evaluacionEntity = evaluacionPersistence.update(evaluacion);
        return evaluacionEntity;
    }

    /**
     * Borrar una evaluacion desde el ID
     *
     * @param id
     */
    public void eliminarEvaluacion(Long id) {
        evaluacionPersistence.delete(id);
    }
}
