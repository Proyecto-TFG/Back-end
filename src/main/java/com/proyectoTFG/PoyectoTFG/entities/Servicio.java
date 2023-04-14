package com.proyectoTFG.PoyectoTFG.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idServicio;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;

    @Column(nullable = false)
    private Boolean entregado;

    @ManyToOne
    @JoinColumn(name = "idDetalle")
    private DetalleServicio detalleServicio;

    @ManyToOne
    @JoinColumn(name = "idTrabajador")
    private Trabajador trabajador;


    public Servicio() {
    }


    public Servicio(Integer idServicio, Cliente cliente, Date fechaInicio, Date fechaEntrega, Boolean entregado, DetalleServicio detalleServicio, Trabajador trabajador) {
        this.idServicio = idServicio;
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
        this.entregado = entregado;
        this.detalleServicio = detalleServicio;
        this.trabajador = trabajador;
    }


    public Integer getIdServicio() {
        return this.idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaEntrega() {
        return this.fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Boolean isEntregado() {
        return this.entregado;
    }

    public Boolean getEntregado() {
        return this.entregado;
    }

    public void setEntregado(Boolean entregado) {
        this.entregado = entregado;
    }

    public DetalleServicio getDetalleServicio() {
        return this.detalleServicio;
    }

    public void setDetalleServicio(DetalleServicio detalleServicio) {
        this.detalleServicio = detalleServicio;
    }

    public Trabajador getTrabajador() {
        return this.trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }



    
}
