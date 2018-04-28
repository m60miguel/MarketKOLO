/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.persistence;

import co.edu.konrad.marketplace.entities.ComunicacionEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Manejador de la entidad Comunicacion
 * @author Cindy H.
 */
@Stateless
public class ComunicacionPersistence {
    
    @PersistenceContext(unitName = "marketPU")
    protected EntityManager em;
    
    /**
     * Obtener la lista con los datos de la tabla Comunicacion
     * @return Lista de datos de la tabla Comunicacion
     */
    public List<ComunicacionEntity> findAll(){
        Query todos = em.createQuery("select e from Comunicacion e");
        return todos.getResultList();
    }
    
    /**
     * Encontrar una tupla especifica de la tabla Comunicacion
     * @param id que se desea buscar
     * @return comunicacionEntity
     */
    public ComunicacionEntity find(Long id){
        ComunicacionEntity comunicacion = em.find(ComunicacionEntity.class, id);
        return comunicacion;
    }
    
    /**
     * Creacion de un nuevo comunicacion
     * @param comunicacion
     * @return nuevo comunicacion creado
     */
    public ComunicacionEntity create(ComunicacionEntity comunicacion){
        em.persist(comunicacion);
        return comunicacion;
    }
    
    /**
     * Actualizacion de una tupla de la tabla Comunicacion
     * @param comunicacionActualizar
     * @return comunicacion actualizado
     */
    public ComunicacionEntity update (ComunicacionEntity comunicacionActualizar){
        return em.merge(comunicacionActualizar);
    }
    
    /**
     * Elimina una tupla comunicacion de la tabla
     * @param id 
     */
    public void delete (Long id){
        ComunicacionEntity comunicacionDelete = em.find(ComunicacionEntity.class, id);
        em.remove(comunicacionDelete);
    }
    
    public List<ComunicacionEntity> findByName(String nombreEst){
        TypedQuery<ComunicacionEntity> estPorNombre = em.createNamedQuery("Comunicacion.findByName", ComunicacionEntity.class).setParameter("nombre", nombreEst);
        return estPorNombre.getResultList();
    }
}
