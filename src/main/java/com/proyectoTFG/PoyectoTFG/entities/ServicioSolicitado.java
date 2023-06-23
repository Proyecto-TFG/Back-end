package com.proyectoTFG.PoyectoTFG.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "serviciosSolicitados")
public class ServicioSolicitado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServicioSolicitado;

    @Column(nullable = false)
    private Long idServicioDisponible;

    @Column(nullable = false)
    private Long idCliente;

    @Column(nullable = false)
    private String fecha;

    @Column(nullable = false)
    private String notasAdicionales;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private Integer duracion;

    public ServicioSolicitado() {
    }

    public ServicioSolicitado(Long idCliente, String fecha, String notasAdicionales, String estado, Double precio, Integer duracion) {
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.notasAdicionales = notasAdicionales;
        this.estado = estado;
        this.precio = precio;
        this.duracion = duracion;
    }


    public Long getIdServicioSolicitado() {
        return this.idServicioSolicitado;
    }

    public void setIdServicioSolicitado(Long idServicioSolicitado) {
        this.idServicioSolicitado = idServicioSolicitado;
    }

    public Long getIdServicioDisponible() {
        return this.idServicioDisponible;
    }

    public void setIdServicioDisponible(Long idServicioDisponible) {
        this.idServicioDisponible = idServicioDisponible;
    }

    public Long getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNotasAdicionales() {
        return this.notasAdicionales;
    }

    public void setNotasAdicionales(String notasAdicionales) {
        this.notasAdicionales = notasAdicionales;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
