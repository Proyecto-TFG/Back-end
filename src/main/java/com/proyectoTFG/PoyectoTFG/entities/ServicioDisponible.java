package com.proyectoTFG.PoyectoTFG.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "serviciosDisponibles")
public class ServicioDisponible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServicioDisponible;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private Integer duracion;


    public ServicioDisponible() {
    }

    public ServicioDisponible( String nombre, String descripcion, Double precio, Integer duracion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.duracion = duracion;
    }
    

    public Long getIdServicioDisponible() {
        return this.idServicioDisponible;
    }

    public void setIdServicioDisponible(Long idServicioDisponible) {
        this.idServicioDisponible = idServicioDisponible;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return this.precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getDuracion() {
        return this.duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    
}
