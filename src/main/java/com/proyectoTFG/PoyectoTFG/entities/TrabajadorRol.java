package com.proyectoTFG.PoyectoTFG.entities;

import java.util.List;

public class TrabajadorRol {

    private Trabajador trabajador;
    private List<Long> roles;

    public TrabajadorRol() {
    }

    public TrabajadorRol(Trabajador trabajador, List<Long> roles) {
        this.trabajador = trabajador;
        this.roles = roles;
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
