/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.persistence;

import co.edu.konrad.marketplace.entities.ProductoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Manejador de la entidad Producto
 * @author Cindy H.
 */
@Stateless
public class ProductoPersistence {
    
    @PersistenceContext(unitName = "marketPU")
    protected EntityManager em;
    
    /**
     * Obtener la lista con los datos de la tabla Producto
     * @return Lista de datos de la tabla Producto
     */
    public List<ProductoEntity> findAll(){
        Query todos = em.createQuery("select e from Producto e");
        return todos.getResultList();
    }
    
    /**
     * Encontrar una tupla especifica de la tabla Producto
     * @param id que se desea buscar
     * @return productoEntity
     */
    public ProductoEntity find(Long id){
        ProductoEntity producto = em.find(ProductoEntity.class, id);
        return producto;
    }
    
    /**
     * Creacion de un nuevo producto
     * @param producto
     * @return nuevo producto creado
     */
    public ProductoEntity create(ProductoEntity producto){
        em.persist(producto);
        return producto;
    }
    
    /**
     * Actualizacion de una tupla de la tabla Producto
     * @param productoActualizar
     * @return producto actualizado
     */
    public ProductoEntity update (ProductoEntity productoActualizar){
        return em.merge(productoActualizar);
    }
    
    /**
     * Elimina una tupla producto de la tabla
     * @param id 
     */
    public void delete (Long id){
        ProductoEntity productoDelete = em.find(ProductoEntity.class, id);
        em.remove(productoDelete);
    }
    
    public List<ProductoEntity> findByName(String nombreEst){
        TypedQuery<ProductoEntity> estPorNombre = em.createNamedQuery("Producto.findByName", ProductoEntity.class).setParameter("nombre", nombreEst);
        return estPorNombre.getResultList();
    }
}
