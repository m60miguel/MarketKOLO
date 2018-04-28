/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.persistence;

import co.edu.konrad.marketplace.entities.EvaluacionEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Manejador de la entidad Evaluacion
 * @author Cindy H.
 */
@Stateless
public class EvaluacionPersistence {
    
    @PersistenceContext(unitName = "marketPU")
    protected EntityManager em;
    
    /**
     * Obtener la lista con los datos de la tabla Evaluacion
     * @return Lista de datos de la tabla Evaluacion
     */
    public List<EvaluacionEntity> findAll(){
        Query todos = em.createQuery("select e from Evaluacion e");
        return todos.getResultList();
    }
    
    /**
     * Encontrar una tupla especifica de la tabla Evaluacion
     * @param id que se desea buscar
     * @return evaluacionEntity
     */
    public EvaluacionEntity find(Long id){
        EvaluacionEntity evaluacion = em.find(EvaluacionEntity.class, id);
        return evaluacion;
    }
    
    /**
     * Creacion de un nuevo evaluacion
     * @param evaluacion
     * @return nuevo evaluacion creado
     */
    public EvaluacionEntity create(EvaluacionEntity evaluacion){
        em.persist(evaluacion);
        return evaluacion;
    }
    
    /**
     * Actualizacion de una tupla de la tabla Evaluacion
     * @param evaluacionActualizar
     * @return evaluacion actualizado
     */
    public EvaluacionEntity update (EvaluacionEntity evaluacionActualizar){
        return em.merge(evaluacionActualizar);
    }
    
    /**
     * Elimina una tupla evaluacion de la tabla
     * @param id 
     */
    public void delete (Long id){
        EvaluacionEntity evaluacionDelete = em.find(EvaluacionEntity.class, id);
        em.remove(evaluacionDelete);
    }
    
    public List<EvaluacionEntity> findByName(String nombreEst){
        TypedQuery<EvaluacionEntity> estPorNombre = em.createNamedQuery("Evaluacion.findByName", EvaluacionEntity.class).setParameter("nombre", nombreEst);
        return estPorNombre.getResultList();
    }
}
