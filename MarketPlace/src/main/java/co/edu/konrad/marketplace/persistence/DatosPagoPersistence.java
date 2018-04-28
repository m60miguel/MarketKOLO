/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.persistence;

import co.edu.konrad.marketplace.entities.DatosPagoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Manejador de la entidad DatosPago
 * @author Cindy H.
 */
@Stateless
public class DatosPagoPersistence {
    
    @PersistenceContext(unitName = "marketPU")
    protected EntityManager em;
    
    /**
     * Obtener la lista con los datos de la tabla DatosPago
     * @return Lista de datos de la tabla DatosPago
     */
    public List<DatosPagoEntity> findAll(){
        Query todos = em.createQuery("select e from DatosPago e");
        return todos.getResultList();
    }
    
    /**
     * Encontrar una tupla especifica de la tabla DatosPago
     * @param id que se desea buscar
     * @return datosPagoEntity
     */
    public DatosPagoEntity find(Long id){
        DatosPagoEntity datosPago = em.find(DatosPagoEntity.class, id);
        return datosPago;
    }
    
    /**
     * Creacion de un nuevo datosPago
     * @param datosPago
     * @return nuevo datosPago creado
     */
    public DatosPagoEntity create(DatosPagoEntity datosPago){
        em.persist(datosPago);
        return datosPago;
    }
    
    /**
     * Actualizacion de una tupla de la tabla DatosPago
     * @param datosPagoActualizar
     * @return datosPago actualizado
     */
    public DatosPagoEntity update (DatosPagoEntity datosPagoActualizar){
        return em.merge(datosPagoActualizar);
    }
    
    /**
     * Elimina una tupla datosPago de la tabla
     * @param id 
     */
    public void delete (Long id){
        DatosPagoEntity datosPagoDelete = em.find(DatosPagoEntity.class, id);
        em.remove(datosPagoDelete);
    }
    
    public List<DatosPagoEntity> findByName(String nombreEst){
        TypedQuery<DatosPagoEntity> estPorNombre = em.createNamedQuery("DatosPago.findByName", DatosPagoEntity.class).setParameter("nombre", nombreEst);
        return estPorNombre.getResultList();
    }
}
