package com.proyectoTFG.PoyectoTFG.entities;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idServicio;

    @Column(name = "idCliente", nullable = false)
    private Long idCliente;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;

    @Column(nullable = false)
    private Double subtotal;

    @Column(nullable = false)
    private String formaDePago;

    @Column
    private String notas;

    @Column
    private String nombre;

    @Column(nullable = false)
    private Boolean entregado;

    @Column(name = "idTrabajador", nullable = false)
    private Long idTrabajador;


    public Servicio() {
    }



    public Servicio(Long idCliente, Date fechaInicio, Date fechaEntrega, Double subtotal, String formaDePago, String notas, String nombre, Boolean entregado, Long idTrabajador) {
        this.idCliente = idCliente;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
        this.subtotal = subtotal;
        this.formaDePago = formaDePago;
        this.notas = notas;
        this.nombre = nombre;
        this.entregado = entregado;
        this.idTrabajador = idTrabajador;
    }
    

    public Integer getIdServicio() {
        return this.idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Long getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
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

    public Double getSubtotal() {
        return this.subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public String getFormaDePago() {
        return this.formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public String getNotas() {
        return this.notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Long getIdTrabajador() {
        return this.idTrabajador;
    }

    public void setIdTrabajador(Long idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

 


    
    
}
