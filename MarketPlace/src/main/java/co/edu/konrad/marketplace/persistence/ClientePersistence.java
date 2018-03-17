/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.persistence;

import co.edu.konrad.marketplace.entities.ClienteEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Manejador de la entidad Cliente
 * @author Cindy H.
 */
@Stateless
public class ClientePersistence {
    
    @PersistenceContext(unitName = "marketPU")
    protected EntityManager em;
    
    /**
     * Obtener la lista con los datos de la tabla Cliente
     * @return Lista de datos de la tabla Cliente
     */
    public List<ClienteEntity> findAll(){
        Query todos = em.createQuery("select e from ClienteEntity e");
        return todos.getResultList();
    }
    
    /**
     * Encontrar una tupla especifica de la tabla Cliente
     * @param id que se desea buscar
     * @return clienteEntity
     */
    public ClienteEntity find(Long id){
        ClienteEntity cliente = em.find(ClienteEntity.class, id);
        return cliente;
    }
    
    /**
     * Creacion de un nuevo cliente
     * @param cliente
     * @return nuevo cliente creado
     */
    public ClienteEntity create(ClienteEntity cliente){
        em.persist(cliente);
        return cliente;
    }
    
    /**
     * Actualizacion de una tupla de la tabla Cliente
     * @param clienteActualizar
     * @return cliente actualizado
     */
    public ClienteEntity update (ClienteEntity clienteActualizar){
        return em.merge(clienteActualizar);
    }
    
    /**
     * Elimina una tupla cliente de la tabla
     * @param id 
     */
    public void delete (Long id){
        ClienteEntity clienteDelete = em.find(ClienteEntity.class, id);
        em.remove(clienteDelete);
    }
    
    public List<ClienteEntity> findByName(String nombreEst){
        TypedQuery<ClienteEntity> estPorNombre = em.createNamedQuery("Cliente.findByName", ClienteEntity.class).setParameter("nombre", nombreEst);
        return estPorNombre.getResultList();
    }
}
