/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.persistence;

import co.edu.konrad.marketplace.entities.PaisEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Manejador de la entidad Pais
 * @author Cindy H.
 */
@Stateless
public class PaisPersistence {
    
    @PersistenceContext(unitName = "marketPU")
    protected EntityManager em;
    
    /**
     * Obtener la lista con los datos de la tabla Pais
     * @return Lista de datos de la tabla Pais
     */
    public List<PaisEntity> findAll(){
        Query todos = em.createQuery("select e from PaisEntity e");
        return todos.getResultList();
    }
    
    /**
     * Encontrar una tupla especifica de la tabla Pais
     * @param id que se desea buscar
     * @return paisEntity
     */
    public PaisEntity find(Long id){
        PaisEntity pais = em.find(PaisEntity.class, id);
        return pais;
    }
    
    /**
     * Creacion de un nuevo pais
     * @param pais
     * @return nuevo pais creado
     */
    public PaisEntity create(PaisEntity pais){
        em.persist(pais);
        return pais;
    }
    
    /**
     * Actualizacion de una tupla de la tabla Pais
     * @param paisActualizar
     * @return pais actualizado
     */
    public PaisEntity update (PaisEntity paisActualizar){
        return em.merge(paisActualizar);
    }
    
    /**
     * Elimina una tupla pais de la tabla
     * @param id 
     */
    public void delete (Long id){
        PaisEntity paisDelete = em.find(PaisEntity.class, id);
        em.remove(paisDelete);
    }
    
    public List<PaisEntity> findByName(String nombreEst){
        TypedQuery<PaisEntity> estPorNombre = em.createNamedQuery("Pais.findByName", PaisEntity.class).setParameter("nombre", nombreEst);
        return estPorNombre.getResultList();
    }
}
