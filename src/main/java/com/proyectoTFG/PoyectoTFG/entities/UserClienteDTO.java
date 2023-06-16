package com.proyectoTFG.PoyectoTFG.entities;

public class UserClienteDTO {

    private Usuario usuario;
    private Cliente cliente;

    public UserClienteDTO() {
    }

    public UserClienteDTO(Usuario usuario, Cliente cliente) {
        this.usuario = usuario;
        this.cliente = cliente;
    }


    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
