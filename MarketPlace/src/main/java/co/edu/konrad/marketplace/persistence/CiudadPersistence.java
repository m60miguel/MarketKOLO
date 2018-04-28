/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.persistence;

import co.edu.konrad.marketplace.entities.CiudadEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Manejador de la entidad Ciudad
 * @author Cindy H.
 */
@Stateless
public class CiudadPersistence {
    
    @PersistenceContext(unitName = "marketPU")
    protected EntityManager em;
    
    /**
     * Obtener la lista con los datos de la tabla Ciudad
     * @return Lista de datos de la tabla Ciudad
     */
    public List<CiudadEntity> findAll(){
        Query todos = em.createQuery("select e from Ciudad e");
        return todos.getResultList();
    }
    
    /**
     * Encontrar una tupla especifica de la tabla Ciudad
     * @param id que se desea buscar
     * @return ciudadEntity
     */
    public CiudadEntity find(Long id){
        CiudadEntity ciudad = em.find(CiudadEntity.class, id);
        return ciudad;
    }
    
    /**
     * Creacion de un nuevo ciudad
     * @param ciudad
     * @return nuevo ciudad creado
     */
    public CiudadEntity create(CiudadEntity ciudad){
        em.persist(ciudad);
        return ciudad;
    }
    
    /**
     * Actualizacion de una tupla de la tabla Ciudad
     * @param ciudadActualizar
     * @return ciudad actualizado
     */
    public CiudadEntity update (CiudadEntity ciudadActualizar){
        return em.merge(ciudadActualizar);
    }
    
    /**
     * Elimina una tupla ciudad de la tabla
     * @param id 
     */
    public void delete (Long id){
        CiudadEntity ciudadDelete = em.find(CiudadEntity.class, id);
        em.remove(ciudadDelete);
    }
    
    public List<CiudadEntity> findByName(String nombreEst){
        TypedQuery<CiudadEntity> estPorNombre = em.createNamedQuery("Ciudad.findByName", CiudadEntity.class).setParameter("nombre", nombreEst);
        return estPorNombre.getResultList();
    }
}
