/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.dto;

import co.edu.konrad.marketplace.entities.ClienteEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DarkFACS
 */
public class ClienteDTO {
    
    private Long idCliente;
    
    private String nombreCliente;

    private String apellidoCliente;

    private String tDocCliente;

    private int nDocCliente;

    private String fechaNacCliente;

    private String usuarioCliente;

    private String passCliente;

    private String direccionCliente;

    private int telefonoCliente;

    private String emailCliente;

    private String avatarCliente;

    private int ciudad;

    public ClienteDTO(){
        
    }
    public ClienteEntity toEntity(){
        ClienteEntity cliente = new ClienteEntity();
        cliente.setIdCliente(this.idCliente);
        cliente.setNombreCliente(this.nombreCliente);
        cliente.setApellidoCliente(this.apellidoCliente);
        cliente.settDocCliente(this.tDocCliente);
        cliente.setnDocCliente(this.nDocCliente);
        cliente.setFechaNacCliente(this.fechaNacCliente);
        cliente.setUsuarioCliente(this.usuarioCliente);
        cliente.setPassCliente(this.passCliente);
        cliente.setDireccionCliente(this.direccionCliente);
        cliente.setTelefonoCliente(this.telefonoCliente);
        cliente.setEmailCliente(this.emailCliente);
        cliente.setAvatarCliente(this.avatarCliente);
        cliente.setCiudadId(this.ciudad);
        return cliente;
    }
    
    public ClienteDTO(ClienteEntity cliente){
        this.idCliente = cliente.getIdCliente();
        this.nombreCliente = cliente.getNombreCliente();
        this.apellidoCliente = cliente.getApellidoCliente();
        this.tDocCliente = cliente.gettDocCliente();
        this.nDocCliente = cliente.getnDocCliente();
        this.fechaNacCliente = cliente.getFechaNacCliente();
        this.usuarioCliente = cliente.getUsuarioCliente();
        this.passCliente = cliente.getPassCliente();
        this.direccionCliente = cliente.getDireccionCliente();
        this.telefonoCliente = cliente.getTelefonoCliente();
        this.emailCliente = cliente.getEmailCliente();
        this.avatarCliente = cliente.getAvatarCliente();
        this.ciudad = cliente.getCiudadId();
    }
    
    public static List<ClienteDTO> toClienteList(List<ClienteEntity> clienteList){
        List<ClienteDTO> listaClientes = new ArrayList<>();
        for (int i=0; i<clienteList.size();i++){
            listaClientes.add(new ClienteDTO(clienteList.get(i)));
        }
        return listaClientes;
    }
    
    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String gettDocCliente() {
        return tDocCliente;
    }

    public void settDocCliente(String tDocCliente) {
        this.tDocCliente = tDocCliente;
    }

    public int getnDocCliente() {
        return nDocCliente;
    }

    public void setnDocCliente(int nDocCliente) {
        this.nDocCliente = nDocCliente;
    }

    public String getFechaNacCliente() {
        return fechaNacCliente;
    }

    public void setFechaNacCliente(String fechaNacCliente) {
        this.fechaNacCliente = fechaNacCliente;
    }

    public String getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(String usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public String getPassCliente() {
        return passCliente;
    }

    public void setPassCliente(String passCliente) {
        this.passCliente = passCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public int getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(int telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getAvatarCliente() {
        return avatarCliente;
    }

    public void setAvatarCliente(String avatarCliente) {
        this.avatarCliente = avatarCliente;
    }

    public int getCiudad() {
        return ciudad;
    }

    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
    }
}
