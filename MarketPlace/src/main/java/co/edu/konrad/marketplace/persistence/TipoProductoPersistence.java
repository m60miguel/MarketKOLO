/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.persistence;

import co.edu.konrad.marketplace.entities.TipoProductoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Manejador de la entidad TipoProducto
 * @author Cindy H.
 */
@Stateless
public class TipoProductoPersistence {
    
    @PersistenceContext(unitName = "marketPU")
    protected EntityManager em;
    
    /**
     * Obtener la lista con los datos de la tabla TipoProducto
     * @return Lista de datos de la tabla TipoProducto
     */
    public List<TipoProductoEntity> findAll(){
        Query todos = em.createQuery("select e from TipoProductoEntity e");
        return todos.getResultList();
    }
    
    /**
     * Encontrar una tupla especifica de la tabla TipoProducto
     * @param id que se desea buscar
     * @return tipoProductoEntity
     */
    public TipoProductoEntity find(Long id){
        TipoProductoEntity tipoProducto = em.find(TipoProductoEntity.class, id);
        return tipoProducto;
    }
    
    /**
     * Creacion de un nuevo tipoProducto
     * @param tipoProducto
     * @return nuevo tipoProducto creado
     */
    public TipoProductoEntity create(TipoProductoEntity tipoProducto){
        em.persist(tipoProducto);
        return tipoProducto;
    }
    
    /**
     * Actualizacion de una tupla de la tabla TipoProducto
     * @param tipoProductoActualizar
     * @return tipoProducto actualizado
     */
    public TipoProductoEntity update (TipoProductoEntity tipoProductoActualizar){
        return em.merge(tipoProductoActualizar);
    }
    
    /**
     * Elimina una tupla tipoProducto de la tabla
     * @param id 
     */
    public void delete (Long id){
        TipoProductoEntity tipoProductoDelete = em.find(TipoProductoEntity.class, id);
        em.remove(tipoProductoDelete);
    }
    
    public List<TipoProductoEntity> findByName(String nombreEst){
        TypedQuery<TipoProductoEntity> estPorNombre = em.createNamedQuery("TipoProducto.findByName", TipoProductoEntity.class).setParameter("nombre", nombreEst);
        return estPorNombre.getResultList();
    }
}
