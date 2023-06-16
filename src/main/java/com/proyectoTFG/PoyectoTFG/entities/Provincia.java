package com.proyectoTFG.PoyectoTFG.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provincias")
public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProvincia;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "idPais")
    private Long idPais;


    public Provincia() {
    }


    public Provincia( String nombre, Long idPais) {
        this.nombre = nombre;
        this.idPais = idPais;
    }


    public Long getIdProvincia() {
        return this.idProvincia;
    }

    public void setIdProvincia(Long idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Long getIdPais() {
        return this.idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }



    
    
}
