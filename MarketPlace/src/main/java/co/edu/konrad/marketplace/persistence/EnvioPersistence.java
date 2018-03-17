/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.persistence;

import co.edu.konrad.marketplace.entities.EnvioEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Manejador de la entidad Envio
 * @author Cindy H.
 */
@Stateless
public class EnvioPersistence {
    
    @PersistenceContext(unitName = "marketPU")
    protected EntityManager em;
    
    /**
     * Obtener la lista con los datos de la tabla Envio
     * @return Lista de datos de la tabla Envio
     */
    public List<EnvioEntity> findAll(){
        Query todos = em.createQuery("select e from EnvioEntity e");
        return todos.getResultList();
    }
    
    /**
     * Encontrar una tupla especifica de la tabla Envio
     * @param id que se desea buscar
     * @return envioEntity
     */
    public EnvioEntity find(Long id){
        EnvioEntity envio = em.find(EnvioEntity.class, id);
        return envio;
    }
    
    /**
     * Creacion de un nuevo envio
     * @param envio
     * @return nuevo envio creado
     */
    public EnvioEntity create(EnvioEntity envio){
        em.persist(envio);
        return envio;
    }
    
    /**
     * Actualizacion de una tupla de la tabla Envio
     * @param envioActualizar
     * @return envio actualizado
     */
    public EnvioEntity update (EnvioEntity envioActualizar){
        return em.merge(envioActualizar);
    }
    
    /**
     * Elimina una tupla envio de la tabla
     * @param id 
     */
    public void delete (Long id){
        EnvioEntity envioDelete = em.find(EnvioEntity.class, id);
        em.remove(envioDelete);
    }
    
    public List<EnvioEntity> findByName(String nombreEst){
        TypedQuery<EnvioEntity> estPorNombre = em.createNamedQuery("Envio.findByName", EnvioEntity.class).setParameter("nombre", nombreEst);
        return estPorNombre.getResultList();
    }
}
