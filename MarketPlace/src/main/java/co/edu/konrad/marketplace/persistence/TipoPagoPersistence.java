/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.persistence;

import co.edu.konrad.marketplace.entities.TipoPagoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Manejador de la entidad TipoPago
 * @author Cindy H.
 */
@Stateless
public class TipoPagoPersistence {
    
    @PersistenceContext(unitName = "marketPU")
    protected EntityManager em;
    
    /**
     * Obtener la lista con los datos de la tabla TipoPago
     * @return Lista de datos de la tabla TipoPago
     */
    public List<TipoPagoEntity> findAll(){
        Query todos = em.createQuery("select e from TipoPago e");
        return todos.getResultList();
    }
    
    /**
     * Encontrar una tupla especifica de la tabla TipoPago
     * @param id que se desea buscar
     * @return tipoPagoEntity
     */
    public TipoPagoEntity find(Long id){
        TipoPagoEntity tipoPago = em.find(TipoPagoEntity.class, id);
        return tipoPago;
    }
    
    /**
     * Creacion de un nuevo tipoPago
     * @param tipoPago
     * @return nuevo tipoPago creado
     */
    public TipoPagoEntity create(TipoPagoEntity tipoPago){
        em.persist(tipoPago);
        return tipoPago;
    }
    
    /**
     * Actualizacion de una tupla de la tabla TipoPago
     * @param tipoPagoActualizar
     * @return tipoPago actualizado
     */
    public TipoPagoEntity update (TipoPagoEntity tipoPagoActualizar){
        return em.merge(tipoPagoActualizar);
    }
    
    /**
     * Elimina una tupla tipoPago de la tabla
     * @param id 
     */
    public void delete (Long id){
        TipoPagoEntity tipoPagoDelete = em.find(TipoPagoEntity.class, id);
        em.remove(tipoPagoDelete);
    }
    
    public List<TipoPagoEntity> findByName(String nombreEst){
        TypedQuery<TipoPagoEntity> estPorNombre = em.createNamedQuery("TipoPago.findByName", TipoPagoEntity.class).setParameter("nombre", nombreEst);
        return estPorNombre.getResultList();
    }
}
