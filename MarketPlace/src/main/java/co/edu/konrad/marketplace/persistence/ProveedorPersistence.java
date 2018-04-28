/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.persistence;

import co.edu.konrad.marketplace.entities.ProveedorEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Manejador de la entidad Proveedor
 * @author Cindy H.
 */
@Stateless
public class ProveedorPersistence {
    
    @PersistenceContext(unitName = "marketPU")
    protected EntityManager em;
    
    /**
     * Obtener la lista con los datos de la tabla Proveedor
     * @return Lista de datos de la tabla Proveedor
     */
    public List<ProveedorEntity> findAll(){
        Query todos = em.createQuery("select e from Proveedor e");
        return todos.getResultList();
    }
    
    /**
     * Encontrar una tupla especifica de la tabla Proveedor
     * @param id que se desea buscar
     * @return proveedorEntity
     */
    public ProveedorEntity find(Long id){
        ProveedorEntity proveedor = em.find(ProveedorEntity.class, id);
        return proveedor;
    }
    
    /**
     * Creacion de un nuevo proveedor
     * @param proveedor
     * @return nuevo proveedor creado
     */
    public ProveedorEntity create(ProveedorEntity proveedor){
        em.persist(proveedor);
        return proveedor;
    }
    
    /**
     * Actualizacion de una tupla de la tabla Proveedor
     * @param proveedorActualizar
     * @return proveedor actualizado
     */
    public ProveedorEntity update (ProveedorEntity proveedorActualizar){
        return em.merge(proveedorActualizar);
    }
    
    /**
     * Elimina una tupla proveedor de la tabla
     * @param id 
     */
    public void delete (Long id){
        ProveedorEntity proveedorDelete = em.find(ProveedorEntity.class, id);
        em.remove(proveedorDelete);
    }
    
    public List<ProveedorEntity> findByName(String nombreEst){
        TypedQuery<ProveedorEntity> estPorNombre = em.createNamedQuery("Proveedor.findByName", ProveedorEntity.class).setParameter("nombre", nombreEst);
        return estPorNombre.getResultList();
    }
}
