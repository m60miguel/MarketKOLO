/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.persistence;

import co.edu.konrad.marketplace.entities.DatosFinancierosEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Manejador de la entidad DatosFinancieros
 * @author Cindy H.
 */
@Stateless
public class DatosFinancierosPersistence {
    
    @PersistenceContext(unitName = "marketPU")
    protected EntityManager em;
    
    /**
     * Obtener la lista con los datos de la tabla DatosFinancieros
     * @return Lista de datos de la tabla DatosFinancieros
     */
    public List<DatosFinancierosEntity> findAll(){
        Query todos = em.createQuery("select e from DatosFinancierosEntity e");
        return todos.getResultList();
    }
    
    /**
     * Encontrar una tupla especifica de la tabla DatosFinancieros
     * @param id que se desea buscar
     * @return datosFinancierosEntity
     */
    public DatosFinancierosEntity find(Long id){
        DatosFinancierosEntity datosFinancieros = em.find(DatosFinancierosEntity.class, id);
        return datosFinancieros;
    }
    
    /**
     * Creacion de un nuevo datosFinancieros
     * @param datosFinancieros
     * @return nuevo datosFinancieros creado
     */
    public DatosFinancierosEntity create(DatosFinancierosEntity datosFinancieros){
        em.persist(datosFinancieros);
        return datosFinancieros;
    }
    
    /**
     * Actualizacion de una tupla de la tabla DatosFinancieros
     * @param datosFinancierosActualizar
     * @return datosFinancieros actualizado
     */
    public DatosFinancierosEntity update (DatosFinancierosEntity datosFinancierosActualizar){
        return em.merge(datosFinancierosActualizar);
    }
    
    /**
     * Elimina una tupla datosFinancieros de la tabla
     * @param id 
     */
    public void delete (Long id){
        DatosFinancierosEntity datosFinancierosDelete = em.find(DatosFinancierosEntity.class, id);
        em.remove(datosFinancierosDelete);
    }
    
    public List<DatosFinancierosEntity> findByName(String nombreEst){
        TypedQuery<DatosFinancierosEntity> estPorNombre = em.createNamedQuery("DatosFinancieros.findByName", DatosFinancierosEntity.class).setParameter("nombre", nombreEst);
        return estPorNombre.getResultList();
    }
}
