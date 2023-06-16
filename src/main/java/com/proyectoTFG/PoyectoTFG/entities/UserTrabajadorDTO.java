package com.proyectoTFG.PoyectoTFG.entities;

import java.util.List;

public class UserTrabajadorDTO {

    private Usuario usuario;
    private Trabajador trabajador;
    private List<Long> roles;

    public UserTrabajadorDTO() {
    }

    public UserTrabajadorDTO(Usuario usuario, Trabajador trabajador, List<Long> roles) {
        this.usuario = usuario;
        this.trabajador = trabajador;
        this.roles = roles;
    }


    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Trabajador getTrabajador() {
        return this.trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public List<Long> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Long> roles) {
        this.roles = roles;
    }


    
}
