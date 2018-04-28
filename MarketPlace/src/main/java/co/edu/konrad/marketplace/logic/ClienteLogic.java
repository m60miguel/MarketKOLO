/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.logic;

import co.edu.konrad.marketplace.entities.ClienteEntity;
import co.edu.konrad.marketplace.persistence.ClientePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author DarkFACS
 */
@Stateless
public class ClienteLogic {
    
    /**
     * Inyeccion del Persistence de Cliente
     */
    @Inject
    private ClientePersistence clientePersistence;

    /**
     * Obtener Listado de Clientes. Inyeccion del persistence del cliente
     *
     * @return
     */
    public List<ClienteEntity> obtenerClientes() {
        List<ClienteEntity> clientes = clientePersistence.findAll();
        return clientes;
    }

    /**
     * Obtener un cliente desde el Identificador (id)
     *
     * @param id
     * @return cliente encontrado
     */
    public ClienteEntity obtenerClientePorId(Long id) {
        ClienteEntity cliente = clientePersistence.find(id);
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente solicitado no existe");
        }
        return cliente;
    }

    /**
     * Metodo utilizado para crear un Nuevo Cliente
     *
     * @param cliente
     * @return cliente creado
     */
    public ClienteEntity crearCliente(ClienteEntity cliente) {
        clientePersistence.create(cliente);
        return cliente;
    }

    /**
     * Actualizar un objeto Cliente
     *
     * @param id
     * @param cliente
     * @return cliente actualizado
     */
    public ClienteEntity actualizarCliente(Long id, ClienteEntity cliente) {
        ClienteEntity clienteEntity = clientePersistence.update(cliente);
        return clienteEntity;
    }

    /**
     * Borrar un cliente desde el ID
     *
     * @param id
     */
    public void eliminarCliente(Long id) {
        clientePersistence.delete(id);
    }
}
