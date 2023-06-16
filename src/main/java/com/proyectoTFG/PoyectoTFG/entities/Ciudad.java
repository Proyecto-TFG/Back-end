package com.proyectoTFG.PoyectoTFG.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ciudades")
public class Ciudad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCiudad;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "idProvincia")
    private Long idProvincia;

    @Column(name = "idPais")
    private Long idPais;


    public Ciudad() {
    }

    public Ciudad(Long idCiudad, String nombre, Long idProvincia, Long idPais) {
        this.idCiudad = idCiudad;
        this.nombre = nombre;
        this.idProvincia = idProvincia;
        this.idPais = idPais;
    }


    public Long getIdCiudad() {
        return this.idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public Long getIdProvincia() {
        return this.idProvincia;
    }

    public void setIdProvincia(Long idProvincia) {
        this.idProvincia = idProvincia;
    }

    public Long getIdPais() {
        return this.idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }
    

}
