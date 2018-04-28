/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.persistence;

import co.edu.konrad.marketplace.entities.FacturaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Manejador de la entidad Factura
 * @author Cindy H.
 */
@Stateless
public class FacturaPersistence {
    
    @PersistenceContext(unitName = "marketPU")
    protected EntityManager em;
    
    /**
     * Obtener la lista con los datos de la tabla Factura
     * @return Lista de datos de la tabla Factura
     */
    public List<FacturaEntity> findAll(){
        Query todos = em.createQuery("select e from Factura e");
        return todos.getResultList();
    }
    
    /**
     * Encontrar una tupla especifica de la tabla Factura
     * @param id que se desea buscar
     * @return facturaEntity
     */
    public FacturaEntity find(Long id){
        FacturaEntity factura = em.find(FacturaEntity.class, id);
        return factura;
    }
    
    /**
     * Creacion de un nuevo factura
     * @param factura
     * @return nuevo factura creado
     */
    public FacturaEntity create(FacturaEntity factura){
        em.persist(factura);
        return factura;
    }
    
    /**
     * Actualizacion de una tupla de la tabla Factura
     * @param facturaActualizar
     * @return factura actualizado
     */
    public FacturaEntity update (FacturaEntity facturaActualizar){
        return em.merge(facturaActualizar);
    }
    
    /**
     * Elimina una tupla factura de la tabla
     * @param id 
     */
    public void delete (Long id){
        FacturaEntity facturaDelete = em.find(FacturaEntity.class, id);
        em.remove(facturaDelete);
    }
    
    public List<FacturaEntity> findByName(String nombreEst){
        TypedQuery<FacturaEntity> estPorNombre = em.createNamedQuery("Factura.findByName", FacturaEntity.class).setParameter("nombre", nombreEst);
        return estPorNombre.getResultList();
    }
}
