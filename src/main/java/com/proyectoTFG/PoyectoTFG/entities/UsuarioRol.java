package com.proyectoTFG.PoyectoTFG.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios_roles")
public class UsuarioRol {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idUsuario")
    private Long idUsuario;

    @Column(name = "idRol")
    private Long rol;


    public UsuarioRol() {
    }

    public UsuarioRol(Long idUsuario, Long rol) {
        this.idUsuario = idUsuario;
        this.rol = rol;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuario() {
        return this.idUsuario;
    }

    public void setUsuario(Long usuario) {
        this.idUsuario = usuario;
    }

    public Long getRol() {
        return this.rol;
    }

    public void setRol(Long rol) {
        this.rol = rol;
    }
    
}
