/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.resources;

import co.edu.konrad.marketplace.dto.ProveedorDTO;
import co.edu.konrad.marketplace.entities.ProveedorEntity;
import co.edu.konrad.marketplace.logic.ProveedorLogic;
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
 * Recurso del proveedor
 * @author DarkFACS
 */
@Path("/proveedores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProveedorResource {
    
    @EJB
    private ProveedorLogic proveedorLogic;
    
    @GET
    public List<ProveedorDTO> getProveedorList(){
        List<ProveedorEntity> proveedores = proveedorLogic.obtenerProveedores();
        return ProveedorDTO.toProveedorList(proveedores);
    }
    
    @GET
    @Path("{id: \\d+}")
    public ProveedorDTO getProveedor(@PathParam("id")Long id){
        ProveedorEntity proveedor = proveedorLogic.obtenerProveedorPorId(id);
        if (proveedor == null){
            throw new RuntimeException("El proveedor no existe");
        }
        return new ProveedorDTO(proveedor);
    }
    
    @POST
    public ProveedorDTO createProveedor(ProveedorDTO proveedor){
        return new ProveedorDTO(proveedorLogic.crearProveedor(proveedor.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public ProveedorDTO updateProveedor(@PathParam("id")Long id, ProveedorDTO proveedor){
        ProveedorEntity proveedorEntity = proveedorLogic.obtenerProveedorPorId(id);
        if (proveedorEntity == null){
            throw new RuntimeException("El proveedor no existe");
        }
        return new ProveedorDTO(proveedorLogic.actualizarProveedor(id, proveedor.toEntity()));
    }
    
    @DELETE
    @Path("{proveedorId: \\d+}")
    public void deleteProveedor(@PathParam("proveedorId")Long id){
        ProveedorEntity proveedorEntity = proveedorLogic.obtenerProveedorPorId(id);
        if (proveedorEntity == null){
            throw new RuntimeException("El proveedor no existe");
        }
        proveedorLogic.eliminarProveedor(id);
    }
}
