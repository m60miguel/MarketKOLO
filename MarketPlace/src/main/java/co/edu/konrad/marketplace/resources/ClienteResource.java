/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.resources;

import co.edu.konrad.marketplace.dto.ClienteDTO;
import co.edu.konrad.marketplace.entities.ClienteEntity;
import co.edu.konrad.marketplace.logic.ClienteLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Recurso del cliente
 * @author DarkFACS
 */
@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {
    
    @EJB
    private ClienteLogic clienteLogic;
    
    @GET
    public List<ClienteDTO> getClienteList(){
        List<ClienteEntity> clientes = clienteLogic.obtenerClientes();
        return ClienteDTO.toClienteList(clientes);
    }
    
    @GET
    @Path("{id: \\d+}")
    public ClienteDTO getCliente(@PathParam("id")Long id){
        ClienteEntity cliente = clienteLogic.obtenerClientePorId(id);
        if (cliente == null){
            throw new RuntimeException("El cliente no existe");
        }
        return new ClienteDTO(cliente);
    }
    
    @POST
    public ClienteDTO createCliente(ClienteDTO cliente){
        return new ClienteDTO(clienteLogic.crearCliente(cliente.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public ClienteDTO updateCliente(@PathParam("id")Long id, ClienteDTO cliente){
        ClienteEntity clienteEntity = clienteLogic.obtenerClientePorId(id);
        if (clienteEntity == null){
            throw new RuntimeException("El cliente no existe");
        }
        return new ClienteDTO(clienteLogic.actualizarCliente(id, cliente.toEntity()));
    }
    
    @DELETE
    @Path("{clienteId: \\d+}")
    public void deleteCliente(@PathParam("clienteId")Long id){
        ClienteEntity clienteEntity = clienteLogic.obtenerClientePorId(id);
        if (clienteEntity == null){
            throw new RuntimeException("El cliente no existe");
        }
        clienteLogic.eliminarCliente(id);
    }
}
