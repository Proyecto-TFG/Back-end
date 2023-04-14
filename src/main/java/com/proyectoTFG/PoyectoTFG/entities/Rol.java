package com.proyectoTFG.PoyectoTFG.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    private Long rolId;

    private String rolNombre;

    @JsonIgnoreProperties("usuariosRoles")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
    private Set<UsuarioRol> usuariosRoles = new HashSet<>();


    public Rol() {
    }

    public Rol(Long rolId, String rolNombre) {
        this.rolId = rolId;
        this.rolNombre = rolNombre;
    }


    public Long getRolId() {
        return this.rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public String getRolNombre() {
        return this.rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public Set<UsuarioRol> getUsuariosRoles() {
        return this.usuariosRoles;
    }

    public void setUsuariosRoles(Set<UsuarioRol> usuariosRoles) {
        this.usuariosRoles = usuariosRoles;
    }

    
}
