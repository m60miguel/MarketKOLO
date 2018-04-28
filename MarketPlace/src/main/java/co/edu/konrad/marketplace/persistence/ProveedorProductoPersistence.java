/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.persistence;

import co.edu.konrad.marketplace.entities.ProveedorProductoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Manejador de la entidad ProveedorProducto
 * @author Cindy H.
 */
@Stateless
public class ProveedorProductoPersistence {
    
    @PersistenceContext(unitName = "marketPU")
    protected EntityManager em;
    
    /**
     * Obtener la lista con los datos de la tabla ProveedorProducto
     * @return Lista de datos de la tabla ProveedorProducto
     */
    public List<ProveedorProductoEntity> findAll(){
        Query todos = em.createQuery("select e from ProveedorProducto e");
        return todos.getResultList();
    }
    
    /**
     * Encontrar una tupla especifica de la tabla ProveedorProducto
     * @param id que se desea buscar
     * @return proveedorProductoEntity
     */
    public ProveedorProductoEntity find(Long id){
        ProveedorProductoEntity proveedorProducto = em.find(ProveedorProductoEntity.class, id);
        return proveedorProducto;
    }
    
    /**
     * Creacion de un nuevo proveedorProducto
     * @param proveedorProducto
     * @return nuevo proveedorProducto creado
     */
    public ProveedorProductoEntity create(ProveedorProductoEntity proveedorProducto){
        em.persist(proveedorProducto);
        return proveedorProducto;
    }
    
    /**
     * Actualizacion de una tupla de la tabla ProveedorProducto
     * @param proveedorProductoActualizar
     * @return proveedorProducto actualizado
     */
    public ProveedorProductoEntity update (ProveedorProductoEntity proveedorProductoActualizar){
        return em.merge(proveedorProductoActualizar);
    }
    
    /**
     * Elimina una tupla proveedorProducto de la tabla
     * @param id 
     */
    public void delete (Long id){
        ProveedorProductoEntity proveedorProductoDelete = em.find(ProveedorProductoEntity.class, id);
        em.remove(proveedorProductoDelete);
    }
    
    public List<ProveedorProductoEntity> findByName(String nombreEst){
        TypedQuery<ProveedorProductoEntity> estPorNombre = em.createNamedQuery("ProveedorProducto.findByName", ProveedorProductoEntity.class).setParameter("nombre", nombreEst);
        return estPorNombre.getResultList();
    }
}
