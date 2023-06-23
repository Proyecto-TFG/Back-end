package com.proyectoTFG.PoyectoTFG.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trabajadores")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idTrabajador")
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrabajador;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private Long idUsuario;


    public Trabajador() {
    }

    public Trabajador(String tipo) {
        this.tipo = tipo;
    }


    public Long getIdTrabajador() {
        return this.idTrabajador;
    }

    public void setIdTrabajador(Long idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public Long getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    

    


    

    

}
