package com.proyectoTFG.PoyectoTFG.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_servicio")
public class DetalleServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalle;

    @Column(nullable = false)
    private Double subtotal;

    @Column(nullable = false)
    private String formaDePago;

    @Column
    private String notas;

    @OneToOne(mappedBy = "detalleServicio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Servicio servicio;


    public DetalleServicio() {
    }


    public DetalleServicio(Integer idDetalle, Double subtotal, String formaDePago, String notas, Servicio servicio) {
        this.idDetalle = idDetalle;
        this.subtotal = subtotal;
        this.formaDePago = formaDePago;
        this.notas = notas;
        this.servicio = servicio;
    }



    public Integer getIdDetalle() {
        return this.idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
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

    public Servicio getServicio() {
        return this.servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }


    
}
